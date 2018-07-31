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

/**
 *
 * @author haonguyen
 */
@XmlType(name = "ServiceIdentificationType", namespace = Namespaces.OWS, propOrder = {
    "serviceType",
    "serviceTypeVersion",})
@XmlRootElement(name = "ServiceIdentification", namespace = Namespaces.OWS)
/**
 * General metadata for this specific server.
 * This XML Schema of this section shall be the same for all OWS.
 */
public class OwsServiceIdentification extends Description {
    /**
     * A service type name from a registry of services.
     * For example, the values of the codeSpace URI and name and code string may
     * be "OGC" and "catalogue." This type name is normally used for
     * machine-to-machine communication.
     */
    private String serviceType;
    /**
     * Unordered list of one or more versions of this service type implemented
     * by this server.
     * This information is not adequate for version negotiation, and shall not
     * be used for that purpose.
     */
    private Version serviceTypeVersion;

    /**
     * Return A service type name from a registry of services.
     * @return A service type name from a registry of services.
     */
    @XmlElement(name = "ServiceType", namespace = Namespaces.OWS)
    public String getServiceType() {
        return serviceType;
    }

    /**
     * Set A service type name from a registry of services.
     * @param serviceType
     */
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    /**
     * Return Unordered list of one or more versions of this service type implemented
     * by this server.
     * @return Unordered list of one or more versions of this service type implemented
     * by this server.
     */
    @XmlElement(name = "ServiceTypeVersion", namespace = Namespaces.OWS)
    public Version getServiceTypeVersion() {
        return serviceTypeVersion;
    }

    /**
     * Set Unordered list of one or more versions of this service type implemented
     * by this server.
     * @param serviceTypeVersion
     */
    public void setServiceTypeVersion(Version serviceTypeVersion) {
        this.serviceTypeVersion = serviceTypeVersion;
    }

}
