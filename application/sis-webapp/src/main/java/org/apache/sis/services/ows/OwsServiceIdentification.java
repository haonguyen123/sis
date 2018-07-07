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
package org.apache.sis.services.ows;

import javax.xml.bind.annotation.*;
import org.apache.sis.metadata.iso.identification.DefaultServiceIdentification;


/**
 *
 * @author haonguyen
 */
@XmlType(name="ServiceIdentificationType", namespace=Namespaces.OWS, propOrder = {
    "serviceType",
    "serviceTypeVersion",
})
@XmlRootElement(name="ServiceIdentification",namespace=Namespaces.OWS)
public class OwsServiceIdentification extends Description{
    private String serviceType;
    private Version serviceTypeVersion;

    /**
     *
     * @return
     */
    @XmlElement(name="ServiceType",namespace = Namespaces.OWS)
    public String getServiceType() {
        return serviceType;
    }

    /**
     *
     * @param serviceType
     */
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    /**
     *
     * @return
     */
    @XmlElement(name="ServiceTypeVersion",namespace = Namespaces.OWS)
    public Version getServiceTypeVersion() {
        return serviceTypeVersion;
    }

    /**
     *
     * @param serviceTypeVersion
     */
    public void setServiceTypeVersion(Version serviceTypeVersion) {
        this.serviceTypeVersion = serviceTypeVersion;
    }
    
    
}
