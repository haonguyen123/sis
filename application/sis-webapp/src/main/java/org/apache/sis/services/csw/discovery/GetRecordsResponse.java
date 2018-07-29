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

/**
 *
 * @author haonguyen
 */
@XmlType(name = "GetRecordsType", namespace = Namespaces.CSW, propOrder = {
    "requestID",
    "searchStatus",
    "searchResults",})
@XmlRootElement(name = "GetRecords", namespace = Namespaces.CSW)
/**
 * The response message for a GetRecords request. 
 * Some or all of the matching records may be included as children of the 
 * SearchResults element. The RequestId is only included if the client specified it.
 */
public class GetRecordsResponse {
    /**
     * The requestId parameter may be included to uniquely identify a request message.
     */
    private URI requestID;
    /**
     * This element provides information about the status of the search request. 
     * status - status of the search timestamp - the date and time when the 
     * result set was modified (ISO 8601 format: YYYY-MM-DDThh:mm:ss[+|-]hh:mm).
     */
    private RequestStatus searchStatus;
    /**
     * Includes representations of result set members . 
     * The items must conform to one of the csw30:Record views or a profile-specific 
     * representation. 
     * resultSetId - id of the result set (a URI). 
     * elementSet - The element set that has been returned (e.g., "brief", "summary", "full") 
     * recordSchema - schema reference for included records(URI) 
     * numberOfRecordsMatched - number of records matched by the query 
     * numberOfRecordsReturned - number of records returned to client 
     * nextRecord - position of next record in the result set (0 if no records remain). 
     * expires - the time instant when the result set expires and is discarded (ISO8601 format) 
     * elapsedTime - runtime information of the search within the federated catalogue
     */
    private SearchResults searchResults;

    /**
     * Return The requestId parameter may be included.
     * @return The requestId parameter may be included.
     */
    @XmlElement(name = "RequestID", namespace = Namespaces.CSW)
    public URI getRequestID() {
        return requestID;
    }

    /**
     * Set The requestId parameter may be included.
     * @param requestID
     */
    public void setRequestID(URI requestID) {
        this.requestID = requestID;
    }

    /**
     * Return representations of result set members .
     * @return representations of result set members .
     */
    @XmlElement(name = "SearchStatus", namespace = Namespaces.CSW)
    public RequestStatus getSearchStatus() {
        return searchStatus;
    }

    /**
     * Set representations of result set members .
     * @param searchStatus
     */
    public void setSearchStatus(RequestStatus searchStatus) {
        this.searchStatus = searchStatus;
    }

    /**
     * Return representations of result set members.
     * @return Includes representations of result set members . 
     */
    @XmlElement(name = "SearchResults", namespace = Namespaces.CSW)
    public SearchResults getSearchResults() {
        return searchResults;
    }

    /**
     * Set representations of result set members.
     * @param searchResults
     */
    public void setSearchResults(SearchResults searchResults) {
        this.searchResults = searchResults;
    }

}
