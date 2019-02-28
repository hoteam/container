package org.opentosca.container.core.model.endpoint.wsdl;

import java.net.URI;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.namespace.QName;

import org.eclipse.persistence.annotations.Convert;
import org.eclipse.persistence.annotations.Converter;
import org.eclipse.persistence.annotations.Converters;
import org.opentosca.container.core.common.jpa.QNameConverter;
import org.opentosca.container.core.model.csar.CsarId;
import org.opentosca.container.core.model.endpoint.AbstractEndpoint;

/**
 * This class Represents a WSDL-Endpoint (an endpoint which points to a SOAP-Operation of a WSDL).
 * For the fields of this class refer to the WSDL operation element in the TOSCA-Specification.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Converters({
    @Converter(name = QNameConverter.name, converterClass = QNameConverter.class)
})
@Table(name = WSDLEndpoint.tableName,
       uniqueConstraints = @UniqueConstraint(columnNames = {"portType", "csarId", "managingContainer",
                                                            "serviceInstanceID"}))
@NamedQueries({
    @NamedQuery(name=WSDLEndpoint.getWSDLEndpointByPortType, query=WSDLEndpoint.queryByPortType)
})
public class WSDLEndpoint extends AbstractEndpoint {

    // Table Name
    protected final static String tableName = "WSDLEndpoint";

    // NamedQuery names and queries
    protected final static String queryByPortType = "SELECT e FROM WSDLEndpoint e where e.triggeringContainer = :triggeringContainer and e.csarId = :csarId and e.PortType = :portType";
    public static final String getWSDLEndpointByPortType = "wsdlEndpointByPortType";
    
    // Converter to Convert QNames to String, and back from String to QName.
    // Used when persisting, so we can Query for QName-Objects.
    @Basic
    @Convert(QNameConverter.name)
    @Column(name = "PortType")
    private QName PortType;

    // NodeTypeImplementation/RelationshipTypeImplementation and IA name are there to identify
    // specific IAs
    @Basic
    @Convert(QNameConverter.name)
    @Column(name = "TypeImplementation")
    private QName TypeImplementation;

    @Basic
    @Column(name = "IaName")
    private String IaName;

    // only the planid is used for plan endpoints, cause in tosca the id for a
    // plan must be unique in the targetnamespace
    @Basic
    @Convert(QNameConverter.name)
    @Column(name = "PlanId")
    private QName PlanId;

    public WSDLEndpoint() {
        super();
    }
    
    // if planid is set serviceInstanceID, nodeTypeimpl and iaName must be "null"
    public WSDLEndpoint(final URI uri, final QName portType, final String triggeringContainer,
                        final String managingContainer, final CsarId csarId, final Long serviceInstanceID,
                        final QName planid, final QName nodeTypeImplementation, final String iaName) {
        super(uri, triggeringContainer, managingContainer, csarId, serviceInstanceID);
        setPortType(portType);
        setIaName(iaName);
        setPlanId(planid);
        setTypeImplementation(nodeTypeImplementation);
    }

    public QName getPortType() {
        return this.PortType;
    }

    public void setPortType(final QName portType) {
        this.PortType = portType;
    }

    public QName getTypeImplementation() {
        return this.TypeImplementation;
    }

    public void setTypeImplementation(final QName nodeTypeImplementation) {
        this.TypeImplementation = nodeTypeImplementation;
    }

    public QName getPlanId() {
        return this.PlanId;
    }

    public void setPlanId(final QName planId) {
        this.PlanId = planId;
    }

    public String getIaName() {
        return this.IaName;
    }

    public void setIaName(final String iaName) {
        this.IaName = iaName;
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof WSDLEndpoint)) {
            return false;
        }

        final WSDLEndpoint compareEndpoint = (WSDLEndpoint) o;
        if (compareEndpoint.getId() != getId()) {
            return false;
        }
        if (!compareEndpoint.getCsarId().equals(getCsarId())) {
            return false;
        }
        return true;
    }

}