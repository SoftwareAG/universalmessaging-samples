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

package com.softwareaggov.messaging.simplejmsconsume.ejb.subscribe.processor;

import com.softwareaggov.messaging.libs.jms.processor.MessageProcessor;
import com.softwareaggov.messaging.libs.jms.processor.ProcessorOutput;
import com.softwareaggov.messaging.libs.jms.processor.impl.MockSleepProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jms.JMSException;
import javax.jms.Message;

/**
 * Created by fabien.sanglier on 6/23/16.
 */

@Stateless(name = "MockSleepProcessor")
@TransactionManagement(TransactionManagementType.BEAN)
@Local(MessageProcessorLocal.class)
public class MockSleepBean implements MessageProcessorLocal {
    private static Logger log = LoggerFactory.getLogger(MockSleepBean.class);

    @Resource(name = "mockSleepTimeInMillis")
    private Long mockSleepTimeInMillis = 0L;

    @Resource(name = "enableCloneProcessing")
    private Boolean enableCloneProcessing = false;

    private MessageProcessor processor;

    @PostConstruct
    public void initialize() {
        processor = new MockSleepProcessor(mockSleepTimeInMillis, enableCloneProcessing);
    }

    @Override
    public ProcessorOutput processMessage(Message msg) throws JMSException {
        return processor.processMessage(msg);
    }
}