package org.apache.sis.services.csw.ogcservice;

import javax.xml.bind.annotation.*;
import org.apache.sis.services.ows.Service;

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
/**
 *
 * @author haonguyen
 */
@XmlType(name = "GetCapabilitiesType", namespace = Namespaces.CSW)
@XmlRootElement(name = "GetCapabilities", namespace = Namespaces.CSW)
/**
 * Request for a description of service capabilities. 
 * See OGC 06-121r9 for more information.
 */
public class GetCapabilities extends org.apache.sis.services.ows.GetCapabilities {
    /**
     * OGC service type identifier (CSW).
     */
    private Service service;

    /**
     * Return OGC service type identifier (CSW).
     * @return OGC service type identifier (CSW).
     */
    @XmlAttribute
    public Service getService() {
        return service;
    }

    /**
     * Set OGC service type identifier (CSW).
     * @param service
     */
    public void setService(Service service) {
        this.service = service;
    }
}
