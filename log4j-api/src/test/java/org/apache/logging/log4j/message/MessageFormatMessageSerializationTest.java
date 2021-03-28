/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache license, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the license for the specific language governing permissions and
 * limitations under the license.
 */

package org.apache.logging.log4j.message;

import java.util.Arrays;
import java.util.Collection;

import org.apache.logging.log4j.test.AbstractSerializationTest;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.api.parallel.Resources;
import org.junit.runners.Parameterized;

@ResourceLock(value = Resources.LOCALE, mode = ResourceAccessMode.READ)
public class MessageFormatMessageSerializationTest extends AbstractSerializationTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {new MessageFormatMessage("Test")},
            {new MessageFormatMessage("Test {0} {1}", "message", "test")},
            {new MessageFormatMessage("{0}{1}{2}", 3, '.', 14L)}
        });
    }

    public MessageFormatMessageSerializationTest(final MessageFormatMessage message) {
        super(message);
    }
}
