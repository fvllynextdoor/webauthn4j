/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.sharplab.springframework.security.webauthn.utils.jackson.deserializer;

import net.sharplab.springframework.security.webauthn.attestation.authenticator.WebAuthnAuthenticatorData;
import net.sharplab.springframework.security.webauthn.util.jackson.deserializer.WebAuthnAuthenticatorDataDeserializer;
import org.junit.Test;
import org.springframework.util.Base64Utils;

import java.io.IOException;

import static net.sharplab.springframework.security.webauthn.attestation.authenticator.WebAuthnAuthenticatorData.BIT_UP;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test for WebAuthnAuthenticatorDataDeserializer
 */
public class WebAuthnAuthenticatorDataDeserializerTest {

    @Test
    public void test() {
        //Given
        String input = "SZYN5YgOjGh0NBcPZHZgW4_krrmihjLHmVzzuoMdl2MBAAABRTBGAiEA77SC7T44f9E6NEEwiHBkcI3jSL70jAcvEN3lDJoFpxUCIQDxuc-Oq1UgYUxftfXu4wbsDQiTz_6cJJfe00d5t6nrNw==";

        //When
        WebAuthnAuthenticatorData result = new WebAuthnAuthenticatorDataDeserializer().deserialize(Base64Utils.decodeFromUrlSafeString(input));

        //Then
        assertThat(result.getRpIdHash()).isNotNull();
        assertThat(result.getRpIdHash()).hasSize(32);
        assertThat(result.getFlags()).isEqualTo(BIT_UP);
        assertThat(result.getCounter()).isEqualTo(325);
        assertThat(result.getAttestationData()).isNull();
        assertThat(result.getExtensions()).isNull();
    }
}