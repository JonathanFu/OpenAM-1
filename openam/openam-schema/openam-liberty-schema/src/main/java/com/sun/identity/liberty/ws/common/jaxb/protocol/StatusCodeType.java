//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.6-b27-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.06.11 at 10:33:54 AM PDT 
//


package com.sun.identity.liberty.ws.common.jaxb.protocol;


/**
 * Java content class for StatusCodeType complex type.
 * <p>The following schema fragment specifies the expected content contained within this java content object. (defined at file:/Users/allan/A-SVN/trunk/opensso/products/federation/library/xsd/liberty/cs-sstc-schema-protocol-01.xsd line 148)
 * <p>
 * <pre>
 * &lt;complexType name="StatusCodeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:tc:SAML:1.0:protocol}StatusCode" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Value" use="required" type="{http://www.w3.org/2001/XMLSchema}QName" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 */
public interface StatusCodeType {


    /**
     * Gets the value of the statusCode property.
     * 
     * @return
     *     possible object is
     *     {@link com.sun.identity.liberty.ws.common.jaxb.protocol.StatusCodeElement}
     *     {@link com.sun.identity.liberty.ws.common.jaxb.protocol.StatusCodeType}
     */
    com.sun.identity.liberty.ws.common.jaxb.protocol.StatusCodeType getStatusCode();

    /**
     * Sets the value of the statusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link com.sun.identity.liberty.ws.common.jaxb.protocol.StatusCodeElement}
     *     {@link com.sun.identity.liberty.ws.common.jaxb.protocol.StatusCodeType}
     */
    void setStatusCode(com.sun.identity.liberty.ws.common.jaxb.protocol.StatusCodeType value);

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link javax.xml.namespace.QName}
     */
    javax.xml.namespace.QName getValue();

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link javax.xml.namespace.QName}
     */
    void setValue(javax.xml.namespace.QName value);

}
