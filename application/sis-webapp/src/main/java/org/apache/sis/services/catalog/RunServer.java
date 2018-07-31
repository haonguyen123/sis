package org.apache.sis.services.catalog;



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


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.ext.search.SearchContextProvider;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.sis.storage.DataStoreException;

/**
 *
 * @author haonguyen
 */
public final class RunServer {

    private RunServer() {
    }


    /**
     *
     * @param args
     */
    public static void main(String[] args) throws DataStoreException {
        JAXRSServerFactoryBean restServer = new JAXRSServerFactoryBean();
        restServer.setProvider(new SearchContextProvider());
        restServer.setResourceClasses(GetCapabilitiesService.class);
        restServer.setResourceProvider(new SingletonResourceProvider(new GetCapabilitiesService()));
        restServer.setAddress("http://192.168.1.9:9000/");
        restServer.create();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            br.readLine();
        } catch (IOException e) {
            System.out.println("Server Stopped");
        }
        System.exit(0);
    }
}
