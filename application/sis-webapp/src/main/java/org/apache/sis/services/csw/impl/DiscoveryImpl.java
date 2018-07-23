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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.apache.sis.services.csw.DAO.DiscoveryDAO;
import org.apache.sis.services.csw.common.Query;
import org.apache.sis.services.csw.discovery.AbstractRecord;
import org.apache.sis.services.csw.discovery.Discovery;
import org.apache.sis.services.csw.discovery.FilterFesKvp;
import org.apache.sis.services.csw.discovery.GetDomain;
import org.apache.sis.services.csw.discovery.GetDomainResponse;
import org.apache.sis.services.csw.discovery.GetRecordById;
import org.apache.sis.services.csw.discovery.GetRecords;
import org.apache.sis.services.csw.discovery.GetRecordsResponse;
import org.apache.sis.services.csw.discovery.Record;
import org.apache.sis.services.csw.discovery.SearchResults;
import org.apache.sis.storage.DataStoreException;
import org.locationtech.jts.geom.Envelope;

/**
 *
 * @author haonguyen
 */
public class DiscoveryImpl implements Discovery {

    private final DiscoveryDAO discovery;
    private Map<String, Record> listrecord;

    /**
     *
     * @throws DataStoreException
     */

    public DiscoveryImpl() throws DataStoreException {
        this.discovery = new DiscoveryDAO();
        this.listrecord = new HashMap<>();
        getAllRecord();
    }

    public void getAllRecord() {
        listrecord = discovery.record;
    }

    public List<Record> filterRecordKVP(FilterFesKvp fes) throws ParseException {
        List<Record> abRecord = new ArrayList<>();
        List<Record> records = new ArrayList<>();
        if (fes.getRecordIds() != null) {
            String [] keys = fes.getRecordIds().split(",");
            for(String key : keys) {
                if (listrecord.get(key) != null) 
                    records.add(listrecord.get(key));
            }
        }
        if (fes.getRecordIds() == null) {
            records = new ArrayList(listrecord.values());
        }
        if (fes.getQ() != null) {
            records = records.stream()
                    .filter(record -> record.toString().toLowerCase().contains(fes.getQ().toLowerCase()))
                    .collect(Collectors.toList());
        }
        if (fes.getBbox() != null) {
            String bbox = fes.getBbox();
            String[] coord = bbox.split(",");
            List<Record> rm = new ArrayList<>();
            Envelope geos1= new Envelope(   Double.parseDouble(coord[0]),                 
                                            Double.parseDouble(coord[2]),
                                            Double.parseDouble(coord[1]),
                                            Double.parseDouble(coord[3]));
            for (Record record : records) {
                if (record.getCoverage() != null) {
                    Envelope geos2= new Envelope(   record.getCoverage().getLowerCorner().get(0),            
                                                    record.getCoverage().getUpperCorner().get(0), 
                                                    record.getCoverage().getLowerCorner().get(1),
                                                    record.getCoverage().getUpperCorner().get(1));
                    if (geos1.intersects(geos2) == false ) {
                        rm.add(record);
                    }
                }
                else rm.add(record);
            }
            records.removeAll(rm);
        }
        if (fes.getTime() != null) {
            List<Record> rm = new ArrayList<>();
            String[] lttime = fes.getTime().split("/");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            if (lttime.length ==1) {
                
                for (Record record : records) {
                    if (record.getDate() != null) {
                        if(lttime[0].equals(format.format(record.getDate())) == false ){
                            rm.add(record);
                        } 
                    }
                    else rm.add(record);
                }
            }
            else if (lttime.length ==2) {
                if (format.parse(lttime[1]).after(format.parse(lttime[0])) == true) {
                    for (Record record : records) {
                        if (record.getDate() != null) {
                            Date date = record.getDate();
                            if(date.after(format.parse(lttime[1])) == true || date.before(format.parse(lttime[0])) ==true){
                                rm.add(record);
                            } 
                        }
                        else rm.add(record);
                    } 
                }
            }
            System.out.println(rm.size());
            records.removeAll(rm);

        }
        abRecord = new ArrayList(records);
        return abRecord;
    }
    public List<Record>  sortBy(Query query,List<Record> records){
        List<Record> record = records;
        if ("modified".equals(query.getSortBy().getPropertyName().getPropertyName()) && "ASCENDING".equals(query.getSortBy().getSortOrder().name())) {
            Collections.sort(record, Record.dateComparatorA);
            }
        if ("modified".equals(query.getSortBy().getPropertyName().getPropertyName()) && "DESCENDING".equals(query.getSortBy().getSortOrder().name())) {
            Collections.sort(record, Record.dateComparatorD);
            }
        return record;
    }
    public List<AbstractRecord> filterRecord(String constraint) {
        List<AbstractRecord> abRecord = new ArrayList<>();
        System.out.println("filter record");
        return abRecord;
    }
    @Override
    public GetRecordsResponse getRecords(GetRecords getRecord) {
        GetRecordsResponse record = new GetRecordsResponse();
        SearchResults searchResults = new SearchResults();
        Query query = new Query();
        query = (Query) getRecord.getQuery();
        List<Record> records = new ArrayList(listrecord.values());
        if (query != null && query.getSortBy() != null) {
            records = sortBy(query,records);
        }   
        List<AbstractRecord> list = new ArrayList(records);
        int maxRecord = getRecord.getBasicRetrievalOptions().getMaxRecords();
        int startRecord = getRecord.getBasicRetrievalOptions().getStartPosition();
        searchResults.setNextRecord(startRecord + maxRecord);
        searchResults.setNumberOfRecordsMatched(list.size());
        searchResults.setNumberOfRecordsReturned(maxRecord);
        int toRecord = maxRecord*startRecord - 1;
        if (toRecord >= list.size() && maxRecord*(startRecord - 1) <= list.size() ) {
            searchResults.setAbstractRecord(list.subList(maxRecord*(startRecord - 1), list.size()));
        } 
        else if (toRecord < list.size()) {
            searchResults.setAbstractRecord(list.subList((startRecord - 1)*maxRecord, toRecord));
        }
        else if (maxRecord*(startRecord - 1) > list.size()) {
            list.clear();
            searchResults.setAbstractRecord(list);
        }
        record.setSearchResults(searchResults);
        record.setRequestID(getRecord.getRequestId());
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

    @Override
    public GetRecordsResponse getRecords(GetRecords getRecord, FilterFesKvp fes) {
        GetRecordsResponse record = new GetRecordsResponse();
        try {
            Query query = new Query();
            query = (Query) getRecord.getQuery();
            SearchResults searchResults = new SearchResults();
            List<Record> records = new ArrayList(filterRecordKVP(fes));
            if (query != null && query.getSortBy() != null) {
                records = sortBy(query,records);
            }   
            List<AbstractRecord> list = new ArrayList(records);
            int maxRecord = getRecord.getBasicRetrievalOptions().getMaxRecords();
            int startRecord = getRecord.getBasicRetrievalOptions().getStartPosition();
            searchResults.setNextRecord(startRecord + maxRecord);
            searchResults.setNumberOfRecordsMatched(list.size());
            searchResults.setNumberOfRecordsReturned(maxRecord);
            int toRecord = maxRecord*startRecord - 1;
            if (toRecord >= list.size() && maxRecord*(startRecord - 1) <= list.size()) {
                searchResults.setAbstractRecord(list.subList(maxRecord*(startRecord - 1), list.size()));
            } 
            else if (toRecord < list.size()) {
                searchResults.setAbstractRecord(list.subList((startRecord - 1)*maxRecord, toRecord));
            }
            else if (maxRecord*(startRecord - 1) > list.size()) {
                list.clear();
                searchResults.setAbstractRecord(list);
            }
            record.setSearchResults(searchResults);
            record.setRequestID(getRecord.getRequestId());
            
        } catch (ParseException ex) {
            Logger.getLogger(DiscoveryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return record;
    }
    public static void main(String[] args) throws DataStoreException, ParseException {
        DiscoveryImpl a = new DiscoveryImpl();
        List<String> id = new ArrayList<>();
        FilterFesKvp fes = new FilterFesKvp();
//        fes.setBbox("89.658721,22.689607,90.493351,23.476758");
//        fes.setBbox("105.942440,20.437593,106.453925,20.777734");
        System.out.println(a.filterRecordKVP(fes).size());
    }
}
