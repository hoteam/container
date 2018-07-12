package org.opentosca.container.core.model.csar;

import java.util.List;

import org.eclipse.winery.model.csar.toscametafile.TOSCAMetaFile;
import org.eclipse.winery.model.selfservice.Application;
import org.eclipse.winery.model.tosca.TArtifactTemplate;
import org.eclipse.winery.model.tosca.TDefinitions;
import org.eclipse.winery.model.tosca.TExportedOperation;
import org.eclipse.winery.model.tosca.TNodeType;
import org.eclipse.winery.model.tosca.TPlan;
import org.eclipse.winery.model.tosca.TServiceTemplate;
import org.opentosca.container.core.model.AbstractFile;

public interface Csar {
    
    public CsarId id();
    
    public List<TArtifactTemplate> artifactTemplates();

    public List<TServiceTemplate> serviceTemplates();
    
    public TServiceTemplate entryServiceTemplate();
    
    public List<TDefinitions> definitions();
    public List<TExportedOperation> exportedOperations();
    
    public List<TPlan> plans();
    public List<TNodeType> nodeTypes();
    
    public String description();
    // FIXME decide on Path / File / Binary Representation / ??
    public AbstractFile topologyPicture();

    public Application selfserviceMetadata();

}