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

package com.webauthn4j.data.attestation.statement;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.util.Objects;

public class COSEAlgorithmIdentifier implements Serializable {

    public static final COSEAlgorithmIdentifier RS1 = new COSEAlgorithmIdentifier(-65535);
    public static final COSEAlgorithmIdentifier RS256 = new COSEAlgorithmIdentifier(-257);
    public static final COSEAlgorithmIdentifier RS384 = new COSEAlgorithmIdentifier(-258);
    public static final COSEAlgorithmIdentifier RS512 = new COSEAlgorithmIdentifier(-259);
    public static final COSEAlgorithmIdentifier ES256 = new COSEAlgorithmIdentifier(-7);
    public static final COSEAlgorithmIdentifier ES384 = new COSEAlgorithmIdentifier(-35);
    public static final COSEAlgorithmIdentifier ES512 = new COSEAlgorithmIdentifier(-36);

    private final long value;

    COSEAlgorithmIdentifier(long value) {
        this.value = value;
    }

    // COSEAlgorithmIdentifier doesn't accept jcaName and messageDigestJcaName from caller for the time being
    public static COSEAlgorithmIdentifier create(long value) {
        return new COSEAlgorithmIdentifier(value);
    }

    @JsonCreator
    private static COSEAlgorithmIdentifier deserialize(long value) {
        return create(value);
    }

    @JsonValue
    public long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        COSEAlgorithmIdentifier that = (COSEAlgorithmIdentifier) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
