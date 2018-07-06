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

package com.softwareaggov.messaging.simplesoapjms.server.ejb.soap;

/**
 * Created by fabien.sanglier on 7/3/18.
 */

import com.softwareaggov.messaging.simplesoapjms.server.ejb.TestProcessorLocal;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;

@Stateless
@Remote(TestWebServiceRemote.class)
@WebService
    (
        serviceName = "TestWebService",
        endpointInterface = "com.softwareaggov.messaging.simplesoapjms.server.ejb.soap.TestWebServiceRemote",
        portName = "TestWebServicePort"
    )
public class TestWebService implements TestWebServiceRemote {

  @EJB
  protected TestProcessorLocal testProcessorLocal;

  @Override
  public String processAndReply(String content) {
    return testProcessorLocal.processAndReply(content);
  }

  @Override
  public void processOneWay(String content) {
    testProcessorLocal.processOneWay(content);
  }
}
