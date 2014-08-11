/*
 * The contents of this file are subject to the terms of the Common Development and
 * Distribution License (the License). You may not use this file except in compliance with the
 * License.
 *
 * You can obtain a copy of the License at legal/CDDLv1.0.txt. See the License for the
 * specific language governing permission and limitations under the License.
 *
 * When distributing Covered Software, include this CDDL Header Notice in each file and include
 * the License file at legal/CDDLv1.0.txt. If applicable, add the following below the CDDL
 * Header, with the fields enclosed by brackets [] replaced by your own identifying
 * information: "Portions copyright [year] [name of copyright owner]".
 *
 * Copyright 2013-2014 ForgeRock AS.
 */

package org.forgerock.openam.authz.filter;

import org.forgerock.authz.AuthorizationModule;
import org.forgerock.authz.AuthorizationModuleConfigurator;
import org.forgerock.guice.core.InjectorHolder;
import org.forgerock.json.fluent.JsonValue;

/**
 * Implementation of the AM authorization configurator for the Admin Only AuthorizationFilter implementation.
 *
 * @since 10.2.0
 */
public class AdminAuthorizationConfigurator implements AuthorizationModuleConfigurator {

    /**
     * @return An instance of the AdminAuthorizationConfigurator.
     */
    public static AuthorizationModuleConfigurator getModuleConfigurator() {
        return new AdminAuthorizationConfigurator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AuthorizationModule getModule() {
        return InjectorHolder.getInstance(AdminAuthorizationModule.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonValue getConfiguration() {
        return JsonValue.json(JsonValue.object());
    }
}