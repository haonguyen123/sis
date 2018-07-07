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
import javax.xml.bind.JAXBException;
import org.apache.sis.services.csw.discovery.AbstractRecord;
import org.apache.sis.services.csw.discovery.GetRecordsResponse;
import org.apache.sis.services.csw.discovery.Record;
import org.apache.sis.services.csw.discovery.SearchResults;
import org.apache.sis.storage.DataStore;
import org.apache.sis.storage.DataStoreException;
import org.apache.sis.storage.DataStores;
import org.apache.sis.xml.XML;
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
    public Map<String, AbstractRecord> record;

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
    public void allRecords() throws DataStoreException{
        DataStore ds = DataStores.open(new File("/home/haonguyen/data/air_mon_1981-2010_ltm.nc"));
        DataStore ds1 = DataStores.open(new File("/home/haonguyen/data/LC081260462017073101T1-SC20170831010609/LC08_L1TP_126046_20170731_20170811_01_T1_MTL.txt"));
        DataStore ds2 = DataStores.open(new File("/home/haonguyen/data/LT051260462011101901T1-SC20170906064225/LT05_L1TP_126046_20111019_20161005_01_T1_MTL.txt"));
        DataStore ds3 = DataStores.open(new File("/home/haonguyen/data/icec.wkmean.1990-present.nc"));
        DataStore ds4 = DataStores.open(new File("/home/haonguyen/data/sst_mon_ltm_1981-2010.nc"));
        metadata.add(ds.getMetadata());
        metadata.add(ds1.getMetadata());
        metadata.add(ds2.getMetadata());
        metadata.add(ds3.getMetadata());
        metadata.add(ds4.getMetadata());
        for( final Metadata meta : metadata){
            Record re = new Record(meta,Locale.ENGLISH);
            record.put(re.getIdentifier(),re);
        }
    }
}
