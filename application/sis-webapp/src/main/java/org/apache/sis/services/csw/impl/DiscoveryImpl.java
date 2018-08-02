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

import java.io.File;
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
import org.apache.cxf.jaxrs.ext.search.SearchCondition;
import org.apache.cxf.jaxrs.ext.search.fiql.FiqlParser;
import org.apache.sis.services.catalog.GeometryRelation;
import org.apache.sis.services.csw.DAO.DiscoveryDAO;
import org.apache.sis.services.csw.common.Query;
import org.apache.sis.services.csw.discovery.*;
import org.apache.sis.storage.DataStoreException;
import org.locationtech.jts.geom.Envelope;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.WKTReader;

/**
 *
 * @author haonguyen
 */
public final class DiscoveryImpl implements Discovery {

    private final DiscoveryDAO discovery;
    private Map<String, Record> listrecord;
    private Map<String, File> listpath;

    public DiscoveryImpl() throws DataStoreException {
        this.discovery = new DiscoveryDAO();
        this.listrecord = new HashMap<>();
        this.listpath = new HashMap<>();
        getAllRecord();
    }

    public void getAllRecord() {
        listrecord = discovery.record;
        listpath = discovery.pathfile;
    }

    public List<Record> filterRecordKVP(FilterFesKvp fes) throws ParseException, org.locationtech.jts.io.ParseException{
        List<Record> records = new ArrayList<>();
        if (fes.getRecordIds() != null) {
            String[] keys = fes.getRecordIds().split(",");
            for (String key : keys) {
                if (listrecord.get(key) != null) {
                    records.add(listrecord.get(key));
                }
            }
        }
        if (fes.getRecordIds() == null) {
            records = new ArrayList<>(listrecord.values());
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
            Envelope geos1 = new Envelope(Double.parseDouble(coord[0]),
                    Double.parseDouble(coord[2]),
                    Double.parseDouble(coord[1]),
                    Double.parseDouble(coord[3]));
            for (Record record : records) {
                if (record.getCoverage() != null) {
                    Envelope geos2 = new Envelope(record.getCoverage().getLowerCorner().get(0),
                            record.getCoverage().getUpperCorner().get(0),
                            record.getCoverage().getLowerCorner().get(1),
                            record.getCoverage().getUpperCorner().get(1));
                    if (geos1.intersects(geos2) == false) {
                        rm.add(record);
                    }
                } else {
                    rm.add(record);
                }
            }
            records.removeAll(rm);
        }
        if (fes.getTime() != null) {
            List<Record> rm = new ArrayList<>();
            String[] lttime = fes.getTime().split("/");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            if (lttime.length == 1) {

                for (Record record : records) {
                    if (record.getDate() != null) {
                        if (lttime[0].equals(format.format(record.getDate())) == false) {
                            rm.add(record);
                        }
                    } else {
                        rm.add(record);
                    }
                }
            } else if (lttime.length == 2) {
                if (format.parse(lttime[1]).after(format.parse(lttime[0])) == true) {
                    for (Record record : records) {
                        if (record.getDate() != null) {
                            Date date = record.getDate();
                            if (date.after(format.parse(lttime[1])) == true || date.before(format.parse(lttime[0])) == true) {
                                rm.add(record);
                            }
                        } else {
                            rm.add(record);
                        }
                    }
                }
            }
            records.removeAll(rm);
        }
        if (fes.getGeometry() != null) {
            List<Record> rm = new ArrayList<>();
            WKTReader rdr = new WKTReader();
            Geometry geos1 = rdr.read(fes.getGeometry());
            for (Record record : records) {
                if (record.getCoverage() != null) {
                    Geometry geos2 = rdr.read(parseBboxtoString(record.getCoverage()));
                    boolean compare = geometryRelation(geos1,geos2,fes.getRelation());
                    if (compare == false) {
                        rm.add(record);
                    }
                } else {
                    rm.add(record);
                }
            }
            records.removeAll(rm);
        }
        List<Record> abRecord = new ArrayList<>(records);
        return abRecord;
    }
    public String parseBboxtoString(BoundingBox bbox){
        double xmin = bbox.getLowerCorner().get(0);
        double xmax = bbox.getUpperCorner().get(0);
        double ymin = bbox.getLowerCorner().get(1);
        double ymax = bbox.getUpperCorner().get(1);
        String geos = "POLYGON (("  +xmin+" "+ymin+","
                                    +xmin+" "+ymax+","
                                    +xmax+" "+ymax+","
                                    +xmax+" "+ymin+","
                                    +xmin+" "+ymin+ "))";
        return geos;
    }
    public boolean geometryRelation(Geometry geos1,Geometry geos2,String relation){
        boolean result  = false;
        switch (relation) {
            case GeometryRelation.CONTAINS :
                result = geos1.contains(geos2);
                break;
            case GeometryRelation.CROSSES :
                result = geos1.crosses(geos2);
                break;
            case GeometryRelation.DISJOINT :
                result = geos1.disjoint(geos2);
                break;
            case GeometryRelation.EQUALS :
                result = geos1.equals(geos2);
                break;
            case GeometryRelation.INTERSECTS :
                result = geos1.intersects(geos2);
                break;
            case GeometryRelation.OVERLAPS :
                result = geos1.overlaps(geos2);
                break;
            case GeometryRelation.TOUCHES :
                result = geos1.touches(geos2);
                break;
            case GeometryRelation.WITHIN :
                result = geos1.within(geos2);
                break;
        }
        return result;
    }

    public List<Record> sortBy(Query query, List<Record> records) {
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
        return abRecord;
    }

    @Override
    public GetRecordsResponse getRecords(GetRecords getRecord) {
        GetRecordsResponse record = new GetRecordsResponse();
        SearchResults searchResults = new SearchResults();
        Query query = (Query) getRecord.getQuery();
        List<Record> records = new ArrayList<>(listrecord.values());
        if (query != null && query.getSortBy() != null) {
            records = sortBy(query, records);
        }
        if (query != null && query.getConstraint() != null) {
            FiqlParser<Record> parser = new FiqlParser<>(Record.class);
            SearchCondition<Record> condition = parser.parse(query.getConstraint().getSearch().toString());
            records = condition.findAll(records);
        }
        List<AbstractRecord> list = new ArrayList<>(records);
        int maxRecord = getRecord.getBasicRetrievalOptions().getMaxRecords();
        int startRecord = getRecord.getBasicRetrievalOptions().getStartPosition();
        searchResults.setNextRecord(startRecord + maxRecord);
        searchResults.setNumberOfRecordsMatched(list.size());
        searchResults.setNumberOfRecordsReturned(maxRecord);
        int toRecord = maxRecord * startRecord;
        if (toRecord >= list.size() && maxRecord * (startRecord - 1) <= list.size()) {
            searchResults.setAbstractRecord(list.subList(maxRecord * (startRecord - 1), list.size()));
        } else if (toRecord < list.size()) {
            searchResults.setAbstractRecord(list.subList((startRecord - 1) * maxRecord, toRecord));
        } else if (maxRecord * (startRecord - 1) > list.size()) {
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
            Query query = (Query) getRecord.getQuery();
            SearchResults searchResults = new SearchResults();
            List<Record> records = new ArrayList<>(filterRecordKVP(fes));
            if (query != null && query.getSortBy() != null) {
                records = sortBy(query, records);
            }
            if (query != null && query.getConstraint() != null) {
                FiqlParser<Record> parser = new FiqlParser<>(Record.class);
                SearchCondition<Record> condition = parser.parse(query.getConstraint().getSearch().toString());
                records = condition.findAll(records);
            }
            List<AbstractRecord> list;
            list = new ArrayList<>(records);
            int maxRecord = getRecord.getBasicRetrievalOptions().getMaxRecords();
            int startRecord = getRecord.getBasicRetrievalOptions().getStartPosition();
            searchResults.setNextRecord(startRecord + maxRecord);
            searchResults.setNumberOfRecordsMatched(list.size());
            searchResults.setNumberOfRecordsReturned(maxRecord);
            int toRecord = maxRecord * startRecord;
            if (toRecord >= list.size() && maxRecord * (startRecord - 1) <= list.size()) {
                searchResults.setAbstractRecord(list.subList(maxRecord * (startRecord - 1), list.size()));
            } else if (toRecord < list.size()) {
                searchResults.setAbstractRecord(list.subList((startRecord - 1) * maxRecord, toRecord));
            } else if (maxRecord * (startRecord - 1) > list.size()) {
                list.clear();
                searchResults.setAbstractRecord(list);
            }
            record.setSearchResults(searchResults);
            record.setRequestID(getRecord.getRequestId());
        } catch (ParseException | org.locationtech.jts.io.ParseException ex) {
            Logger.getLogger(DiscoveryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return record;
    }

    @Override
    public File getPath(String name){
        return listpath.get(name);
    }
}
