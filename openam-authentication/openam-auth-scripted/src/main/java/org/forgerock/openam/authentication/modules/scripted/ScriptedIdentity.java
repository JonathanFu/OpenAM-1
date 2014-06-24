/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2005 Sun Microsystems Inc. All Rights Reserved
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
 * $Id: LDAP.java,v 1.17 2010/01/25 22:09:16 qcheng Exp $
 *
 */

/*
 * Portions Copyrighted 2010-2014 ForgeRock, Inc.
 */
package org.forgerock.openam.authentication.modules.scripted;

import com.iplanet.sso.SSOException;
import com.sun.identity.idm.AMIdentity;
import com.sun.identity.idm.IdRepoException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * A wrapper class to limit an authentication script's exposure to a AmIdentity object
 */
public class ScriptedIdentity {
    AMIdentity amIdentity;

    /**
     * The constructor for the <code>ScriptedIdentity</code> object
     * @param amIdentity The amIdentity object containing the user information
     */
    public ScriptedIdentity(AMIdentity amIdentity) {
        this.amIdentity = amIdentity;
    }

    /**
     * Retrieves a particular attribute's value
     * @param attributeName The name of the attribute to be retrieved
     * @return The value of the attribute
     */
    public Set getAttribute(String attributeName) {
        try {
            return amIdentity.getAttribute(attributeName);
        } catch (IdRepoException e) {
            e.printStackTrace();
        } catch (SSOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Sets a particular attribute's value. If the attribute doesn't exist, it will be created.
     * @param attributeName The name of the attribute
     * @param attributeValue The value of the attribute
     */
    public void setAttribute(String attributeName, String attributeValue) {
        HashMap attributes = new HashMap();
        HashSet attributeValues = new HashSet();
        attributeValues.add(attributeValue);
        attributes.put(attributeName, attributeValues);
        store();
        try {
            amIdentity.setAttributes(attributes);
        } catch (IdRepoException e) {
            e.printStackTrace();
        } catch (SSOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Persists the current state of the user's attributes
     */
    private void store() {
        try {
            amIdentity.store();
        } catch (IdRepoException e) {
            e.printStackTrace();
        } catch (SSOException e) {
            e.printStackTrace();
        }
    }
}
