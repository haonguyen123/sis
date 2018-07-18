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
package org.apache.sis.services.csw.DAO;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.sis.services.catalog.CatalogueProperties;
import org.apache.sis.services.csw.discovery.Record;
import org.apache.sis.storage.DataStore;
import org.apache.sis.storage.DataStoreException;
import org.apache.sis.storage.DataStores;
import org.opengis.metadata.Metadata;

/**
 *
 * @author haonguyen
 */
public class DiscoveryDAO {

    private List<Metadata> metadata;

    /**
     *
     */
    public Map<String, Record> record;
    /**
     *
     * @throws DataStoreException
     */
    public DiscoveryDAO() throws DataStoreException {
        this.metadata = new ArrayList<>();
        this.record = new HashMap<>();
        allRecords();
    }
    /**
     *
     * @throws DataStoreException
     */
    public void allRecords() throws DataStoreException {
        CatalogueProperties catalog = new CatalogueProperties();
        File directory = new File(catalog.getPathdata());
        File[] folder = directory.listFiles();
        for (File a : folder) {
            if (a.getName().toLowerCase().contains("landsat")) {
                for (File landsat : a.listFiles()) {
                    for (File txt : landsat.listFiles()) {
                        if (txt.getName().contains("_MTL.txt")) {
                            DataStore ds = DataStores.open(new File(txt.getAbsolutePath()));
                            Record re = new Record(ds.getMetadata(), Locale.ENGLISH);
                            record.put(re.getIdentifier(), re);
                        }
                    }
                }
            }
            if (a.getName().toLowerCase().contains("netcdf")) {
                for (File netcdf : a.listFiles()) {
                    DataStore ds = DataStores.open(new File(netcdf.getAbsolutePath()));
                    Record re = new Record(ds.getMetadata(), Locale.ENGLISH);
                    record.put(re.getIdentifier(), re);
                }
            }
        }
    }
//    public static void main(String[] args) throws DataStoreException, ParseException {
//        FiqlParser<Record> parser = new FiqlParser(Record.class);
//        DiscoveryDAO a = new DiscoveryDAO();
//        SearchCondition<Record> condition4 = parser.parse("title==*LC*");
//        System.out.println(condition4.findAll(record.values()).size());
//        Geometry geom = rdr.read("POLYGON ((0 0, 0 340, 320 340, 320 0, 120 0, 180 100, 60 100, 120 0, 0 0),   (80 300, 80 180, 200 180, 200 240, 280 200, 280 280, 200 240, 200 300, 80 300))");
//        Geometry geom2 = rdr.read("POLYGON ((0 0, 0 340, 320 340, 320 0, 120 0, 0 0),   (120 0, 180 100, 60 100, 120 0),   (80 300, 80 180, 200 180, 200 240, 200 300, 80 300),  (200 240, 280 200, 280 280, 200 240))");
//        System.out.println(geom.intersects(geom2));
//    }
     
}
