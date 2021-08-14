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

package com.webauthn4j.data.extension.authenticator;

import com.webauthn4j.data.attestation.authenticator.COSEKey;
import com.webauthn4j.validator.exception.ConstraintViolationException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;

class HMACSecretAuthenticationExtensionAuthenticatorInputTest {

    @Test
    void validate_test(){
        assertThatCode(new HMACSecretAuthenticationExtensionAuthenticatorInput(new HMACGetSecretAuthenticatorInput(mock(COSEKey.class), new byte[32], new byte[32]))::validate).doesNotThrowAnyException();
        assertThatThrownBy(new HMACSecretAuthenticationExtensionAuthenticatorInput(null)::validate).isInstanceOf(ConstraintViolationException.class);
        assertThatThrownBy(new HMACSecretAuthenticationExtensionAuthenticatorInput(new HMACGetSecretAuthenticatorInput(null, new byte[32], new byte[32]))::validate).isInstanceOf(ConstraintViolationException.class);
        assertThatThrownBy(new HMACSecretAuthenticationExtensionAuthenticatorInput(new HMACGetSecretAuthenticatorInput(mock(COSEKey.class), null, new byte[32]))::validate).isInstanceOf(ConstraintViolationException.class);
        assertThatThrownBy(new HMACSecretAuthenticationExtensionAuthenticatorInput(new HMACGetSecretAuthenticatorInput(mock(COSEKey.class), new byte[32], null))::validate).isInstanceOf(ConstraintViolationException.class);
        assertThatThrownBy(new HMACSecretAuthenticationExtensionAuthenticatorInput(new HMACGetSecretAuthenticatorInput(mock(COSEKey.class), new byte[16], new byte[32]))::validate).isInstanceOf(ConstraintViolationException.class);
        assertThatThrownBy(new HMACSecretAuthenticationExtensionAuthenticatorInput(new HMACGetSecretAuthenticatorInput(mock(COSEKey.class), new byte[32], new byte[16]))::validate).isInstanceOf(ConstraintViolationException.class);
    }

}