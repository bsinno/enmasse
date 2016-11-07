/*
 * Copyright 2016 Red Hat Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package enmasse.mqtt.messages;

import org.apache.qpid.proton.message.Message;

/**
 * Represents an AMQP_SESSION message
 */
public class AmqpSessionMessage {

    public static final String SUBJECT = "session";

    /**
     * Return an AMQP_SESSION message from the raw AMQP one
     *
     * @param message   raw AMQP message
     * @return  AMQP_SESSION message
     */
    public static AmqpSessionMessage from(Message message) {

        // TODO:
        return new AmqpSessionMessage();
    }
}
