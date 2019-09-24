/*
 * Copyright 2018, EnMasse authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.enmasse.systemtest.shared.brokered.clients.rhea;

import io.enmasse.systemtest.bases.clients.ClientTestBase;
import io.enmasse.systemtest.bases.shared.ITestSharedBrokered;
import io.enmasse.systemtest.broker.ArtemisManagement;
import io.enmasse.systemtest.messagingclients.rhea.RheaClientReceiver;
import io.enmasse.systemtest.messagingclients.rhea.RheaClientSender;
import io.enmasse.systemtest.resolvers.ArtemisManagementParameterResolver;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.enmasse.systemtest.TestTag.ACCEPTANCE;

@Tag(ACCEPTANCE)
@ExtendWith(ArtemisManagementParameterResolver.class)
class MsgPatternsTest extends ClientTestBase implements ITestSharedBrokered {

    @Test
    void testBasicMessage() throws Exception {
        doBasicMessageTest(new RheaClientSender(logPath), new RheaClientReceiver(logPath));
    }

    @Test
    void testBasicMessageWebSocket() throws Exception {
        doBasicMessageTest(new RheaClientSender(logPath), new RheaClientReceiver(logPath), true);
    }

    @Test
    void testRoundRobinReceiver(ArtemisManagement artemisManagement) throws Exception {
        doRoundRobinReceiverTest(artemisManagement, new RheaClientSender(logPath), new RheaClientReceiver(logPath), new RheaClientReceiver(logPath));
    }

    @Test
    void testTopicSubscribe(ArtemisManagement artemisManagement) throws Exception {
        doTopicSubscribeTest(artemisManagement, new RheaClientSender(logPath), new RheaClientReceiver(logPath), new RheaClientReceiver(logPath), false);
    }

    @Test
    void testMessageBrowse() throws Exception {
        doMessageBrowseTest(new RheaClientSender(logPath), new RheaClientReceiver(logPath), new RheaClientReceiver(logPath));
    }

    @Test
    void testDrainQueue() throws Exception {
        doDrainQueueTest(new RheaClientSender(logPath), new RheaClientReceiver(logPath));
    }

    @Test
    void testMessageSelectorQueue() throws Exception {
        doMessageSelectorQueueTest(new RheaClientSender(logPath), new RheaClientReceiver(logPath));
    }

    @Test
    void testMessageSelectorTopic(ArtemisManagement artemisManagement) throws Exception {
        doMessageSelectorTopicTest(artemisManagement, new RheaClientSender(logPath), new RheaClientSender(logPath),
                new RheaClientReceiver(logPath), new RheaClientReceiver(logPath), false);
    }
}
