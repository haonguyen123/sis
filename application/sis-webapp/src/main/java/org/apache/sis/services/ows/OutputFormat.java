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

import javax.xml.bind.annotation.*;

/**
 *
 * @author haonguyen
 */
@XmlType(name = "OutputFormatType", namespace = Namespaces.OWS)
@XmlRootElement(name = "OutputFormat", namespace = Namespaces.OWS)
public class OutputFormat {
    /**
     * Reference to a format in which this data can be encoded and transferred.
     * More specific parameter names should be used by specific OWS specifications
     * wherever applicable. More than one such parameter can be included for
     * different purposes.
     */
    private String value;

    /**
     * Return a format in which this data can be encoded and transferred
     * @return a format in which this data can be encoded and transferred
     */
    @XmlValue
    public String getValue() {
        return value;
    }

    /**
     * Set a format in which this data can be encoded and transferred
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

}
