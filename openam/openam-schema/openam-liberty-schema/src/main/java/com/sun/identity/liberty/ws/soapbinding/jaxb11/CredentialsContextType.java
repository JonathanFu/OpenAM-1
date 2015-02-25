//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.6-b27-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.06.11 at 10:33:54 AM PDT 
//


package com.sun.identity.liberty.ws.soapbinding.jaxb11;


/**
 * Java content class for CredentialsContextType complex type.
 * <p>The following schema fragment specifies the expected content contained within this java content object. (defined at file:/Users/allan/A-SVN/trunk/opensso/products/federation/library/xsd/liberty/liberty-idwsf-soap-binding-v1.1.xsd line 71)
 * <p>
 * <pre>
 * &lt;complexType name="CredentialsContextType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:liberty:iff:2003-08}RequestAuthnContext" minOccurs="0"/>
 *         &lt;element name="SecurityMechID" type="{http://www.w3.org/2001/XMLSchema}anyURI" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute ref="{http://schemas.xmlsoap.org/soap/envelope/}actor"/>
 *       &lt;attribute ref="{http://schemas.xmlsoap.org/soap/envelope/}mustUnderstand"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 */
public interface CredentialsContextType {


    /**
     * Gets the value of the SecurityMechID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the SecurityMechID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSecurityMechID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link java.lang.String}
     * 
     */
    java.util.List getSecurityMechID();

    /**
     * Gets the value of the mustUnderstand property.
     * 
     */
    boolean isMustUnderstand();

    /**
     * Sets the value of the mustUnderstand property.
     * 
     */
    void setMustUnderstand(boolean value);

    /**
     * Gets the value of the actor property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getActor();

    /**
     * Sets the value of the actor property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setActor(java.lang.String value);

    /**
     * Gets the value of the requestAuthnContext property.
     * 
     * @return
     *     possible object is
     *     {@link com.sun.identity.liberty.ws.common.jaxb.ps.RequestAuthnContextType}
     *     {@link com.sun.identity.liberty.ws.common.jaxb.ps.RequestAuthnContextElement}
     */
    com.sun.identity.liberty.ws.common.jaxb.ps.RequestAuthnContextType getRequestAuthnContext();

    /**
     * Sets the value of the requestAuthnContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link com.sun.identity.liberty.ws.common.jaxb.ps.RequestAuthnContextType}
     *     {@link com.sun.identity.liberty.ws.common.jaxb.ps.RequestAuthnContextElement}
     */
    void setRequestAuthnContext(com.sun.identity.liberty.ws.common.jaxb.ps.RequestAuthnContextType value);

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getId();

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setId(java.lang.String value);

}
