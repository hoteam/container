
/**
 * SOAPEnvelope.java
 *
 * This file was auto-generated from WSDL by the Apache Axis2 version: SNAPSHOT Built on : Nov 10,
 * 2010 (06:34:21 UTC)
 */


package org.apache.axiom.soap.xsd;


/**
 * SOAPEnvelope bean class
 */

public abstract class SOAPEnvelope implements org.apache.axis2.databinding.ADBBean {
    /*
     * This type was generated from the piece of schema that had name = SOAPEnvelope Namespace URI =
     * http://soap.axiom.apache.org/xsd Namespace Prefix = ns26
     */


    /**
     *
     */
    private static final long serialVersionUID = -1882785473009669628L;

    /**
     * field for SOAPBodyFirstElementLocalName
     */


    protected java.lang.String localSOAPBodyFirstElementLocalName;

    /*
     * This tracker boolean wil be used to detect whether the user called the set method for this
     * attribute. It will be used to determine whether to include this field in the serialized XML
     */
    protected boolean localSOAPBodyFirstElementLocalNameTracker = false;


    /**
     * Auto generated getter method
     *
     * @return java.lang.String
     */
    public java.lang.String getSOAPBodyFirstElementLocalName() {
        return this.localSOAPBodyFirstElementLocalName;
    }



    /**
     * Auto generated setter method
     *
     * @param param SOAPBodyFirstElementLocalName
     */
    public void setSOAPBodyFirstElementLocalName(final java.lang.String param) {
        this.localSOAPBodyFirstElementLocalNameTracker = true;

        this.localSOAPBodyFirstElementLocalName = param;


    }


    /**
     * field for SOAPBodyFirstElementNS
     */


    protected org.apache.axiom.om.xsd.OMNamespace localSOAPBodyFirstElementNS;

    /*
     * This tracker boolean wil be used to detect whether the user called the set method for this
     * attribute. It will be used to determine whether to include this field in the serialized XML
     */
    protected boolean localSOAPBodyFirstElementNSTracker = false;


    /**
     * Auto generated getter method
     *
     * @return org.apache.axiom.om.xsd.OMNamespace
     */
    public org.apache.axiom.om.xsd.OMNamespace getSOAPBodyFirstElementNS() {
        return this.localSOAPBodyFirstElementNS;
    }



    /**
     * Auto generated setter method
     *
     * @param param SOAPBodyFirstElementNS
     */
    public void setSOAPBodyFirstElementNS(final org.apache.axiom.om.xsd.OMNamespace param) {
        this.localSOAPBodyFirstElementNSTracker = true;

        this.localSOAPBodyFirstElementNS = param;


    }


    /**
     * field for Body
     */


    protected org.apache.axiom.soap.xsd.SOAPBody localBody;

    /*
     * This tracker boolean wil be used to detect whether the user called the set method for this
     * attribute. It will be used to determine whether to include this field in the serialized XML
     */
    protected boolean localBodyTracker = false;


    /**
     * Auto generated getter method
     *
     * @return org.apache.axiom.soap.xsd.SOAPBody
     */
    public org.apache.axiom.soap.xsd.SOAPBody getBody() {
        return this.localBody;
    }



    /**
     * Auto generated setter method
     *
     * @param param Body
     */
    public void setBody(final org.apache.axiom.soap.xsd.SOAPBody param) {
        this.localBodyTracker = true;

        this.localBody = param;


    }


    /**
     * field for Header
     */


    protected org.apache.axiom.soap.xsd.SOAPHeader localHeader;

    /*
     * This tracker boolean wil be used to detect whether the user called the set method for this
     * attribute. It will be used to determine whether to include this field in the serialized XML
     */
    protected boolean localHeaderTracker = false;


    /**
     * Auto generated getter method
     *
     * @return org.apache.axiom.soap.xsd.SOAPHeader
     */
    public org.apache.axiom.soap.xsd.SOAPHeader getHeader() {
        return this.localHeader;
    }



    /**
     * Auto generated setter method
     *
     * @param param Header
     */
    public void setHeader(final org.apache.axiom.soap.xsd.SOAPHeader param) {
        this.localHeaderTracker = true;

        this.localHeader = param;


    }


    /**
     * field for Version
     */


    protected org.apache.axiom.soap.xsd.SOAPVersion localVersion;

    /*
     * This tracker boolean wil be used to detect whether the user called the set method for this
     * attribute. It will be used to determine whether to include this field in the serialized XML
     */
    protected boolean localVersionTracker = false;


    /**
     * Auto generated getter method
     *
     * @return org.apache.axiom.soap.xsd.SOAPVersion
     */
    public org.apache.axiom.soap.xsd.SOAPVersion getVersion() {
        return this.localVersion;
    }



    /**
     * Auto generated setter method
     *
     * @param param Version
     */
    public void setVersion(final org.apache.axiom.soap.xsd.SOAPVersion param) {
        this.localVersionTracker = true;

        this.localVersion = param;


    }



    /**
     *
     * @param parentQName
     * @param factory
     * @return org.apache.axiom.om.OMElement
     */
    @Override
    public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
                                                      final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {



        final org.apache.axiom.om.OMDataSource dataSource =
            new org.apache.axis2.databinding.ADBDataSource(this, parentQName);
        return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(parentQName, factory, dataSource);

    }

    @Override
    public void serialize(final javax.xml.namespace.QName parentQName,
                          final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException,
                                                                            org.apache.axis2.databinding.ADBException {
        serialize(parentQName, xmlWriter, false);
    }

    @Override
    public void serialize(final javax.xml.namespace.QName parentQName, final javax.xml.stream.XMLStreamWriter xmlWriter,
                          final boolean serializeType) throws javax.xml.stream.XMLStreamException,
                                                       org.apache.axis2.databinding.ADBException {



        java.lang.String prefix = null;
        java.lang.String namespace = null;


        prefix = parentQName.getPrefix();
        namespace = parentQName.getNamespaceURI();
        writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

        if (serializeType) {


            final java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://soap.axiom.apache.org/xsd");
            if (namespacePrefix != null && namespacePrefix.trim().length() > 0) {
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                               namespacePrefix + ":SOAPEnvelope", xmlWriter);
            } else {
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "SOAPEnvelope", xmlWriter);
            }


        }
        if (this.localSOAPBodyFirstElementLocalNameTracker) {
            namespace = "http://soap.axiom.apache.org/xsd";
            writeStartElement(null, namespace, "SOAPBodyFirstElementLocalName", xmlWriter);


            if (this.localSOAPBodyFirstElementLocalName == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(this.localSOAPBodyFirstElementLocalName);

            }

            xmlWriter.writeEndElement();
        }
        if (this.localSOAPBodyFirstElementNSTracker) {
            if (this.localSOAPBodyFirstElementNS == null) {

                writeStartElement(null, "http://soap.axiom.apache.org/xsd", "SOAPBodyFirstElementNS", xmlWriter);

                // write the nil attribute
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
                xmlWriter.writeEndElement();
            } else {
                this.localSOAPBodyFirstElementNS.serialize(new javax.xml.namespace.QName(
                    "http://soap.axiom.apache.org/xsd", "SOAPBodyFirstElementNS"), xmlWriter);
            }
        }
        if (this.localBodyTracker) {
            if (this.localBody == null) {

                writeStartElement(null, "http://soap.axiom.apache.org/xsd", "body", xmlWriter);

                // write the nil attribute
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
                xmlWriter.writeEndElement();
            } else {
                this.localBody.serialize(new javax.xml.namespace.QName("http://soap.axiom.apache.org/xsd", "body"),
                                         xmlWriter);
            }
        }
        if (this.localHeaderTracker) {
            if (this.localHeader == null) {

                writeStartElement(null, "http://soap.axiom.apache.org/xsd", "header", xmlWriter);

                // write the nil attribute
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
                xmlWriter.writeEndElement();
            } else {
                this.localHeader.serialize(new javax.xml.namespace.QName("http://soap.axiom.apache.org/xsd", "header"),
                                           xmlWriter);
            }
        }
        if (this.localVersionTracker) {
            if (this.localVersion == null) {

                writeStartElement(null, "http://soap.axiom.apache.org/xsd", "version", xmlWriter);

                // write the nil attribute
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
                xmlWriter.writeEndElement();
            } else {
                this.localVersion.serialize(new javax.xml.namespace.QName("http://soap.axiom.apache.org/xsd",
                    "version"), xmlWriter);
            }
        }
        xmlWriter.writeEndElement();


    }

    private static java.lang.String generatePrefix(final java.lang.String namespace) {
        if (namespace.equals("http://soap.axiom.apache.org/xsd")) {
            return "ns26";
        }
        return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /**
     * Utility method to write an element start tag.
     */
    private void writeStartElement(java.lang.String prefix, final java.lang.String namespace,
                                   final java.lang.String localPart,
                                   final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
        final java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
        if (writerPrefix != null) {
            xmlWriter.writeStartElement(namespace, localPart);
        } else {
            if (namespace.length() == 0) {
                prefix = "";
            } else if (prefix == null) {
                prefix = generatePrefix(namespace);
            }

            xmlWriter.writeStartElement(prefix, localPart, namespace);
            xmlWriter.writeNamespace(prefix, namespace);
            xmlWriter.setPrefix(prefix, namespace);
        }
    }

    /**
     * Util method to write an attribute with the ns prefix
     */
    private void writeAttribute(final java.lang.String prefix, final java.lang.String namespace,
                                final java.lang.String attName, final java.lang.String attValue,
                                final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
        if (xmlWriter.getPrefix(namespace) == null) {
            xmlWriter.writeNamespace(prefix, namespace);
            xmlWriter.setPrefix(prefix, namespace);
        }
        xmlWriter.writeAttribute(namespace, attName, attValue);
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeAttribute(final java.lang.String namespace, final java.lang.String attName,
                                final java.lang.String attValue,
                                final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
        if (namespace.equals("")) {
            xmlWriter.writeAttribute(attName, attValue);
        } else {
            registerPrefix(xmlWriter, namespace);
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }
    }


    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeQNameAttribute(final java.lang.String namespace, final java.lang.String attName,
                                     final javax.xml.namespace.QName qname,
                                     final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

        final java.lang.String attributeNamespace = qname.getNamespaceURI();
        java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
        if (attributePrefix == null) {
            attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
        }
        java.lang.String attributeValue;
        if (attributePrefix.trim().length() > 0) {
            attributeValue = attributePrefix + ":" + qname.getLocalPart();
        } else {
            attributeValue = qname.getLocalPart();
        }

        if (namespace.equals("")) {
            xmlWriter.writeAttribute(attName, attributeValue);
        } else {
            registerPrefix(xmlWriter, namespace);
            xmlWriter.writeAttribute(namespace, attName, attributeValue);
        }
    }

    /**
     * method to handle Qnames
     */

    private void writeQName(final javax.xml.namespace.QName qname,
                            final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
        final java.lang.String namespaceURI = qname.getNamespaceURI();
        if (namespaceURI != null) {
            java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
            if (prefix == null) {
                prefix = generatePrefix(namespaceURI);
                xmlWriter.writeNamespace(prefix, namespaceURI);
                xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0) {
                xmlWriter.writeCharacters(prefix + ":"
                    + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            } else {
                // i.e this is the default namespace
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }

        } else {
            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        }
    }

    private void writeQNames(final javax.xml.namespace.QName[] qnames,
                             final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

        if (qnames != null) {
            // we have to store this data until last moment since it is not possible to write any
            // namespace data after writing the charactor data
            final java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
            java.lang.String namespaceURI = null;
            java.lang.String prefix = null;

            for (int i = 0; i < qnames.length; i++) {
                if (i > 0) {
                    stringToWrite.append(" ");
                }
                namespaceURI = qnames[i].getNamespaceURI();
                if (namespaceURI != null) {
                    prefix = xmlWriter.getPrefix(namespaceURI);
                    if (prefix == null || prefix.length() == 0) {
                        prefix = generatePrefix(namespaceURI);
                        xmlWriter.writeNamespace(prefix, namespaceURI);
                        xmlWriter.setPrefix(prefix, namespaceURI);
                    }

                    if (prefix.trim().length() > 0) {
                        stringToWrite.append(prefix).append(":")
                                     .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                } else {
                    stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                }
            }
            xmlWriter.writeCharacters(stringToWrite.toString());
        }

    }


    /**
     * Register a namespace prefix
     */
    private java.lang.String registerPrefix(final javax.xml.stream.XMLStreamWriter xmlWriter,
                                            final java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
        java.lang.String prefix = xmlWriter.getPrefix(namespace);
        if (prefix == null) {
            prefix = generatePrefix(namespace);
            while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
            }
            xmlWriter.writeNamespace(prefix, namespace);
            xmlWriter.setPrefix(prefix, namespace);
        }
        return prefix;
    }



    /**
     * databinding method to get an XML representation of this object
     *
     */
    @Override
    public javax.xml.stream.XMLStreamReader getPullParser(final javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {



        final java.util.ArrayList elementList = new java.util.ArrayList();
        final java.util.ArrayList attribList = new java.util.ArrayList();

        if (this.localSOAPBodyFirstElementLocalNameTracker) {
            elementList.add(new javax.xml.namespace.QName("http://soap.axiom.apache.org/xsd",
                "SOAPBodyFirstElementLocalName"));

            elementList.add(this.localSOAPBodyFirstElementLocalName == null ? null
                                                                            : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(this.localSOAPBodyFirstElementLocalName));
        }
        if (this.localSOAPBodyFirstElementNSTracker) {
            elementList.add(new javax.xml.namespace.QName("http://soap.axiom.apache.org/xsd",
                "SOAPBodyFirstElementNS"));


            elementList.add(this.localSOAPBodyFirstElementNS == null ? null : this.localSOAPBodyFirstElementNS);
        }
        if (this.localBodyTracker) {
            elementList.add(new javax.xml.namespace.QName("http://soap.axiom.apache.org/xsd", "body"));


            elementList.add(this.localBody == null ? null : this.localBody);
        }
        if (this.localHeaderTracker) {
            elementList.add(new javax.xml.namespace.QName("http://soap.axiom.apache.org/xsd", "header"));


            elementList.add(this.localHeader == null ? null : this.localHeader);
        }
        if (this.localVersionTracker) {
            elementList.add(new javax.xml.namespace.QName("http://soap.axiom.apache.org/xsd", "version"));


            elementList.add(this.localVersion == null ? null : this.localVersion);
        }

        return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(),
            attribList.toArray());



    }



    /**
     * Factory class that keeps the parse method
     */
    public static class Factory {



        /**
         * static method to create the object Precondition: If this object is an element, the current or
         * next start element starts this object and any intervening reader events are ignorable If this
         * object is not an element, it is a complex type and the reader is at the event just after the
         * outer start element Postcondition: If this object is an element, the reader is positioned at its
         * end element If this object is a complex type, the reader is positioned at the end element of its
         * outer element
         */
        public static SOAPEnvelope parse(final javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
            final SOAPEnvelope object = null;

            final int event;
            java.lang.String nillableValue = null;
            final java.lang.String prefix = "";
            final java.lang.String namespaceuri = "";
            try {

                while (!reader.isStartElement() && !reader.isEndElement()) {
                    reader.next();
                }


                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                    final java.lang.String fullTypeName =
                        reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
                    if (fullTypeName != null) {
                        java.lang.String nsPrefix = null;
                        if (fullTypeName.indexOf(":") > -1) {
                            nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                        }
                        nsPrefix = nsPrefix == null ? "" : nsPrefix;

                        final java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                        if (!"SOAPEnvelope".equals(type)) {
                            // find namespace for the prefix
                            final java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                            return (SOAPEnvelope) org.apache.axis2.transaction.xsd.ExtensionMapper.getTypeObject(nsUri,
                                                                                                                 type,
                                                                                                                 reader);
                        }

                        throw new org.apache.axis2.databinding.ADBException(
                            "The an abstract class can not be instantiated !!!");


                    }


                }



                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                final java.util.Vector handledAttributes = new java.util.Vector();



                reader.next();


                while (!reader.isStartElement() && !reader.isEndElement()) {
                    reader.next();
                }

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://soap.axiom.apache.org/xsd",
                    "SOAPBodyFirstElementLocalName").equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                        final java.lang.String content = reader.getElementText();

                        object.setSOAPBodyFirstElementLocalName(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                    } else {


                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();

                } // End of if for expected property start element

                else {

                }


                while (!reader.isStartElement() && !reader.isEndElement()) {
                    reader.next();
                }

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://soap.axiom.apache.org/xsd",
                    "SOAPBodyFirstElementNS").equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        object.setSOAPBodyFirstElementNS(null);
                        reader.next();

                        reader.next();

                    } else {

                        object.setSOAPBodyFirstElementNS(org.apache.axiom.om.xsd.OMNamespace.Factory.parse(reader));

                        reader.next();
                    }
                } // End of if for expected property start element

                else {

                }


                while (!reader.isStartElement() && !reader.isEndElement()) {
                    reader.next();
                }

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://soap.axiom.apache.org/xsd",
                    "body").equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        object.setBody(null);
                        reader.next();

                        reader.next();

                    } else {

                        object.setBody(org.apache.axiom.soap.xsd.SOAPBody.Factory.parse(reader));

                        reader.next();
                    }
                } // End of if for expected property start element

                else {

                }


                while (!reader.isStartElement() && !reader.isEndElement()) {
                    reader.next();
                }

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://soap.axiom.apache.org/xsd",
                    "header").equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        object.setHeader(null);
                        reader.next();

                        reader.next();

                    } else {

                        object.setHeader(org.apache.axiom.soap.xsd.SOAPHeader.Factory.parse(reader));

                        reader.next();
                    }
                } // End of if for expected property start element

                else {

                }


                while (!reader.isStartElement() && !reader.isEndElement()) {
                    reader.next();
                }

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://soap.axiom.apache.org/xsd",
                    "version").equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        object.setVersion(null);
                        reader.next();

                        reader.next();

                    } else {

                        object.setVersion(org.apache.axiom.soap.xsd.SOAPVersion.Factory.parse(reader));

                        reader.next();
                    }
                } // End of if for expected property start element

                else {

                }

                while (!reader.isStartElement() && !reader.isEndElement()) {
                    reader.next();
                }

                if (reader.isStartElement()) {
                    // A start element we are not expecting indicates a trailing invalid
                    // property
                    throw new org.apache.axis2.databinding.ADBException(
                        "Unexpected subelement " + reader.getLocalName());
                }



            }
            catch (final javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

    }// end of factory class



}

