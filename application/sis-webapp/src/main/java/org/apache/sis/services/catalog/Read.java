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
import java.sql.SQLException;
import org.apache.sis.metadata.MetadataStandard;
import org.apache.sis.metadata.iso.DefaultMetadata;
import org.apache.sis.metadata.sql.MetadataStoreException;
import org.apache.sis.metadata.sql.MetadataWriter;
import org.apache.sis.storage.DataStore;
import org.apache.sis.storage.DataStoreException;
import org.apache.sis.storage.DataStores;
import org.opengis.metadata.Metadata;
import org.postgresql.ds.PGSimpleDataSource;
import ucar.nc2.NetcdfFile;
import ucar.nc2.dataset.NetcdfDataset;
import ucar.nc2.util.CancelTask;

/**
 *
 * @author haonguyen
 */
public class Read {
    private static MetadataWriter source;
    private void write()  throws MetadataStoreException, DataStoreException, IOException{
//        DefaultCitation citation = new DefaultCitation();
//        citation.setTitle(new SimpleInternationalString("haonguyen"));
//        source.add(citation);
          Metadata meta = new DefaultMetadata();
          DataStore ds = DataStores.open(new File("/home/haonguyen/data/air_mon_1981-2010_ltm.nc"));
          DataStore ds1 = DataStores.open(new File("/home/haonguyen/data/LC081260462017073101T1-SC20170831010609/LC08_L1TP_126046_20170731_20170811_01_T1_MTL.txt"));
          meta=ds1.getMetadata();
          System.out.println(ds.getMetadata());
          System.out.println(ds1.getMetadata());
           
             
//          String id = source.add(meta);
//          System.out.println(id);
//        source.add(HardCodedCitations.SIS);
    }

    /**
     *
     * @param args
     * @throws DataStoreException
     * @throws MetadataStoreException
     * @throws SQLException
     * @throws IOException
     */
//    public static void main(String[] args) throws DataStoreException, MetadataStoreException, SQLException, IOException {
//        Read read = new Read();
//        final  PGSimpleDataSource ds = new  PGSimpleDataSource();
//        ds.setServerName("localhost");
//        ds.setDatabaseName("csw");
//        ds.setUser("postgres");
//        ds.setPassword("1234");
//        source = new MetadataWriter(MetadataStandard.ISO_19115, ds, null, null);
////        MetadataSource metadata = source.getProvided();
////        Metadata format = source.lookup(Metadata.class, "LC81260462017212LGN00");
////          System.out.println(format.getAcquisitionInformation().);
////        DataStore ds = DataStores.open(new File("/home/haonguyen/data/2005092200_sst_21-24.en.nc"));
////        
////            Metadata a = source.lookup(Metadata.class,"fd"); 
////            System.out.println(format);
////        AbstractMetadata
//        try {
//            read.write();
//            
//        } finally {
//            source.close();
//        }
//        // Registration assuming that a JNDI implementation is available
////        Context env = (Context) InitialContext.doLookup("java:comp/env");
////        env.bind("jdbc/SpatialMetadata", ds);
//    }
}