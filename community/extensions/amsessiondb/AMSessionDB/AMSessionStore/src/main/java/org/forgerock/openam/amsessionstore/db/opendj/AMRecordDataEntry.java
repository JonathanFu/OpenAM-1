/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2011 ForgeRock AS. All Rights Reserved
 *
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the License at
 * http://forgerock.org/license/CDDLv1.0.html
 * See the License for the specific language governing
 * permission and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL
 * Header Notice in each file and include the License file
 * at http://forgerock.org/license/CDDLv1.0.html
 * If applicable, add the following below the CDDL Header,
 * with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 */

package org.forgerock.openam.amsessionstore.db.opendj;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.logging.Level;
import org.forgerock.i18n.LocalizableMessage;
import org.forgerock.openam.amsessionstore.common.AMRecord;
import org.forgerock.openam.amsessionstore.common.Constants;
import org.forgerock.openam.amsessionstore.common.Log;
import org.forgerock.openam.amsessionstore.db.StoreException;
import org.opends.server.protocols.ldap.LDAPAttribute;
import org.opends.server.types.RawAttribute;
import static org.forgerock.openam.amsessionstore.i18n.AmsessionstoreMessages.*;

/**
 * This class encapsulates a distinguished name and its attribute values.
 * 
 * @author steve
 */
public class AMRecordDataEntry {
    private String dn;
    private Map<String, Set<String>> attributeValues;
    private AMRecord record;
    
    public final static String AUX_DATA = "auxData";
    public final static String DATA = "data";
    public final static String EXTRA_BYTE_ATTR = "extraByteAttr";
    public final static String EXTRA_STRING_ATTR = "extraStringAttr";
    public final static String OPERATION = "operation";
    public final static String SEC_KEY = "sKey";
    public final static String SERVICE = "service";
    public final static String PRI_KEY = "pKey";
    public final static String EXP_DATE = "expirationDate";
    public final static String STATE = "state";
    
    private static SimpleDateFormat formatter = null;
    public static List<LDAPAttribute> objectClasses;
    
    static {
        initialize();
    }
    
    private static void initialize() {
        List<String> valueList = new ArrayList<String>();
        valueList.add(Constants.TOP);
        valueList.add(Constants.FR_FAMRECORD);
        LDAPAttribute ldapAttr= new LDAPAttribute(Constants.OBJECTCLASS, valueList);
        objectClasses = new ArrayList<LDAPAttribute>();
        objectClasses.add(ldapAttr);
        
        formatter = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
    }
    
    /**
     * Constructs an instance.
     *
     * @param dn Distinguished name.
     * @param attributeValues attribute values.
     */
    public AMRecordDataEntry(String dn, Map<String, Set<String>> attributeValues) 
    throws StoreException {
        this(dn, null, attributeValues);
    }

    /**
     * Constructs an instance.
     *
     * @param dn Distinguished name.
     * @param attributeValues attribute values.
     */
    public AMRecordDataEntry(String dn, String op, Map<String, Set<String>> attributeValues) 
    throws StoreException {
        this.dn = dn;
        this.attributeValues = attributeValues;
        parseAttributeValues(attributeValues);
        this.record = new AMRecord();
        
        if (attributeValues.get(AUX_DATA) != null) {
            Set<String> values = attributeValues.get(AUX_DATA);
            for (String value : values) {
                record.setAuxdata(value);
            }
        }
        
        if (attributeValues.get(DATA) != null) {
            Set<String> values = attributeValues.get(DATA);
            for (String value : values) {
                record.setData(value);
            }
        }
        
        if (attributeValues.get(PRI_KEY) != null) {
            Set<String> values = attributeValues.get(PRI_KEY);
            for (String value : values) {
                record.setPrimaryKey(value);
            }
        }
        
        if (attributeValues.get(EXP_DATE) != null) {
            Set<String> values = attributeValues.get(EXP_DATE);
            for (String value : values) {
                record.setExpDate(toAMDateFormat(value));
            }
        }
        
        if (attributeValues.get(SERVICE) != null) {
            Set<String> values = attributeValues.get(SERVICE);
            for (String value : values) {
                record.setService(value);
            }
        }
        
        if (attributeValues.get(SEC_KEY) != null) {
            Set<String> values = attributeValues.get(SEC_KEY);
            for (String value : values) {
                record.setSecondaryKey(value);
            }
        }
        
        if (op != null) {
            record.setOperation(op);
        } else {
            if (attributeValues.get(OPERATION) != null) {
                Set<String> values = attributeValues.get(OPERATION);
                for (String value : values) {
                    record.setOperation(value);
                }
            }
        }
        
        if (attributeValues.get(STATE) != null) {
            Set<String> values = attributeValues.get(STATE);
            for (String value : values) {
                record.setState(Integer.parseInt(value));
            }
        }
        
        if (attributeValues.get(EXTRA_BYTE_ATTR) != null) {
            Set<String> values = attributeValues.get(EXTRA_BYTE_ATTR);
            for (String value : values) {
                String key, v;
                
                if (value.indexOf('=') == -1) {
                    // TODO Warning
                    key = v = value;
                } else {
                    key = value.substring(0, value.indexOf('='));
                    v = value.substring(value.indexOf('=') + 1);
                }
                
                record.setExtraByteAttrs(key, v);
            }
        }
        
        if (attributeValues.get(EXTRA_STRING_ATTR) != null) {
            Set<String> values = attributeValues.get(EXTRA_STRING_ATTR);
            for (String value : values) {
                String key, v;
                
                if (value.indexOf('=') == -1) {
                    // TODO Warning
                    key = v = value;
                } else {
                    key = value.substring(0, value.indexOf('='));
                    v = value.substring(value.indexOf('=') + 1);
                }
                
                record.setExtraStringAttrs(key, v);
            }
        }
    }
    
    public AMRecordDataEntry(AMRecord record) 
    throws StoreException {
        this.record = record;
        this.attributeValues = new HashMap<String, Set<String>>();
        Set<String> set = new HashSet<String>();
        
        if (record.getAuxdata() != null) {
            set.add(record.getAuxdata());
            attributeValues.put(AUX_DATA, set);
        }
        
        if (record.getData() != null) {
            set = new HashSet<String>();
            set.add(record.getData());
            attributeValues.put(DATA, set);
        }
        
        if (record.getPrimaryKey() != null) {
            set = new HashSet<String>();
            set.add(record.getPrimaryKey());
            attributeValues.put(PRI_KEY, set);
        }
        
        set = new HashSet<String>();
        set.add(toDJDateFormat(record.getExpDate()));
        attributeValues.put(EXP_DATE, set);
        
        if (record.getService() != null) {
            set = new HashSet<String>();
            set.add(record.getService());
            attributeValues.put(SERVICE, set);
        }
        
        if (record.getSecondaryKey() != null) {
            set = new HashSet<String>();
            set.add(record.getSecondaryKey());
            attributeValues.put(SEC_KEY, set);
        }
        
        if (record.getOperation() != null) {
            set = new HashSet<String>();
            set.add(record.getOperation());
            attributeValues.put(OPERATION, set);
        }
        
        set = new HashSet<String>();
        set.add(Integer.toString(record.getState()));
        attributeValues.put(STATE, set);

        attributeValues.put(EXTRA_BYTE_ATTR, formatMultiValuedAttr(EXTRA_BYTE_ATTR, record.getExtraByteAttributes()));
        attributeValues.put(EXTRA_STRING_ATTR, formatMultiValuedAttr(EXTRA_STRING_ATTR, record.getExtraStringAttributes()));
    }
    
    public AMRecord getAMRecord() {
        return record;
    }
    
    private Set<String> formatMultiValuedAttr(String attr, Map<String, String> values) {
        Set<String> attrValues = new HashSet<String>();
        
        if (values == null) {
            return null;
        }
        
        for (Map.Entry<String, String> value : values.entrySet()) {
            StringBuilder v = new StringBuilder();
            v.append(attr).append(Constants.EQUALS).append(value.getKey());
            v.append(Constants.EQUALS).append(value.getValue());
            attrValues.add(v.toString());
        }
        
        return attrValues;
    }
    
    private void parseAttributeValues(Map<String, Set<String>> raw) {
        parseAttributeValues(raw.get(EXTRA_BYTE_ATTR));
        parseAttributeValues(raw.get(EXTRA_STRING_ATTR));
    }

    private void parseAttributeValues(Set<String> raw) {
        if (raw == null || raw.isEmpty()) {
            return;
        }
        
        for (String s : raw) {
            int idx = s.indexOf('=');
            
            if (idx != -1) {
                String name = s.substring(0, idx);
                String value = s.substring(idx+1);

                Set<String> set = attributeValues.get(name);
                
                if (set == null) {
                    set = new HashSet<String>();
                    attributeValues.put(name, set);
                }
                
                set.add(value);
            }
        }
    }

    public String getDN() {
        return dn;
    }

    public Set<String> getAttributeValues(String attributeName) {
        return attributeValues.get(attributeName);
    }

    public String getAttributeValue(String attributeName) {
        Set<String> val = attributeValues.get(attributeName);
        
        return ((val != null) && !val.isEmpty()) ? val.iterator().next() : null;
    }
    
    public List<RawAttribute> getAttrList() {
        List<RawAttribute> attrList = new ArrayList<RawAttribute>(attributeValues.size());
        
        for (Map.Entry<String, Set<String>> entry : attributeValues.entrySet()) {
            Set<String> values = entry.getValue();
            
            if (values != null && !values.isEmpty()) {
                List<String> valueList = new ArrayList<String>();
                valueList.addAll(values);
                attrList.add(new LDAPAttribute(entry.getKey(), valueList));
            }
        }
        
        return attrList;
    }
    
    public static List<LDAPAttribute> getObjectClasses() {
         return objectClasses;
    }
    
    /**
     * OpenDJ generalizedtime format is yyyyMMddHHmmss'Z'
     * OpenAM session failover format is in seconds and uses the same epoch 
     * start as System.currentTimeMillis() / 1000 + the session time in seconds
     * 
     * @param time
     * @return 
     */
    public static Long toAMDateFormat(String date) 
    throws StoreException {
        Date expDate = null;
        
        try {
            expDate = formatter.parse(date);
        } catch (ParseException pe) {
            final LocalizableMessage message = DB_DJ_PARSE.get(date);
            Log.logger.log(Level.SEVERE, message.toString());
            throw new StoreException(message.toString());
        }
        
        return expDate.getTime() / 1000;
    }
    
    public static String toDJDateFormat(Long date) {
        Date expDate = new Date(date.longValue() * 1000L);
        return formatter.format(expDate);
    }
}

