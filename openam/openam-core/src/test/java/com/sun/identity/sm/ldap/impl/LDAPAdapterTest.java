/**
 * Copyright 2013 ForgeRock AS.
 *
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
 */
package com.sun.identity.sm.ldap.impl;

import com.sun.identity.sm.ldap.api.CoreTokenConstants;
import com.sun.identity.sm.ldap.api.TokenType;
import com.sun.identity.sm.ldap.api.tokens.Token;
import com.sun.identity.sm.ldap.exceptions.LDAPOperationFailedException;
import com.sun.identity.sm.ldap.utils.LDAPDataConversion;
import com.sun.identity.sm.ldap.utils.TokenAttributeConversion;
import org.forgerock.opendj.ldap.Connection;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.Entry;
import org.forgerock.opendj.ldap.ErrorResultException;
import org.forgerock.opendj.ldap.ResultCode;
import org.forgerock.opendj.ldap.requests.ModifyRequest;
import org.forgerock.opendj.ldap.responses.Result;
import org.mockito.ArgumentCaptor;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * @author robert.wapshott@forgerock.com
 */
public class LDAPAdapterTest {
    @Test
    public void shouldUseConnectionForCreate() throws LDAPOperationFailedException, ErrorResultException {
        // Given
        Token  token = new Token("badger", TokenType.SESSION);

        Connection mockConnection = mock(Connection.class);
        Result successResult = mockSuccessfulResult();
        given(mockConnection.add(any(Entry.class))).willReturn(successResult);

        TokenAttributeConversion mockConversion = mock(TokenAttributeConversion.class);
        given(mockConversion.getEntry(any(Token.class))).willReturn(mock(Entry.class));

        LDAPAdapter adapter = new LDAPAdapter(mockConversion);

        // When
        adapter.create(mockConnection, token);

        // Then
        verify(mockConnection).add(any(Entry.class));
    }

    @Test
    public void shouldUseConnectionForRead() throws ErrorResultException {
        // Given
        String tokenId = "badger";
        DN testDN = DN.rootDN();

        Connection mockConnection = mock(Connection.class);
        TokenAttributeConversion mockConversion = mock(TokenAttributeConversion.class);
        given(mockConversion.generateTokenDN(anyString())).willReturn(testDN);

        LDAPAdapter adapter = new LDAPAdapter(mockConversion);

        // When
         adapter.read(mockConnection, tokenId);

        // Then
        ArgumentCaptor<DN> captor = ArgumentCaptor.forClass(DN.class);
        verify(mockConnection).readEntry(captor.capture());
        assertEquals(testDN, captor.getValue());
    }

    @Test
    public void shouldUseConnectionForDelete() throws ErrorResultException, LDAPOperationFailedException {
        // Given
        String tokenId = "badger";
        DN testDN = DN.rootDN();

        Connection mockConnection = mock(Connection.class);
        Result successResult = mockSuccessfulResult();
        given(mockConnection.delete(anyString())).willReturn(successResult);

        TokenAttributeConversion mockConversion = mock(TokenAttributeConversion.class);
        given(mockConversion.generateTokenDN(anyString())).willReturn(testDN);

        LDAPAdapter adapter = new LDAPAdapter(mockConversion);

        // When
        adapter.delete(mockConnection, tokenId);

        // Then
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockConnection).delete(captor.capture());
        assertEquals(String.valueOf(testDN), captor.getValue());
    }

    @Test
    public void shouldNoNothingIfNoModificaitonsOnUpdate() throws LDAPOperationFailedException, ErrorResultException {
        // Given
        String tokenId = "badger";
        Token first = new Token(tokenId, TokenType.OAUTH);
        Token second = new Token(tokenId, TokenType.OAUTH);

        Connection mockConnection = mock(Connection.class);

        CoreTokenConstants constants = new CoreTokenConstants("");
        LDAPDataConversion dataConversion = new LDAPDataConversion();
        TokenAttributeConversion conversion = new TokenAttributeConversion(constants, dataConversion);
        LDAPAdapter adapter = new LDAPAdapter(conversion);

        // When
        adapter.update(mockConnection, first, second);

        // Then
        verify(mockConnection, never()).modify(any(ModifyRequest.class));
    }

    @Test
    public void shouldPerformUpdate() throws LDAPOperationFailedException, ErrorResultException {
        // Given
        Token first = new Token("weasel", TokenType.OAUTH);
        Token second = new Token("badger", TokenType.OAUTH);

        Connection mockConnection = mock(Connection.class);
        Result successResult = mockSuccessfulResult();
        given(mockConnection.modify(any(ModifyRequest.class))).willReturn(successResult);

        CoreTokenConstants constants = new CoreTokenConstants("");
        LDAPDataConversion dataConversion = new LDAPDataConversion();
        TokenAttributeConversion conversion = new TokenAttributeConversion(constants, dataConversion);
        LDAPAdapter adapter = new LDAPAdapter(conversion);

        // When
        adapter.update(mockConnection, first, second);

        // Then
        verify(mockConnection).modify(any(ModifyRequest.class));
    }

    private static Result mockSuccessfulResult() {
        Result result = mock(Result.class);
        ResultCode resultCode = ResultCode.SUCCESS;
        given(result.getResultCode()).willReturn(resultCode);
        return result;
    }
}