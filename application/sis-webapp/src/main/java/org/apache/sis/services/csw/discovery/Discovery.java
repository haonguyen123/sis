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

import java.io.File;


/**
 *
 * @author haonguyen
 */
public interface Discovery {

    /**
     * The principal means of searching the catalogue.
     * The matching catalog entries may be included with the response.
     * The client may assign a requestId (absolute URI). A distributed search is
     * performed if the DistributedSearch element is present and the catalogue
     * is a member of a federation. Profiles may allow alternative query expressions.
     * @param getRecord
     * @return RecordsResponse
     */
    public GetRecordsResponse getRecords(GetRecords getRecord);

    /**
     * Searching the catalogue.
     * @param getRecord
     * @param fes KVP parameters that may be used to express complex filters encoded using CQL and OGC Filter.
     * @return RecordsResponse
     */
    public GetRecordsResponse getRecords(GetRecords getRecord,FilterFesKvp fes);
    /**
     * The mandatory GetRecordById request retrieves the default representation
     * of catalogue records using its identifier.
     * @param getRecordById
     * @return a catalogue record using it identifier.
     */
    public AbstractRecord getRecordById(GetRecordById getRecordById);

    public GetDomainResponse getDomain(GetDomain getDomain);

    public File getPath(String name);
}
