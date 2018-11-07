package org.opentosca.container.api.legacy.resources.csar;

import static org.opentosca.container.api.legacy.osgi.servicegetter.FileRepositoryServiceHandler.getFileHandler;
import static org.opentosca.container.api.legacy.osgi.servicegetter.IOpenToscaControlServiceHandler.getOpenToscaControlService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.opentosca.container.api.legacy.resources.csar.content.ContentResource;
import org.opentosca.container.api.legacy.resources.csar.content.DirectoryResource;
import org.opentosca.container.api.legacy.resources.csar.content.FileResource;
import org.opentosca.container.api.legacy.resources.csar.servicetemplate.ServiceTemplatesResource;
import org.opentosca.container.api.legacy.resources.utilities.ResourceConstants;
import org.opentosca.container.api.legacy.resources.utilities.Utilities;
import org.opentosca.container.api.legacy.resources.xlink.Reference;
import org.opentosca.container.api.legacy.resources.xlink.References;
import org.opentosca.container.api.legacy.resources.xlink.XLinkConstants;
import org.opentosca.container.core.common.SystemException;
import org.opentosca.container.core.common.UserException;
import org.opentosca.container.core.model.AbstractFile;
import org.opentosca.container.core.model.csar.CSARContent;
import org.opentosca.container.core.model.csar.id.CSARID;
import org.opentosca.container.core.service.ICoreFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Resource represents a CSAR.<br />
 * <br />
 *
 * Copyright 2013 IAAS University of Stuttgart<br />
 * <br />
 *
 * @author Rene Trefft - trefftre@studi.informatik.uni-stuttgart.de
 * @author christian.endres@iaas.uni-stuttgart.de
 *
 *
 */
public class CSARResource {
    private static final Logger LOG = LoggerFactory.getLogger(CSARResource.class);

    // If csar is null, CSAR is not stored
    private final CSARContent CSAR;
    UriInfo uriInfo;

    public CSARResource(final CSARContent csar) {
        Objects.requireNonNull(csar);

        this.CSAR = csar;
        LOG.info("{} created: {}", this.getClass(), this);
    }

    @GET
    @Produces(ResourceConstants.LINKED_XML)
    public Response getReferencesXML(@Context final UriInfo uriInfo) {
        this.uriInfo = uriInfo;
        return Response.ok(this.getRefs().getXMLString()).build();
    }

    @GET
    @Produces(ResourceConstants.LINKED_JSON)
    public Response getReferencesJSON(@Context final UriInfo uriInfo) {
        this.uriInfo = uriInfo;
        return Response.ok(this.getRefs().getJSONString()).build();
    }

    public References getRefs() {
        if (this.CSAR == null) {
            return null;
        }
        final References refs = new References();
        refs.getReference().add(new Reference(Utilities.buildURI(this.uriInfo.getAbsolutePath().toString(), "Content"),
            XLinkConstants.SIMPLE, "Content"));
        refs.getReference().add(new Reference(Utilities.buildURI(this.uriInfo.getAbsolutePath().toString(), "MetaData"),
            XLinkConstants.SIMPLE, "MetaData"));
        refs.getReference()
            .add(new Reference(Utilities.buildURI(this.uriInfo.getAbsolutePath().toString(), "ServiceTemplates"),
                XLinkConstants.SIMPLE, "ServiceTemplates"));
        refs.getReference()
            .add(new Reference(Utilities.buildURI(this.uriInfo.getAbsolutePath().toString(), "TopologyPicture"),
                XLinkConstants.SIMPLE, "TopologyPicture"));
        LOG.info("Number of References in Root: {}", refs.getReference().size());
        // selflink
        refs.getReference()
            .add(new Reference(this.uriInfo.getAbsolutePath().toString(), XLinkConstants.SIMPLE, XLinkConstants.SELF));
        return refs;
    }

    @Path("Content")
    public ContentResource getContent() {
        return new ContentResource(this.CSAR);
    }

    @Produces("image/*; qs=2.0")
    @GET
    @Path("TopologyPicture")
    public Response getTopologyPicture() throws SystemException {
        final AbstractFile topologyPicture = this.CSAR.getTopologyPicture();
        if (topologyPicture != null) {
            final MediaType mt = new MediaType("image", "*");
            final InputStream is = topologyPicture.getFileAsInputStream();
            return Response.ok(is, mt)
                           .header("Content-Disposition", "attachment; filename=\"" + topologyPicture.getName() + "\"")
                           .build();
        }
        return Response.status(Status.NOT_FOUND).type(MediaType.TEXT_PLAIN)
                       .entity("No Topology Picture exists in CSAR \"" + this.CSAR.getCSARID() + "\".").build();
    }

    @GET
    @Path("MetaData")
    @Produces(ResourceConstants.APPLICATION_JSON)
    public Response getMetaDataJSON() throws SystemException {
        final DirectoryResource dir =
            (DirectoryResource) new ContentResource(this.CSAR).getDirectoryOrFile("SELFSERVICE-Metadata");
        final FileResource file = (FileResource) dir.getDirectoryOrFile("data.json");
        LOG.trace("Metadata file is of class: {}", file.getClass());
        return Response.status(Status.OK).type(MediaType.APPLICATION_JSON).entity(file.getAsJSONString()).build();
    }

    @Path("ServiceTemplates")
    public ServiceTemplatesResource getServiceTemplates() {
        return new ServiceTemplatesResource(this.CSAR);
    }

    /**
     * Exports this CSAR.
     *
     * @return CSAR as {@code application/octet-stream}. If an error occurred during exporting (e.g.
     *         during retrieving files from storage provider(s)) 500 (internal server error).
     * @throws SystemException
     * @throws UserException
     *
     * @see ICoreFileService#exportCSAR(CSARID)
     *
     */
    @GET
    @Produces(ResourceConstants.OCTET_STREAM)
    public Response downloadCSAR() throws SystemException, UserException {
        final CSARID csarID = this.CSAR.getCSARID();

        final java.nio.file.Path csarFile = getFileHandler().exportCSAR(csarID);
        InputStream csarFileInputStream;
        try {
            csarFileInputStream = Files.newInputStream(csarFile);
        } catch (final IOException e) {
            throw new SystemException("Retrieving input stream of file \"" + csarFile.toString() + "\" failed.", e);
        }

        // We add Content Disposition header, because exported CSAR file to
        // download should have the correct file name.
        return Response.ok("CSAR \"" + csarID + "\" was successfully exported to \"" + csarFile + "\".")
                       .entity(csarFileInputStream)
                       .header("Content-Disposition", "attachment; filename=\"" + csarID.getFileName() + "\"").build();

    }

    @DELETE
    @Produces("text/plain")
    public Response delete() {
        final CSARID csarID = this.CSAR.getCSARID();
        LOG.info("Deleting CSAR \"{}\".", csarID);
        final List<String> errors = getOpenToscaControlService().deleteCSAR(csarID);

        if (errors.isEmpty()) {
            return Response.ok("Deletion of CSAR " + "\"" + csarID + "\" was sucessful.").build();
        } 
        return Response.status(Status.INTERNAL_SERVER_ERROR)
                       .entity("Deletion of CSAR \"" + csarID + "\" failed with errors: " + errors.stream().collect(Collectors.joining(System.lineSeparator()))).build();
    }
}
