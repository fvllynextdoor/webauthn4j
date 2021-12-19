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

package com.webauthn4j.converter.jackson.deserializer.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.webauthn4j.data.UserVerificationMethod;

import java.io.IOException;

public class UserVerificationMethodFromLongDeserializer extends StdDeserializer<UserVerificationMethod> {

    public UserVerificationMethodFromLongDeserializer() {
        super(UserVerificationMethod.class);
    }

    @Override
    public UserVerificationMethod deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        long value = p.getValueAsLong();
        try {
            return UserVerificationMethod.create(value);
        } catch (IllegalArgumentException e) {
            throw new InvalidFormatException(null, "value is out of range", value, UserVerificationMethod.class);
        }
    }
}
