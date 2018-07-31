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

import java.net.URI;
import javax.xml.bind.annotation.*;
import org.apache.sis.services.csw.common.AbstractQuery;
import org.apache.sis.services.csw.common.BasicRetrievalOptions;
import org.apache.sis.services.csw.common.RequestBase;

/**
 *
 * @author haonguyen
 */
@XmlType(name = "GetRecordsType", namespace = Namespaces.CSW, propOrder = {
    "distributedSearch",
    "responseHandler",
    "query",})
@XmlRootElement(name = "GetRecords", namespace = Namespaces.CSW)
public class GetRecords extends RequestBase {
    /**
     * Governs the behaviour of a distributed search.
     * hopCount - the maximum number of message hops before the search is terminated.
     * Each catalogue node decrements this value when the request is received,
     * and must not forward the request if hopCount=0.
     */
    private DistributedSearch distributedSearch;
    private String responseHandler;
    /**
     * Specifies a query to execute against instances of one or more object types.
     * A set of ElementName elements may be included to specify an adhoc view of
     * the csw30:Record instances in the result set. Otherwise, use ElementSetName
     * to specify a predefined view. The Constraint element contains a query filter
     * expressed in a supported query language. A sorting criterion that specifies
     * a property to sort by may be included. typeNames - a list of object types to query.
     */
    private Object query;
    /**
     * RequestId becomes mandatory in the case of a distributed search.
     * Must be a unique Id (i.e. a UUID).
     */
    private URI requestId;
    /**
     * Various attributes that specify basic retrieval options:
     * outputFormat - the media type of the response message
     * outputSchema - the preferred schema for records in the result set
     * startPosition - requests a slice of the result set, starting at this position
     * maxRecords - the maximum number of records to return.
     * No records are returned if maxRecords=0.
     */
    private BasicRetrievalOptions basicRetrievalOptions;

    /**
     * Return Governs the behaviour of a distributed search.
     * @return Governs the behaviour of a distributed search.
     */
    @XmlElement(name = "DistributedSearch", namespace = Namespaces.CSW)
    public DistributedSearch getDistributedSearch() {
        return distributedSearch;
    }

    /**
     * Set Governs the behaviour of a distributed search.
     * @param distributedSearch
     */
    public void setDistributedSearch(DistributedSearch distributedSearch) {
        this.distributedSearch = distributedSearch;
    }

    /**
     *
     * @return
     */
    @XmlElement(name = "ResponseHandler", namespace = Namespaces.CSW)
    public String getResponseHandler() {
        return responseHandler;
    }

    /**
     *
     * @param responseHandler
     */
    public void setResponseHandler(String responseHandler) {
        this.responseHandler = responseHandler;
    }

    /**
     * Return Specifies a query to execute against instances of one or more object types.
     * @return Specifies a query to execute against instances of one or more object types.
     */
    @XmlElements({
        @XmlElement(name = "AbstractQuery", type = AbstractQuery.class)})
    public Object getQuery() {
        return query;
    }

    /**
     * Set Specifies a query to execute against instances of one or more object types.
     * @param query
     */
    public void setQuery(Object query) {
        this.query = query;
    }

    /**
     * Return RequestId becomes mandatory in the case of a distributed search.
     * @return RequestId becomes mandatory in the case of a distributed search.
     */
    @XmlAttribute
    public URI getRequestId() {
        return requestId;
    }

    /**
     * Set RequestId becomes mandatory in the case of a distributed search.
     * @param requestId
     */
    public void setRequestId(URI requestId) {
        this.requestId = requestId;
    }

    /**
     * Return Various attributes that specify basic retrieval options .
     * @return Various attributes that specify basic retrieval options.
     */
    @XmlAttribute
    public BasicRetrievalOptions getBasicRetrievalOptions() {
        return basicRetrievalOptions;
    }

    /**
     * Set Various attributes that specify basic retrieval options.
     * @param basicRetrievalOptions
     */
    public void setBasicRetrievalOptions(BasicRetrievalOptions basicRetrievalOptions) {
        this.basicRetrievalOptions = basicRetrievalOptions;
    }
}
