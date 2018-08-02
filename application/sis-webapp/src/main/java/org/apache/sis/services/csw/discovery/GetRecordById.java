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
package org.apache.sis.services.csw.discovery;

import javax.xml.bind.annotation.*;
import org.apache.sis.services.csw.common.ElementSetName;
import org.apache.sis.services.csw.common.RequestBase;

/**
 *
 * @author haonguyen
 */
@XmlType(name="GetRecordByIdType",namespace=Namespaces.CSW)
@XmlRootElement(name="GetRecordById",namespace=Namespaces.CSW)
/**
 * Convenience operation to retrieve default record representations by identifier.
 * Id - object identifier (a URI) that provides a reference to a catalog item (
 * or a result set if the catalog supports persistent result sets).
 * ElementSetName - one of "brief, "summary", or "full"
 */
public class GetRecordById extends RequestBase{
    /**
     * Object identifier (a URI) that provides a reference to a catalog.
     */
    private String id;
    /**
     * One of "brief, "summary", or "full".
     */
    private ElementSetName elementSetName;
    private String outputFormat="application/xml";
    private String outputSchema;

    /**
     * Return Object identifier (a URI) that provides a reference to a catalogue.
     * @return Object identifier (a URI) that provides a reference to a catalogue.
     */
    @XmlElement(name="Id")
    public String getId() {
        return id;
    }

    /**
     * Set Object identifier (a URI) that provides a reference to a catalogue.
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Return One of "brief, "summary", or "full" record.
     * @return One of "brief, "summary", or "full".
     */
    @XmlElement(name="ElementSetName",namespace = Namespaces.CSW)
    public ElementSetName getElementSetName() {
        return elementSetName;
    }

    /**
     * Set One of "brief, "summary", or "full".
     * @param elementSetName
     */
    public void setElementSetName(ElementSetName elementSetName) {
        this.elementSetName = elementSetName;
    }

    @XmlAttribute
    public String getOutputFormat() {
        return outputFormat;
    }

    public void setOutputFormat(String outputFormat) {
        this.outputFormat = outputFormat;
    }

    @XmlAttribute
    public String getOutputSchema() {
        return outputSchema;
    }

    public void setOutputSchema(String outputSchema) {
        this.outputSchema = outputSchema;
    }
}
