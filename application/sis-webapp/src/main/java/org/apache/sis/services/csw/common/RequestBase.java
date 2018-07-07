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
package org.apache.sis.services.csw.common;

import org.apache.sis.services.ows.Service;
import org.apache.sis.services.ows.Version;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author haonguyen
 */
@XmlType(name = "RequestBaseType", namespace = Namespaces.OWS)
@XmlRootElement(name = "RequestBase", namespace = Namespaces.OWS)
public abstract class RequestBase {
    private Service service;
    private Version version;

    /**
     *
     * @return
     */
    @XmlAttribute
    public Service getService() {
        return service;
    }

    /**
     *
     * @param service
     */
    public void setService(Service service) {
        this.service = service;
    }

    /**
     *
     * @return
     */
    @XmlAttribute
    public Version getVersion() {
        return version;
    }

    /**
     *
     * @param version
     */
    public void setVersion(Version version) {
        this.version = version;
    }  
}
