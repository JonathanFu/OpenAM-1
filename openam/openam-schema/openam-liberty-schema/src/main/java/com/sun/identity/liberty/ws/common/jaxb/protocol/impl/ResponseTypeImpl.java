//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.6-b27-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.06.11 at 10:33:54 AM PDT 
//


package com.sun.identity.liberty.ws.common.jaxb.protocol.impl;

public class ResponseTypeImpl
    extends com.sun.identity.liberty.ws.common.jaxb.protocol.impl.ResponseAbstractTypeImpl
    implements com.sun.identity.liberty.ws.common.jaxb.protocol.ResponseType, com.sun.xml.bind.JAXBObject, com.sun.identity.federation.jaxb.entityconfig.impl.runtime.UnmarshallableObject, com.sun.identity.federation.jaxb.entityconfig.impl.runtime.XMLSerializable, com.sun.identity.federation.jaxb.entityconfig.impl.runtime.ValidatableObject
{

    protected com.sun.xml.bind.util.ListImpl _Assertion;
    protected com.sun.identity.liberty.ws.common.jaxb.protocol.StatusType _Status;
    public final static java.lang.Class version = (com.sun.identity.liberty.ws.common.jaxb.protocol.impl.JAXBVersion.class);
    private static com.sun.msv.grammar.Grammar schemaFragment;

    private final static java.lang.Class PRIMARY_INTERFACE_CLASS() {
        return (com.sun.identity.liberty.ws.common.jaxb.protocol.ResponseType.class);
    }

    protected com.sun.xml.bind.util.ListImpl _getAssertion() {
        if (_Assertion == null) {
            _Assertion = new com.sun.xml.bind.util.ListImpl(new java.util.ArrayList());
        }
        return _Assertion;
    }

    public java.util.List getAssertion() {
        return _getAssertion();
    }

    public com.sun.identity.liberty.ws.common.jaxb.protocol.StatusType getStatus() {
        return _Status;
    }

    public void setStatus(com.sun.identity.liberty.ws.common.jaxb.protocol.StatusType value) {
        _Status = value;
    }

    public com.sun.identity.federation.jaxb.entityconfig.impl.runtime.UnmarshallingEventHandler createUnmarshaller(com.sun.identity.federation.jaxb.entityconfig.impl.runtime.UnmarshallingContext context) {
        return new com.sun.identity.liberty.ws.common.jaxb.protocol.impl.ResponseTypeImpl.Unmarshaller(context);
    }

    public void serializeBody(com.sun.identity.federation.jaxb.entityconfig.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        int idx1 = 0;
        final int len1 = ((_Assertion == null)? 0 :_Assertion.size());
        super.serializeBody(context);
        if (_Status instanceof javax.xml.bind.Element) {
            context.childAsBody(((com.sun.xml.bind.JAXBObject) _Status), "Status");
        } else {
            context.startElement("urn:oasis:names:tc:SAML:1.0:protocol", "Status");
            context.childAsURIs(((com.sun.xml.bind.JAXBObject) _Status), "Status");
            context.endNamespaceDecls();
            context.childAsAttributes(((com.sun.xml.bind.JAXBObject) _Status), "Status");
            context.endAttributes();
            context.childAsBody(((com.sun.xml.bind.JAXBObject) _Status), "Status");
            context.endElement();
        }
        while (idx1 != len1) {
            if (_Assertion.get(idx1) instanceof javax.xml.bind.Element) {
                context.childAsBody(((com.sun.xml.bind.JAXBObject) _Assertion.get(idx1 ++)), "Assertion");
            } else {
                context.startElement("urn:oasis:names:tc:SAML:1.0:assertion", "Assertion");
                int idx_2 = idx1;
                context.childAsURIs(((com.sun.xml.bind.JAXBObject) _Assertion.get(idx_2 ++)), "Assertion");
                context.endNamespaceDecls();
                int idx_3 = idx1;
                context.childAsAttributes(((com.sun.xml.bind.JAXBObject) _Assertion.get(idx_3 ++)), "Assertion");
                context.endAttributes();
                context.childAsBody(((com.sun.xml.bind.JAXBObject) _Assertion.get(idx1 ++)), "Assertion");
                context.endElement();
            }
        }
    }

    public void serializeAttributes(com.sun.identity.federation.jaxb.entityconfig.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        int idx1 = 0;
        final int len1 = ((_Assertion == null)? 0 :_Assertion.size());
        super.serializeAttributes(context);
        if (_Status instanceof javax.xml.bind.Element) {
            context.childAsAttributes(((com.sun.xml.bind.JAXBObject) _Status), "Status");
        }
        while (idx1 != len1) {
            if (_Assertion.get(idx1) instanceof javax.xml.bind.Element) {
                context.childAsAttributes(((com.sun.xml.bind.JAXBObject) _Assertion.get(idx1 ++)), "Assertion");
            } else {
                idx1 += 1;
            }
        }
    }

    public void serializeURIs(com.sun.identity.federation.jaxb.entityconfig.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        int idx1 = 0;
        final int len1 = ((_Assertion == null)? 0 :_Assertion.size());
        super.serializeURIs(context);
        if (_Status instanceof javax.xml.bind.Element) {
            context.childAsURIs(((com.sun.xml.bind.JAXBObject) _Status), "Status");
        }
        while (idx1 != len1) {
            if (_Assertion.get(idx1) instanceof javax.xml.bind.Element) {
                context.childAsURIs(((com.sun.xml.bind.JAXBObject) _Assertion.get(idx1 ++)), "Assertion");
            } else {
                idx1 += 1;
            }
        }
    }

    public java.lang.Class getPrimaryInterface() {
        return (com.sun.identity.liberty.ws.common.jaxb.protocol.ResponseType.class);
    }

    public com.sun.msv.verifier.DocumentDeclaration createRawValidator() {
        if (schemaFragment == null) {
            schemaFragment = com.sun.xml.bind.validator.SchemaDeserializer.deserialize((
 "\u00ac\u00ed\u0000\u0005sr\u0000\u001fcom.sun.msv.grammar.SequenceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001dcom.su"
+"n.msv.grammar.BinaryExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0004exp1t\u0000 Lcom/sun/msv/gra"
+"mmar/Expression;L\u0000\u0004exp2q\u0000~\u0000\u0002xr\u0000\u001ecom.sun.msv.grammar.Expressi"
+"on\u00f8\u0018\u0082\u00e8N5~O\u0002\u0000\u0002L\u0000\u0013epsilonReducibilityt\u0000\u0013Ljava/lang/Boolean;L\u0000\u000b"
+"expandedExpq\u0000~\u0000\u0002xpppsq\u0000~\u0000\u0000ppsq\u0000~\u0000\u0000ppsq\u0000~\u0000\u0000ppsq\u0000~\u0000\u0000ppsq\u0000~\u0000\u0000pp"
+"sq\u0000~\u0000\u0000ppsq\u0000~\u0000\u0000ppsr\u0000\u001dcom.sun.msv.grammar.ChoiceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000"
+"xq\u0000~\u0000\u0001ppsq\u0000~\u0000\rsr\u0000\u0011java.lang.Boolean\u00cd r\u0080\u00d5\u009c\u00fa\u00ee\u0002\u0000\u0001Z\u0000\u0005valuexp\u0000psr"
+"\u0000\'com.sun.msv.grammar.trex.ElementPattern\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\tnameC"
+"lasst\u0000\u001fLcom/sun/msv/grammar/NameClass;xr\u0000\u001ecom.sun.msv.gramma"
+"r.ElementExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002Z\u0000\u001aignoreUndeclaredAttributesL\u0000\fconte"
+"ntModelq\u0000~\u0000\u0002xq\u0000~\u0000\u0003q\u0000~\u0000\u0011p\u0000sq\u0000~\u0000\rppsr\u0000 com.sun.msv.grammar.One"
+"OrMoreExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001ccom.sun.msv.grammar.UnaryExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001"
+"\u0002\u0000\u0001L\u0000\u0003expq\u0000~\u0000\u0002xq\u0000~\u0000\u0003q\u0000~\u0000\u0011psr\u0000 com.sun.msv.grammar.AttributeE"
+"xp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0003expq\u0000~\u0000\u0002L\u0000\tnameClassq\u0000~\u0000\u0013xq\u0000~\u0000\u0003q\u0000~\u0000\u0011psr\u00002com"
+".sun.msv.grammar.Expression$AnyStringExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq"
+"\u0000~\u0000\u0003sq\u0000~\u0000\u0010\u0001q\u0000~\u0000\u001dsr\u0000 com.sun.msv.grammar.AnyNameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001"
+"\u0002\u0000\u0000xr\u0000\u001dcom.sun.msv.grammar.NameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpsr\u00000com.sun"
+".msv.grammar.Expression$EpsilonExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003q\u0000"
+"~\u0000\u001eq\u0000~\u0000#sr\u0000#com.sun.msv.grammar.SimpleNameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000"
+"\tlocalNamet\u0000\u0012Ljava/lang/String;L\u0000\fnamespaceURIq\u0000~\u0000%xq\u0000~\u0000 t\u0000?"
+"com.sun.identity.liberty.ws.common.jaxb.xmlsig.SignatureElem"
+"entt\u0000+http://java.sun.com/jaxb/xjc/dummy-elementssq\u0000~\u0000\u0012q\u0000~\u0000\u0011"
+"p\u0000sq\u0000~\u0000\u0000ppsq\u0000~\u0000\u0012pp\u0000sq\u0000~\u0000\rppsq\u0000~\u0000\u0017q\u0000~\u0000\u0011psq\u0000~\u0000\u001aq\u0000~\u0000\u0011pq\u0000~\u0000\u001dq\u0000~\u0000"
+"!q\u0000~\u0000#sq\u0000~\u0000$t\u0000<com.sun.identity.liberty.ws.common.jaxb.xmlsi"
+"g.SignatureTypeq\u0000~\u0000(sq\u0000~\u0000\rppsq\u0000~\u0000\u001aq\u0000~\u0000\u0011psr\u0000\u001bcom.sun.msv.gram"
+"mar.DataExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0003L\u0000\u0002dtt\u0000\u001fLorg/relaxng/datatype/Datatype"
+";L\u0000\u0006exceptq\u0000~\u0000\u0002L\u0000\u0004namet\u0000\u001dLcom/sun/msv/util/StringPair;xq\u0000~\u0000\u0003"
+"q\u0000~\u0000\u0011psr\u0000\"com.sun.msv.datatype.xsd.QnameType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000*c"
+"om.sun.msv.datatype.xsd.BuiltinAtomicType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000%com."
+"sun.msv.datatype.xsd.ConcreteType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\'com.sun.msv."
+"datatype.xsd.XSDatatypeImpl\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0003L\u0000\fnamespaceUriq\u0000~\u0000%L\u0000"
+"\btypeNameq\u0000~\u0000%L\u0000\nwhiteSpacet\u0000.Lcom/sun/msv/datatype/xsd/Whit"
+"eSpaceProcessor;xpt\u0000 http://www.w3.org/2001/XMLSchemat\u0000\u0005QNam"
+"esr\u00005com.sun.msv.datatype.xsd.WhiteSpaceProcessor$Collapse\u0000\u0000"
+"\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000,com.sun.msv.datatype.xsd.WhiteSpaceProcessor\u0000\u0000\u0000"
+"\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpsr\u00000com.sun.msv.grammar.Expression$NullSetExpressi"
+"on\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003q\u0000~\u0000\u0011psr\u0000\u001bcom.sun.msv.util.StringPair\u00d0t\u001ej"
+"B\u008f\u008d\u00a0\u0002\u0000\u0002L\u0000\tlocalNameq\u0000~\u0000%L\u0000\fnamespaceURIq\u0000~\u0000%xpq\u0000~\u0000>q\u0000~\u0000=sq\u0000~"
+"\u0000$t\u0000\u0004typet\u0000)http://www.w3.org/2001/XMLSchema-instanceq\u0000~\u0000#sq"
+"\u0000~\u0000$t\u0000\tSignaturet\u0000\"http://www.w3.org/2000/09/xmldsig#q\u0000~\u0000#sq"
+"\u0000~\u0000\rppsq\u0000~\u0000\u0012pp\u0000sq\u0000~\u0000\rppsq\u0000~\u0000\u0017q\u0000~\u0000\u0011psq\u0000~\u0000\u001aq\u0000~\u0000\u0011pq\u0000~\u0000\u001dq\u0000~\u0000!q\u0000~"
+"\u0000#sq\u0000~\u0000$t\u0000>com.sun.identity.liberty.ws.common.jaxb.protocol."
+"StatusElementq\u0000~\u0000(sq\u0000~\u0000\u0012pp\u0000sq\u0000~\u0000\u0000ppsq\u0000~\u0000\u0012pp\u0000sq\u0000~\u0000\rppsq\u0000~\u0000\u0017q\u0000"
+"~\u0000\u0011psq\u0000~\u0000\u001aq\u0000~\u0000\u0011pq\u0000~\u0000\u001dq\u0000~\u0000!q\u0000~\u0000#sq\u0000~\u0000$t\u0000;com.sun.identity.lib"
+"erty.ws.common.jaxb.protocol.StatusTypeq\u0000~\u0000(sq\u0000~\u0000\rppsq\u0000~\u0000\u001aq\u0000"
+"~\u0000\u0011pq\u0000~\u00006q\u0000~\u0000Fq\u0000~\u0000#sq\u0000~\u0000$t\u0000\u0006Statust\u0000$urn:oasis:names:tc:SAML"
+":1.0:protocolsq\u0000~\u0000\rppsq\u0000~\u0000\u0017q\u0000~\u0000\u0011psq\u0000~\u0000\rq\u0000~\u0000\u0011psq\u0000~\u0000\u0012q\u0000~\u0000\u0011p\u0000sq"
+"\u0000~\u0000\rppsq\u0000~\u0000\u0017q\u0000~\u0000\u0011psq\u0000~\u0000\u001aq\u0000~\u0000\u0011pq\u0000~\u0000\u001dq\u0000~\u0000!q\u0000~\u0000#sq\u0000~\u0000$t\u0000Bcom.su"
+"n.identity.liberty.ws.common.jaxb.assertion.AssertionElement"
+"q\u0000~\u0000(sq\u0000~\u0000\u0012q\u0000~\u0000\u0011p\u0000sq\u0000~\u0000\u0000ppsq\u0000~\u0000\u0012pp\u0000sq\u0000~\u0000\rppsq\u0000~\u0000\u0017q\u0000~\u0000\u0011psq\u0000~\u0000"
+"\u001aq\u0000~\u0000\u0011pq\u0000~\u0000\u001dq\u0000~\u0000!q\u0000~\u0000#sq\u0000~\u0000$t\u0000?com.sun.identity.liberty.ws.c"
+"ommon.jaxb.assertion.AssertionTypeq\u0000~\u0000(sq\u0000~\u0000\rppsq\u0000~\u0000\u001aq\u0000~\u0000\u0011pq"
+"\u0000~\u00006q\u0000~\u0000Fq\u0000~\u0000#sq\u0000~\u0000$t\u0000\tAssertiont\u0000%urn:oasis:names:tc:SAML:1"
+".0:assertionq\u0000~\u0000#sq\u0000~\u0000\rppsq\u0000~\u0000\u001aq\u0000~\u0000\u0011psq\u0000~\u00003ppsr\u0000#com.sun.msv"
+".datatype.xsd.NcnameType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\"com.sun.msv.datatype."
+"xsd.TokenType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000#com.sun.msv.datatype.xsd.StringT"
+"ype\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001Z\u0000\risAlwaysValidxq\u0000~\u00008q\u0000~\u0000=t\u0000\u0006NCNameq\u0000~\u0000A\u0000q\u0000~\u0000"
+"Csq\u0000~\u0000Dq\u0000~\u0000}q\u0000~\u0000=sq\u0000~\u0000$t\u0000\fInResponseTot\u0000\u0000q\u0000~\u0000#sq\u0000~\u0000\u001appsq\u0000~\u00003"
+"ppsr\u0000%com.sun.msv.datatype.xsd.DateTimeType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000)co"
+"m.sun.msv.datatype.xsd.DateTimeBaseType\u0014W\u001a@3\u00a5\u00b4\u00e5\u0002\u0000\u0000xq\u0000~\u00008q\u0000~\u0000"
+"=t\u0000\bdateTimeq\u0000~\u0000Aq\u0000~\u0000Csq\u0000~\u0000Dq\u0000~\u0000\u0087q\u0000~\u0000=sq\u0000~\u0000$t\u0000\fIssueInstantq"
+"\u0000~\u0000\u0081sq\u0000~\u0000\u001appsq\u0000~\u00003ppsr\u0000$com.sun.msv.datatype.xsd.IntegerType"
+"\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000+com.sun.msv.datatype.xsd.IntegerDerivedType\u0099\u00f1"
+"]\u0090&6k\u00be\u0002\u0000\u0001L\u0000\nbaseFacetst\u0000)Lcom/sun/msv/datatype/xsd/XSDatatyp"
+"eImpl;xq\u0000~\u00008q\u0000~\u0000=t\u0000\u0007integerq\u0000~\u0000Asr\u0000,com.sun.msv.datatype.xsd"
+".FractionDigitsFacet\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001I\u0000\u0005scalexr\u0000;com.sun.msv.datat"
+"ype.xsd.DataTypeWithLexicalConstraintFacetT\u0090\u001c>\u001azb\u00ea\u0002\u0000\u0000xr\u0000*com"
+".sun.msv.datatype.xsd.DataTypeWithFacet\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0005Z\u0000\fisFacet"
+"FixedZ\u0000\u0012needValueCheckFlagL\u0000\bbaseTypeq\u0000~\u0000\u008fL\u0000\fconcreteTypet\u0000\'"
+"Lcom/sun/msv/datatype/xsd/ConcreteType;L\u0000\tfacetNameq\u0000~\u0000%xq\u0000~"
+"\u0000:ppq\u0000~\u0000A\u0001\u0000sr\u0000#com.sun.msv.datatype.xsd.NumberType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000"
+"\u0000xq\u0000~\u00008q\u0000~\u0000=t\u0000\u0007decimalq\u0000~\u0000Aq\u0000~\u0000\u0098t\u0000\u000efractionDigits\u0000\u0000\u0000\u0000q\u0000~\u0000Csq"
+"\u0000~\u0000Dq\u0000~\u0000\u0091q\u0000~\u0000=sq\u0000~\u0000$t\u0000\fMajorVersionq\u0000~\u0000\u0081sq\u0000~\u0000\u001appq\u0000~\u0000\u008csq\u0000~\u0000$t"
+"\u0000\fMinorVersionq\u0000~\u0000\u0081sq\u0000~\u0000\rppsq\u0000~\u0000\u001aq\u0000~\u0000\u0011psq\u0000~\u00003q\u0000~\u0000\u0011psr\u0000#com.s"
+"un.msv.datatype.xsd.AnyURIType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u00008q\u0000~\u0000=t\u0000\u0006anyUR"
+"Iq\u0000~\u0000Aq\u0000~\u0000Csq\u0000~\u0000Dq\u0000~\u0000\u00a6q\u0000~\u0000=sq\u0000~\u0000$t\u0000\tRecipientq\u0000~\u0000\u0081q\u0000~\u0000#sq\u0000~\u0000"
+"\u001appsq\u0000~\u00003ppsr\u0000\u001fcom.sun.msv.datatype.xsd.IDType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000"
+"~\u0000yq\u0000~\u0000=t\u0000\u0002IDq\u0000~\u0000A\u0000q\u0000~\u0000Csq\u0000~\u0000Dq\u0000~\u0000\u00aeq\u0000~\u0000=sq\u0000~\u0000$t\u0000\nResponseIDq"
+"\u0000~\u0000\u0081sr\u0000\"com.sun.msv.grammar.ExpressionPool\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\bexpT"
+"ablet\u0000/Lcom/sun/msv/grammar/ExpressionPool$ClosedHash;xpsr\u0000-"
+"com.sun.msv.grammar.ExpressionPool$ClosedHash\u00d7j\u00d0N\u00ef\u00e8\u00ed\u001c\u0003\u0000\u0003I\u0000\u0005c"
+"ountB\u0000\rstreamVersionL\u0000\u0006parentt\u0000$Lcom/sun/msv/grammar/Express"
+"ionPool;xp\u0000\u0000\u0000\"\u0001pq\u0000~\u0000Lq\u0000~\u0000bq\u0000~\u0000`q\u0000~\u0000aq\u0000~\u0000\u0019q\u0000~\u0000-q\u0000~\u0000Oq\u0000~\u0000Wq\u0000~\u0000"
+"eq\u0000~\u0000mq\u0000~\u0000\bq\u0000~\u0000\u0016q\u0000~\u0000,q\u0000~\u0000Nq\u0000~\u0000Vq\u0000~\u0000dq\u0000~\u0000lq\u0000~\u0000*q\u0000~\u0000Tq\u0000~\u0000jq\u0000~\u0000"
+"\u000bq\u0000~\u0000\u00a1q\u0000~\u0000\nq\u0000~\u0000\fq\u0000~\u0000vq\u0000~\u0000\u0007q\u0000~\u0000\u000eq\u0000~\u0000\u0006q\u0000~\u00001q\u0000~\u0000[q\u0000~\u0000qq\u0000~\u0000\tq\u0000~\u0000"
+"\u0005q\u0000~\u0000\u000fx"));
        }
        return new com.sun.msv.verifier.regexp.REDocumentDeclaration(schemaFragment);
    }

    public class Unmarshaller
        extends com.sun.identity.federation.jaxb.entityconfig.impl.runtime.AbstractUnmarshallingEventHandlerImpl
    {


        public Unmarshaller(com.sun.identity.federation.jaxb.entityconfig.impl.runtime.UnmarshallingContext context) {
            super(context, "--------");
        }

        protected Unmarshaller(com.sun.identity.federation.jaxb.entityconfig.impl.runtime.UnmarshallingContext context, int startState) {
            this(context);
            state = startState;
        }

        public java.lang.Object owner() {
            return com.sun.identity.liberty.ws.common.jaxb.protocol.impl.ResponseTypeImpl.this;
        }

        public void enterElement(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname, org.xml.sax.Attributes __atts)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  0 :
                        attIdx = context.getAttribute("", "InResponseTo");
                        if (attIdx >= 0) {
                            context.consumeAttribute(attIdx);
                            context.getCurrentHandler().enterElement(___uri, ___local, ___qname, __atts);
                            return ;
                        }
                        attIdx = context.getAttribute("", "IssueInstant");
                        if (attIdx >= 0) {
                            context.consumeAttribute(attIdx);
                            context.getCurrentHandler().enterElement(___uri, ___local, ___qname, __atts);
                            return ;
                        }
                        break;
                    case  4 :
                        if (("Assertion" == ___local)&&("urn:oasis:names:tc:SAML:1.0:assertion" == ___uri)) {
                            _getAssertion().add(((com.sun.identity.liberty.ws.common.jaxb.assertion.impl.AssertionElementImpl) spawnChildFromEnterElement((com.sun.identity.liberty.ws.common.jaxb.assertion.impl.AssertionElementImpl.class), 5, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("Assertion" == ___local)&&("urn:oasis:names:tc:SAML:1.0:assertion" == ___uri)) {
                            context.pushAttributes(__atts, false);
                            state = 6;
                            return ;
                        }
                        state = 5;
                        continue outer;
                    case  2 :
                        if (("StatusCode" == ___local)&&("urn:oasis:names:tc:SAML:1.0:protocol" == ___uri)) {
                            _Status = ((com.sun.identity.liberty.ws.common.jaxb.protocol.impl.StatusTypeImpl) spawnChildFromEnterElement((com.sun.identity.liberty.ws.common.jaxb.protocol.impl.StatusTypeImpl.class), 3, ___uri, ___local, ___qname, __atts));
                            return ;
                        }
                        if (("StatusCode" == ___local)&&("urn:oasis:names:tc:SAML:1.0:protocol" == ___uri)) {
                            _Status = ((com.sun.identity.liberty.ws.common.jaxb.protocol.impl.StatusTypeImpl) spawnChildFromEnterElement((com.sun.identity.liberty.ws.common.jaxb.protocol.impl.StatusTypeImpl.class), 3, ___uri, ___local, ___qname, __atts));
                            return ;
                        }
                        break;
                    case  1 :
                        if (("Status" == ___local)&&("urn:oasis:names:tc:SAML:1.0:protocol" == ___uri)) {
                            _Status = ((com.sun.identity.liberty.ws.common.jaxb.protocol.impl.StatusElementImpl) spawnChildFromEnterElement((com.sun.identity.liberty.ws.common.jaxb.protocol.impl.StatusElementImpl.class), 4, ___uri, ___local, ___qname, __atts));
                            return ;
                        }
                        if (("Status" == ___local)&&("urn:oasis:names:tc:SAML:1.0:protocol" == ___uri)) {
                            context.pushAttributes(__atts, false);
                            state = 2;
                            return ;
                        }
                        break;
                    case  5 :
                        if (("Assertion" == ___local)&&("urn:oasis:names:tc:SAML:1.0:assertion" == ___uri)) {
                            _getAssertion().add(((com.sun.identity.liberty.ws.common.jaxb.assertion.impl.AssertionElementImpl) spawnChildFromEnterElement((com.sun.identity.liberty.ws.common.jaxb.assertion.impl.AssertionElementImpl.class), 5, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("Assertion" == ___local)&&("urn:oasis:names:tc:SAML:1.0:assertion" == ___uri)) {
                            context.pushAttributes(__atts, false);
                            state = 6;
                            return ;
                        }
                        revertToParentFromEnterElement(___uri, ___local, ___qname, __atts);
                        return ;
                    case  6 :
                        attIdx = context.getAttribute("", "AssertionID");
                        if (attIdx >= 0) {
                            context.consumeAttribute(attIdx);
                            context.getCurrentHandler().enterElement(___uri, ___local, ___qname, __atts);
                            return ;
                        }
                        break;
                }
                super.enterElement(___uri, ___local, ___qname, __atts);
                break;
            }
        }

        public void leaveElement(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  0 :
                        attIdx = context.getAttribute("", "InResponseTo");
                        if (attIdx >= 0) {
                            context.consumeAttribute(attIdx);
                            context.getCurrentHandler().leaveElement(___uri, ___local, ___qname);
                            return ;
                        }
                        attIdx = context.getAttribute("", "IssueInstant");
                        if (attIdx >= 0) {
                            context.consumeAttribute(attIdx);
                            context.getCurrentHandler().leaveElement(___uri, ___local, ___qname);
                            return ;
                        }
                        break;
                    case  4 :
                        state = 5;
                        continue outer;
                    case  7 :
                        if (("Assertion" == ___local)&&("urn:oasis:names:tc:SAML:1.0:assertion" == ___uri)) {
                            context.popAttributes();
                            state = 5;
                            return ;
                        }
                        break;
                    case  5 :
                        revertToParentFromLeaveElement(___uri, ___local, ___qname);
                        return ;
                    case  3 :
                        if (("Status" == ___local)&&("urn:oasis:names:tc:SAML:1.0:protocol" == ___uri)) {
                            context.popAttributes();
                            state = 4;
                            return ;
                        }
                        break;
                    case  6 :
                        attIdx = context.getAttribute("", "AssertionID");
                        if (attIdx >= 0) {
                            context.consumeAttribute(attIdx);
                            context.getCurrentHandler().leaveElement(___uri, ___local, ___qname);
                            return ;
                        }
                        break;
                }
                super.leaveElement(___uri, ___local, ___qname);
                break;
            }
        }

        public void enterAttribute(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  0 :
                        if (("InResponseTo" == ___local)&&("" == ___uri)) {
                            spawnHandlerFromEnterAttribute((((com.sun.identity.liberty.ws.common.jaxb.protocol.impl.ResponseAbstractTypeImpl)com.sun.identity.liberty.ws.common.jaxb.protocol.impl.ResponseTypeImpl.this).new Unmarshaller(context)), 1, ___uri, ___local, ___qname);
                            return ;
                        }
                        if (("IssueInstant" == ___local)&&("" == ___uri)) {
                            spawnHandlerFromEnterAttribute((((com.sun.identity.liberty.ws.common.jaxb.protocol.impl.ResponseAbstractTypeImpl)com.sun.identity.liberty.ws.common.jaxb.protocol.impl.ResponseTypeImpl.this).new Unmarshaller(context)), 1, ___uri, ___local, ___qname);
                            return ;
                        }
                        break;
                    case  4 :
                        state = 5;
                        continue outer;
                    case  5 :
                        revertToParentFromEnterAttribute(___uri, ___local, ___qname);
                        return ;
                    case  6 :
                        if (("AssertionID" == ___local)&&("" == ___uri)) {
                            _getAssertion().add(((com.sun.identity.liberty.ws.common.jaxb.assertion.impl.AssertionTypeImpl) spawnChildFromEnterAttribute((com.sun.identity.liberty.ws.common.jaxb.assertion.impl.AssertionTypeImpl.class), 7, ___uri, ___local, ___qname)));
                            return ;
                        }
                        break;
                }
                super.enterAttribute(___uri, ___local, ___qname);
                break;
            }
        }

        public void leaveAttribute(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  0 :
                        attIdx = context.getAttribute("", "InResponseTo");
                        if (attIdx >= 0) {
                            context.consumeAttribute(attIdx);
                            context.getCurrentHandler().leaveAttribute(___uri, ___local, ___qname);
                            return ;
                        }
                        attIdx = context.getAttribute("", "IssueInstant");
                        if (attIdx >= 0) {
                            context.consumeAttribute(attIdx);
                            context.getCurrentHandler().leaveAttribute(___uri, ___local, ___qname);
                            return ;
                        }
                        break;
                    case  4 :
                        state = 5;
                        continue outer;
                    case  5 :
                        revertToParentFromLeaveAttribute(___uri, ___local, ___qname);
                        return ;
                    case  6 :
                        attIdx = context.getAttribute("", "AssertionID");
                        if (attIdx >= 0) {
                            context.consumeAttribute(attIdx);
                            context.getCurrentHandler().leaveAttribute(___uri, ___local, ___qname);
                            return ;
                        }
                        break;
                }
                super.leaveAttribute(___uri, ___local, ___qname);
                break;
            }
        }

        public void handleText(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                try {
                    switch (state) {
                        case  0 :
                            attIdx = context.getAttribute("", "InResponseTo");
                            if (attIdx >= 0) {
                                context.consumeAttribute(attIdx);
                                context.getCurrentHandler().text(value);
                                return ;
                            }
                            attIdx = context.getAttribute("", "IssueInstant");
                            if (attIdx >= 0) {
                                context.consumeAttribute(attIdx);
                                context.getCurrentHandler().text(value);
                                return ;
                            }
                            break;
                        case  4 :
                            state = 5;
                            continue outer;
                        case  5 :
                            revertToParentFromText(value);
                            return ;
                        case  6 :
                            attIdx = context.getAttribute("", "AssertionID");
                            if (attIdx >= 0) {
                                context.consumeAttribute(attIdx);
                                context.getCurrentHandler().text(value);
                                return ;
                            }
                            break;
                    }
                } catch (java.lang.RuntimeException e) {
                    handleUnexpectedTextException(value, e);
                }
                break;
            }
        }

    }

}
