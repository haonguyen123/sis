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
package org.apache.sis.services.ows;

import java.util.List;
import javax.xml.bind.annotation.*;

/**
 *
 * @author haonguyen
 */
@XmlRootElement(name = "AllowedValues", namespace = Namespaces.OWS)
public class AllowedValues {
    /**
     * List of all the valid values  for this quantity.
     * For numeric quantities, signed values should be ordered from negative 
     * infinity to positive infinity.
     */
    private List<Value> value;

    /**
     * Return list of all the valid values  for this quantity
     * @return list of all the valid values  for this quantity
     */
    @XmlElement(name = "Value", namespace = Namespaces.OWS)
    public List<Value> getValue() {
        return value;
    }

    /**
     * Set list of all the valid values  for this quantity
     * @param value
     */
    public void setValue(List<Value> value) {
        this.value = value;
    }

}
