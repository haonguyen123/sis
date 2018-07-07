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
package org.apache.sis.services.csw.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.sis.services.csw.DAO.DiscoveryDAO;
import org.apache.sis.services.csw.discovery.AbstractRecord;
import org.apache.sis.services.csw.discovery.Discovery;
import org.apache.sis.services.csw.discovery.GetDomain;
import org.apache.sis.services.csw.discovery.GetDomainResponse;
import org.apache.sis.services.csw.discovery.GetRecordById;
import org.apache.sis.services.csw.discovery.GetRecords;
import org.apache.sis.services.csw.discovery.GetRecordsResponse;
import org.apache.sis.services.csw.discovery.SearchResults;
import org.apache.sis.storage.DataStoreException;

/**
 *
 * @author haonguyen
 */
public class DiscoveryImpl implements Discovery{
    private DiscoveryDAO discovery;

    /**
     *
     * @throws DataStoreException
     */
    public DiscoveryImpl() throws DataStoreException {
        this.discovery = new DiscoveryDAO();
    }
    
    @Override
    public GetRecordsResponse getRecords(GetRecords getRecord) {
        GetRecordsResponse record = new GetRecordsResponse();
        try {
            discovery.allRecords();
            SearchResults searchResults = new SearchResults();
            List<AbstractRecord> list = new ArrayList(discovery.record.values());
            searchResults.setAbstractRecord(list);
            record.setSearchResults(searchResults);
        } catch (DataStoreException ex) {
            Logger.getLogger(DiscoveryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return record;
    }

    @Override
    public AbstractRecord getRecordById(GetRecordById getRecordById) {
        return discovery.record.get(getRecordById.getId());
    }

    @Override
    public GetDomainResponse getDomain(GetDomain getDomain) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
