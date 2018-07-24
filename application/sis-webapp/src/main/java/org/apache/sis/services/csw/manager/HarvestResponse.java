/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.sis.services.csw.manager;

import javax.xml.bind.annotation.*;

/**
 *
 * @author haonguyen
 */
@XmlType(name = "HarvestResponseType", namespace = Namespaces.CSW)
@XmlRootElement(name = "HarvestResponse", namespace = Namespaces.CSW)
public class HarvestResponse {

    private Object choice;

    /**
     *
     * @return
     */
    @XmlElements({
        @XmlElement(name = "TransactionResponse", type = TransactionResponse.class)
    })
    public Object getChoice() {
        return choice;
    }

    /**
     *
     * @param choice
     */
    public void setChoice(Object choice) {
        this.choice = choice;
    }

}