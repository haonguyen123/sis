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
package org.apache.sis.services.catalog;

import java.io.File;
import java.io.IOException;
import org.apache.sis.metadata.iso.DefaultMetadata;
import org.apache.sis.metadata.sql.MetadataStoreException;
import org.apache.sis.metadata.sql.MetadataWriter;
import org.apache.sis.storage.DataStore;
import org.apache.sis.storage.DataStoreException;
import org.apache.sis.storage.DataStores;
import org.opengis.metadata.Metadata;

/**
 *
 * @author haonguyen
 */
public class Read {

    private static MetadataWriter source;

    private void write() throws MetadataStoreException, DataStoreException, IOException {
//        DefaultCitation citation = new DefaultCitation();
//        citation.setTitle(new SimpleInternationalString("haonguyen"));
//        source.add(citation);
        Metadata meta = new DefaultMetadata();
        DataStore ds = DataStores.open(new File("/home/haonguyen/data/NetCDF/sst_ltm_1961-1990.nc"));
//          DataStore ds1 = DataStores.open(new File("/home/haonguyen/data/LC081260462017073101T1-SC20170831010609/LC08_L1TP_126046_20170731_20170811_01_T1_MTL.txt"));
//          meta=ds1.getMetadata();
        System.out.println(ds.getMetadata());
//          System.out.println(ds1.getMetadata());
//          String id = source.add(meta);
//          System.out.println(id);
//        source.add(HardCodedCitations.SIS);
    }
}
