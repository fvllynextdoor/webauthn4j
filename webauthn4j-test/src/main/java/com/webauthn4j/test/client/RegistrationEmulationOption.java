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

package com.webauthn4j.test.client;

import com.webauthn4j.data.client.ClientDataType;
import com.webauthn4j.data.client.CollectedClientData;
import com.webauthn4j.test.TestDataUtil;
import com.webauthn4j.test.authenticator.webauthn.AttestationOption;

public class RegistrationEmulationOption {

    private AttestationOption attestationOption;

    private boolean signatureOverrideEnabled = false;
    private byte[] signature = new byte[]{0x01, 0x23, 0x45, 0x67};
    private boolean collectedClientDataOverrideEnabled = false;
    private CollectedClientData collectedClientData = TestDataUtil.createClientData(ClientDataType.WEBAUTHN_CREATE);

    public AttestationOption getAttestationOption() {
        return attestationOption;
    }

    public void setAttestationOption(AttestationOption attestationOption) {
        this.attestationOption = attestationOption;
    }

    public boolean isSignatureOverrideEnabled() {
        return signatureOverrideEnabled;
    }

    public void setSignatureOverrideEnabled(boolean signatureOverrideEnabled) {
        this.signatureOverrideEnabled = signatureOverrideEnabled;
    }

    public byte[] getSignature() {
        return signature;
    }

    public void setSignature(byte[] signature) {
        this.signature = signature;
    }

    public boolean isCollectedClientDataOverrideEnabled() {
        return collectedClientDataOverrideEnabled;
    }

    public void setCollectedClientDataOverrideEnabled(boolean collectedClientDataOverrideEnabled) {
        this.collectedClientDataOverrideEnabled = collectedClientDataOverrideEnabled;
    }

    public CollectedClientData getCollectedClientData() {
        return collectedClientData;
    }

    public void setCollectedClientData(CollectedClientData collectedClientData) {
        this.collectedClientData = collectedClientData;
    }
}
