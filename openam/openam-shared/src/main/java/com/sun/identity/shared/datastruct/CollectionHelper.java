/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2006 Sun Microsystems Inc. All Rights Reserved
 *
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the License at
 * https://opensso.dev.java.net/public/CDDLv1.0.html or
 * opensso/legal/CDDLv1.0.txt
 * See the License for the specific language governing
 * permission and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL
 * Header Notice in each file and include the License file
 * at opensso/legal/CDDLv1.0.txt.
 * If applicable, add the following below the CDDL Header,
 * with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * $Id: CollectionHelper.java,v 1.6 2010/01/06 22:31:55 veiming Exp $
 *
 * Portions Copyrighted 2010-2015 ForgeRock AS.
 */
package com.sun.identity.shared.datastruct;

import com.sun.identity.shared.Constants;
import com.sun.identity.shared.configuration.SystemPropertiesManager;
import com.sun.identity.shared.debug.Debug;
import org.slf4j.Logger;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * This class contains various Collection manipulation methods.
 */
public class CollectionHelper {
    private static final String localDsameServer = SystemPropertiesManager.get(
            Constants.AM_SERVER_HOST);

    /**
     * Returns String from a map of string of set of string.
     *
     * @param map Map of string of set of string.
     * @param name Key of the map entry.
     * @return String from a map of string of set of string
     */
    public static String getMapAttr(Map map, String name) {
        Set s = (Set)map.get(name);
        String retVal = ((s == null) || s.isEmpty()) ? null :
            ((String)s.iterator().next());
        return (retVal != null) ? retVal.trim() : null;
    }

    /**
     * Returns String from a map of string of set of string.
     *
     * @param map Map of string of set of string.
     * @param name Key of the map entry.
     * @param defaultValue Default value if the string is not found.
     * @return String from a map of string of set of string
     */
    public static String getMapAttr(Map map, String name, String defaultValue) {
        String str = getMapAttr(map, name);
        return ((str != null) && (str.length() > 0)) ? str : defaultValue;
    }

    /**
     * Gets a boolean attribute from a {@code Map<String, Set<String>>}, defaulting to the given default value if
     * the attribute is not present.
     *
     * @param map the attribute map.
     * @param name the name of the attribute to retrieve.
     * @param defaultValue the value to use if the attribute is not present.
     * @return the boolean value using {@link Boolean#parseBoolean(String)}.
     */
    public static boolean getBooleanMapAttr(Map map, String name, boolean defaultValue) {
        String value = getMapAttr(map, name, Boolean.toString(defaultValue));
        return Boolean.parseBoolean(value);
    }

    /**
     * Returns integer value from a Map of String of Set of String.
     * 
     * @param map Map of String of Set of String.
     * @param name Kye of the map entry.
     * @param defaultValue Default value if the integer value is not found.
     * @param debug Debug object.
     * @return integer value from a Map of String of Set of String.
     */
    public static int getIntMapAttr(
        Map map, 
        String name,
        String defaultValue,
        Debug debug
    ) {
        try {
            return Integer.parseInt(getMapAttr(map, name, defaultValue));
        } catch (NumberFormatException nfe) {
            debug.error("CollectionHelper.getIntMapAttr", nfe);
            return Integer.parseInt(defaultValue);
        }
    }

    /**
     * Returns integer value from a Map of String of Set of String.
     * 
     * @param map Map of String of Set of String.
     * @param name Key of the map entry.
     * @param defaultValue Default value if the integer value is not found.
     * @param debug Debug object.
     * @return integer value from a Map of String of Set of String.
     */
    public static int getIntMapAttr(
        Map map,
        String name,
        int defaultValue,
        Debug debug
    ) {
        try {
            return Integer.parseInt(getMapAttr(map, name));
        } catch (NumberFormatException nfe) {
            debug.error("CollectionHelper.getIntMapAttr", nfe);
            return defaultValue;
        }
    }

    /**
     * Returns a long value from the given configuration map.
     *
     * @param config the map of attribute values.
     * @param name the attribute name to get.
     * @param defaultValue the default value to use if the attribute is not set or is not a long.
     * @param debug the debug object to report format errors to.
     * @return the long value of the attribute or the defaultValue if not set/not a long.
     */
    public static long getLongMapAttr(Map<String, Set<String>> config, String name, long defaultValue, Debug debug) {
        String valueString = null;
        try {
            valueString = getMapAttr(config, name);
            return Long.parseLong(valueString);
        } catch (NumberFormatException nfe) {
            debug.error("Unable to parse " + name + "=" + valueString, nfe);
            return defaultValue;
        }
    }

    /**
     * Returns the first attribute value for the corresponding name in the config map and parses it to a long.
     *
     * @param config The map where the attribute should be retrieved from.
     * @param name The name of the attribute that should be retrieved from the map.
     * @return The attribute from the map corresponding to the provided attribute name, parsed to a long.
     * If the attribute does not exist the current date time will be returned.
     */
    public static long getMapAttrAsDateLong(Map<String, Set<String>> config, String name, Logger logger) {
        String valueString = null;
        try {
            valueString = getMapAttr(config, name);
            return Long.parseLong(valueString);
        } catch (NumberFormatException nfe) {
            logger.error("Unable to parse " + name + "=" + valueString, nfe);
            return new Date().getTime();
        }
    }

    /**
     * This convenience method is for getting server specific attributes from a
     * list attribute. Server specific is determined by prefixing a list
     * attribute value with DSAME local server name followed by the | character.
     * If the list has more than one entry but no matching local server prefixes
     * than null is returned as this is an invalid configuration for these type
     * of attributes. This allows services like authentication to support a
     * geographic directory configuration.
     *
     * @param map Map of String of Set of String.
     * @param attrName Key of the map entry of interest.
     * @return the server name.
     */
    public static String getServerMapAttr(Map map, String attrName) {
        String result = null;
        Set attrValues = (Set)map.get(attrName);

        if (attrValues.size() == 1) {
            Iterator iter = attrValues.iterator();
            String strServer = (String)iter.next();
            if (strServer != null) {
                strServer = strServer.trim();
            }
            return strServer;
        }
        if ((attrValues != null) && !attrValues.isEmpty()) {
            for (Iterator i = attrValues.iterator();
                i.hasNext() && (result == null);
            ) {
                result = (String)i.next();
                if (result != null) {
                    result = result.trim();
                    if (result.startsWith(localDsameServer)) {
                        int index = result.indexOf("|");
                        if (index != -1) {
                            result = result.substring(index + 1);
                        } else {
                            result = null;
                        }
                    } else {
                        result = null;
                    }
                }
            }
        }
        return result;
    }

    /**
     * This convenience method is for getting server specific attributes from a
     * list attribute. Server specific is determined by prefixing a list
     * attribute value with DSAME local server name followed by the | character.
     * The priority order of the attributes as follows. 
     * 1- LDAP Servers belong to current OpenAM Server, localDsameServer is prefixed with the attribute 
     * 2- LDAP Servers belong to no OpenAM Server, no server prefix  
     * 3- All other servers - LDAP Servers prefixed with other OpenAM Servers
     * This allows services like authentication to support a geographic directory configuration.
     *
     * @param map Map of String of Set of String.
     * @param attrName Key of the map entry of interest.
     * @return attributes based on the prioritization. 
     */
    public static Set<String> getServerMapAttrs(Map<String, Set<?>> map, String attrName) {
        Set<String> ret = new LinkedHashSet<String>();
        Set<String> attrValues = (Set<String>) map.get(attrName);
        Set<String> currentServerDefined = new LinkedHashSet<String>();
        Set<String> otherServerDefined = new LinkedHashSet<String>();
        Set<String> nonMatchingServers = new LinkedHashSet<String>();
        for (String attr : attrValues) {
            if (attr != null) {
                attr = attr.trim();
                int index = attr.indexOf("|");
                if (index == -1) {
                    nonMatchingServers.add(attr);
                } else { 
                    String currentPrefix = attr.substring(0, index);
                    if (currentPrefix.equalsIgnoreCase(localDsameServer)) {
                        attr = attr.substring(index + 1);
                        currentServerDefined.add(attr);
                    } else { 
                        attr = attr.substring(index + 1);
                        otherServerDefined.add(attr);
                    }
                }
            }
        }
        ret.addAll(currentServerDefined);
        ret.addAll(nonMatchingServers);
        ret.addAll(otherServerDefined);
        return ret;
    }
}
