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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.apache.sis.services.csw.common.BasicRetrievalOptions;
import org.apache.sis.services.csw.common.Query;
import org.apache.sis.services.csw.discovery.AbstractRecord;
import org.apache.sis.services.csw.discovery.BoundingBox;
import org.apache.sis.services.csw.discovery.FilterFesKvp;
import org.apache.sis.services.csw.discovery.GetDomain;
import org.apache.sis.services.csw.discovery.GetDomainResponse;
import org.apache.sis.services.csw.discovery.GetRecordById;
import org.apache.sis.services.csw.discovery.GetRecords;
import org.apache.sis.services.csw.discovery.GetRecordsResponse;
import org.apache.sis.services.csw.discovery.Record;
import org.apache.sis.services.csw.fes.DefaultPropertyName;
import org.apache.sis.services.csw.fes.DefaultSortBy;
import org.apache.sis.storage.DataStoreException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.opengis.filter.sort.SortOrder;

/**
 *
 * @author haonguyen
 */
public class DiscoveryImplTest {
    
    public DiscoveryImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllRecord method, of class DiscoveryImpl.
     */
    @Test
    public void testGetAllRecord() throws DataStoreException {
        System.out.println("getAllRecord");
        DiscoveryImpl instance = new DiscoveryImpl();
        instance.getAllRecord();
    }

    /**
     * Test of filterRecordKVP method, of class DiscoveryImpl.
     */
    @Test
    public void testFilterRecordKVP() throws Exception {
        System.out.println("filterRecordKVP");
        FilterFesKvp fes = new FilterFesKvp();
        fes.setQ("geotiff");
        DiscoveryImpl instance = new DiscoveryImpl();
        List<Record> result = instance.filterRecordKVP(fes);
        assertEquals(7, result.size());
    }

    /**
     * Test of parseBboxtoString method, of class DiscoveryImpl.
     */
    @Test
    public void testParseBboxtoString() throws DataStoreException {
        System.out.println("parseBboxtoString");
        BoundingBox bbox = new BoundingBox();
        bbox.setLowerCorner(new ArrayList<>(Arrays.asList(102.38, 9.56)));
        bbox.setUpperCorner(new ArrayList<>(Arrays.asList(110.38, 19.56)));
        DiscoveryImpl instance = new DiscoveryImpl();
        String expResult = "POLYGON ((102.38 9.56,102.38 19.56,110.38 19.56,110.38 9.56,102.38 9.56))";
        String result = instance.parseBboxtoString(bbox);
        assertEquals(expResult, result);
    }

    /**
     * Test of geometryRelation method, of class DiscoveryImpl.
     */
    @Test
    public void testGeometryRelation() throws DataStoreException, ParseException {
        System.out.println("geometryRelation");
        WKTReader rdr = new WKTReader();
        Geometry geos1 = rdr.read("POLYGON ((0 0, 0 340, 320 340, 320 0, 120 0, 180 100, 60 100, 120 0, 0 0),   (80 300, 80 180, 200 180, 200 240, 280 200, 280 280, 200 240, 200 300, 80 300))");
        Geometry geos2 = rdr.read("POLYGON ((0 0, 0 340, 320 340, 320 0, 120 0, 0 0),   (120 0, 180 100, 60 100, 120 0),   (80 300, 80 180, 200 180, 200 240, 200 300, 80 300),  (200 240, 280 200, 280 280, 200 240))");
        String relation = "intersects";
        DiscoveryImpl instance = new DiscoveryImpl();
        boolean expResult = true;
        boolean result = instance.geometryRelation(geos1, geos2, relation);
        assertEquals(expResult, result);
    }

    /**
     * Test of sortBy method, of class DiscoveryImpl.
     */
    @Test
    public void testSortBy() throws DataStoreException, java.text.ParseException {
        System.out.println("sortBy");
        String sortby = "modified:A";
        Query query = new Query();
        DefaultSortBy sort = new DefaultSortBy();
        DefaultPropertyName name = new DefaultPropertyName();
        String[] element = sortby.split(":");
        name.setPropertyName(element[0]);
        sort.setPropertyName(name);
        if ("A".equals(element[1])) {
            sort.setSortOrder(SortOrder.ASCENDING);
        }
        if ("D".equals(element[1])) {
            sort.setSortOrder(SortOrder.DESCENDING);
        }
        query.setSortBy(sort);
        List<Record> records = new ArrayList<>();
        Record record1 = new Record();
        record1.setIdentifier("Landsat8");
        String datestring1 = "2011-01-18 00:00:00.0";
        Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(datestring1);
        record1.setDate(date1);
        Record record2 = new Record();
        record2.setIdentifier("Landsat7");
        String datestring2 = "2012-01-18 00:00:00.0";
        Date date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(datestring2);
        record2.setDate(date2);
        records.add(record1);
        records.add(record2);
        DiscoveryImpl instance = new DiscoveryImpl();
        List<Record> result = instance.sortBy(query, records);
        assertEquals("Landsat8", result.get(0).getIdentifier());
    }

    /**
     * Test of getRecords method, of class DiscoveryImpl.
     */
    @Test
    public void testGetRecords_GetRecords() throws DataStoreException {
        System.out.println("getRecords");
        GetRecords getRecord = new GetRecords();
        BasicRetrievalOptions basicRetrievalOptions = new BasicRetrievalOptions();
        basicRetrievalOptions.setMaxRecords(10);
        basicRetrievalOptions.setStartPosition(1);
        getRecord.setBasicRetrievalOptions(basicRetrievalOptions);
        DiscoveryImpl instance = new DiscoveryImpl();
        GetRecordsResponse result = instance.getRecords(getRecord);
        assertEquals(10, result.getSearchResults().getAbstractRecord().size());
    }

    /**
     * Test of getRecordById method, of class DiscoveryImpl.
     */
    @Test
    public void testGetRecordById() throws DataStoreException {
        System.out.println("getRecordById");
        GetRecordById getRecordById = new GetRecordById();
        getRecordById.setId("sst_mnmean");
        DiscoveryImpl instance = new DiscoveryImpl();
        String expResult =  "Record{" +
                            "title=NOAA Optimum Interpolation (OI) SST V2, "+
                            "creator=National Centers for Environmental Prediction, "+
                            "subject=null, description=null, publisher=null, "+
                            "contributor=null, "+
                            "date=null, "+
                            "type=dataset, "+
                            "format=NetCDF Classic and 64-bit Offset Format, "+
                            "identifier=sst_mnmean, "+
                            "source=NCEP Climate Modeling Branch, "+
                            "language=null, "+
                            "relation=null, "+
                            "coverage=null, "+
                            "rights=null}" ;
        AbstractRecord result = instance.getRecordById(getRecordById);
        assertEquals(expResult, result.toString());
    }

    /**
     * Test of getDomain method, of class DiscoveryImpl.
     */
    @Test
    public void testGetDomain() throws DataStoreException {
        System.out.println("getDomain");
    }

    /**
     * Test of getRecords method, of class DiscoveryImpl.
     */
    @Test
    public void testGetRecords_GetRecords_FilterFesKvp() throws DataStoreException {
        System.out.println("getRecords");
        GetRecords getRecord = new GetRecords();
        BasicRetrievalOptions basicRetrievalOptions = new BasicRetrievalOptions();
        basicRetrievalOptions.setMaxRecords(5);
        basicRetrievalOptions.setStartPosition(2);
        getRecord.setBasicRetrievalOptions(basicRetrievalOptions);
        FilterFesKvp fes = new FilterFesKvp();
        fes.setQ("geotiff");
        DiscoveryImpl instance = new DiscoveryImpl();
        GetRecordsResponse result = instance.getRecords(getRecord, fes);
        assertEquals(2, result.getSearchResults().getAbstractRecord().size());
    }

    /**
     * Test of getPath method, of class DiscoveryImpl.
     */
    @Test
    public void testGetPath() throws DataStoreException {
        System.out.println("getPath");
        String name = "sst_mnmean";
        DiscoveryImpl instance = new DiscoveryImpl();
        File expResult = new File("/home/haonguyen/data/NetCDF/sst_mnmean.nc");
        File result = instance.getPath(name);
        assertEquals(expResult, result);
    }
    
}
