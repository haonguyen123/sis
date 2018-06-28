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
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.sis.storage.DataStore;
import org.apache.sis.storage.DataStores;
import org.opengis.metadata.Metadata;
//import static org.apache.sis.util.resources.Vocabulary.Keys.File;

/**
 *
 * @author haonguyen
 */
public class DataStoreDAO {
    private static  Map<String, Metadata> map ;

    public DataStoreDAO() {
        try (DataStore ds = DataStores.open(new File("/home/haonguyen/data/LC081260462017073101T1-SC20170831010609/LC08_L1TP_126046_20170731_20170811_01_T1_b1.tif"))){
            map = new HashMap<String, Metadata>();
            map.put(ds.getDisplayName(),ds.getMetadata());
        } catch (Exception e) {
        }
    }
    public static void main(String args[]) {
        DataStoreDAO data = new DataStoreDAO();
        Set<String> set = map.keySet();
        for (String key : set) {
            System.out.println(key + " " + map.get(key));
        }
    }
}