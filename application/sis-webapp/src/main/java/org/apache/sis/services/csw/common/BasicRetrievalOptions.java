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
package org.apache.sis.services.csw.common;

import javax.xml.bind.annotation.*;

/**
 *
 * @author haonguyen
 */
public class BasicRetrievalOptions {
    /**
     * The media type of the response message.
     */
    private String outputFormat = "application/xml";
    /**
     * The preferred schema for records in the result set.
     */
    private String outputSchema = "http://www.opengis.net/cat/csw/3.0";
    /**
     * Requests a slice of the result set, starting at this position.
     */
    private int startPosition;
    /**
     * The maximum number of records to return.
     */
    private int maxRecords;

    /**
     * Return The media type of the response message.
     * @return The media type of the response message.
     */
    @XmlAttribute
    public String getOutputFormat() {
        return outputFormat;
    }

    /**
     * Set The media type of the response message.
     * @param outputFormat
     */
    public void setOutputFormat(String outputFormat) {
        this.outputFormat = outputFormat;
    }

    /**
     * Return The preferred schema for records in the result set.
     * @return The preferred schema for records in the result set.
     */
    @XmlAttribute
    public String getOutputSchema() {
        return outputSchema;
    }

    /**
     * Set The preferred schema for records in the result set.
     * @param outputSchema
     */
    public void setOutputSchema(String outputSchema) {
        this.outputSchema = outputSchema;
    }

    /**
     * Return Requests a slice of the result set, starting at this position.
     * @return Requests a slice of the result set, starting at this position.
     */
    @XmlAttribute
    public int getStartPosition() {
        return startPosition;
    }

    /**
     * Set Requests a slice of the result set, starting at this position.
     * @param startPosition
     */
    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    /**
     * Return The maximum number of records to return.
     * @return The maximum number of records to return.
     */
    @XmlAttribute
    public int getMaxRecords() {
        return maxRecords;
    }

    /**
     * Set The maximum number of records to return.
     * @param maxRecords
     */
    public void setMaxRecords(int maxRecords) {
        this.maxRecords = maxRecords;
    }

}
