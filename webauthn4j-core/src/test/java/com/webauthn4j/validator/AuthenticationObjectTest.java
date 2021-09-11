/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.webauthn4j.validator;

import com.webauthn4j.authenticator.Authenticator;
import com.webauthn4j.converter.AuthenticatorDataConverter;
import com.webauthn4j.converter.CollectedClientDataConverter;
import com.webauthn4j.converter.util.ObjectConverter;
import com.webauthn4j.data.attestation.authenticator.AuthenticatorData;
import com.webauthn4j.data.client.ClientDataType;
import com.webauthn4j.data.client.CollectedClientData;
import com.webauthn4j.data.extension.authenticator.AuthenticationExtensionAuthenticatorOutput;
import com.webauthn4j.data.extension.client.AuthenticationExtensionClientOutput;
import com.webauthn4j.data.extension.client.AuthenticationExtensionsClientOutputs;
import com.webauthn4j.server.ServerProperty;
import com.webauthn4j.test.TestDataUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class AuthenticationObjectTest {

    private final ObjectConverter objectConverter = new ObjectConverter();

    @Test
    void getter_test() {

        byte[] credentialId = new byte[32];
        CollectedClientData clientData = TestDataUtil.createClientData(ClientDataType.WEBAUTHN_CREATE);
        byte[] clientDataBytes = new CollectedClientDataConverter(objectConverter).convertToBytes(clientData);
        AuthenticatorData<AuthenticationExtensionAuthenticatorOutput> authenticatorData = TestDataUtil.createAuthenticatorData();
        byte[] authenticatorDataBytes = new AuthenticatorDataConverter(objectConverter).convert(authenticatorData);
        AuthenticationExtensionsClientOutputs<AuthenticationExtensionClientOutput> clientExtensions = new AuthenticationExtensionsClientOutputs<>();
        ServerProperty serverProperty = TestDataUtil.createServerProperty();
        Authenticator authenticator = TestDataUtil.createAuthenticator();
        AuthenticationObject authenticationObject = new AuthenticationObject(
                credentialId,
                authenticatorData,
                authenticatorDataBytes,
                clientData,
                clientDataBytes,
                clientExtensions,
                serverProperty,
                authenticator
        );

        assertAll(
                () -> assertThat(authenticationObject.getCredentialId()).isEqualTo(credentialId),
                () -> assertThat(authenticationObject.getCollectedClientData()).isEqualTo(clientData),
                () -> assertThat(authenticationObject.getCollectedClientDataBytes()).isEqualTo(clientDataBytes),
                () -> assertThat(authenticationObject.getAuthenticatorData()).isEqualTo(authenticatorData),
                () -> assertThat(authenticationObject.getAuthenticatorDataBytes()).isEqualTo(authenticatorDataBytes),
                () -> assertThat(authenticationObject.getClientExtensions()).isEqualTo(clientExtensions),
                () -> assertThat(authenticationObject.getServerProperty()).isEqualTo(serverProperty),
                () -> assertThat(authenticationObject.getAuthenticator()).isEqualTo(authenticator)
        );
    }

    @Test
    void equals_hashCode_test() {

        byte[] credentialId = new byte[32];
        CollectedClientData clientData = TestDataUtil.createClientData(ClientDataType.WEBAUTHN_CREATE);
        byte[] clientDataBytes = new CollectedClientDataConverter(objectConverter).convertToBytes(clientData);
        AuthenticatorData<AuthenticationExtensionAuthenticatorOutput> authenticatorData = TestDataUtil.createAuthenticatorData();
        byte[] authenticatorDataBytes = new AuthenticatorDataConverter(objectConverter).convert(authenticatorData);
        AuthenticationExtensionsClientOutputs<AuthenticationExtensionClientOutput> clientExtensions = new AuthenticationExtensionsClientOutputs<>();
        ServerProperty serverProperty = TestDataUtil.createServerProperty();
        Authenticator authenticator = TestDataUtil.createAuthenticator();

        AuthenticationObject instanceA = new AuthenticationObject(
                credentialId,
                authenticatorData,
                authenticatorDataBytes,
                clientData,
                clientDataBytes,
                clientExtensions,
                serverProperty,
                authenticator
        );

        AuthenticationObject instanceB = new AuthenticationObject(
                credentialId,
                authenticatorData,
                authenticatorDataBytes,
                clientData,
                clientDataBytes,
                clientExtensions,
                serverProperty,
                authenticator
        );

        assertAll(
                () -> assertThat(instanceA).isEqualTo(instanceB),
                () -> assertThat(instanceA).hasSameHashCodeAs(instanceB)
        );
    }

}