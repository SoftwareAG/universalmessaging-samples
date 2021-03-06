/*
 * Copyright © 2016 - 2018 Software AG, Darmstadt, Germany and/or its licensors
 *
 * SPDX-License-Identifier: Apache-2.0
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

package com.softwareaggov.messaging.simplejmssendoneway.web.compareTests;

import com.softwareaggov.messaging.simplejmssendoneway.ejb.publish.MessageInteropLocal;
import com.softwareaggov.messaging.simplejmssendoneway.web.BaseMessageProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;

/**
 * <p>
 * A servlet that sends several JMS messages to a JMS queue or a topic
 * as defined by the jmsDestination variable that is bound to a JCA admin object (hence using JCA construct)
 * </p>
 * <p/>
 * The servlet is registered and mapped to /JcaQueueProxyMessageProducer using the {@linkplain javax.servlet.annotation.WebServlet
 *
 * @author Fabien Sanglier
 * @HttpServlet}. </p>
 */
@WebServlet("/JmsSendAndForgetRuntimeJndiLookups")
public class JmsSendAndForgetRuntimeJndiLookups extends BaseMessageProducer {
    private static final long serialVersionUID = -8314702649252239L;
    private static Logger log = LoggerFactory.getLogger(JmsSendAndForgetRuntimeJndiLookups.class);

    @EJB(beanName = "JmsSendAndForgetRuntimeJndiLookupsService")
    private MessageInteropLocal jmsSimplePublisher;

    @Override
    protected final MessageInteropLocal getJmsPublisherLocal() {
        return jmsSimplePublisher;
    }
}
