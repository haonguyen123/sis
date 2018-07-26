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
@XmlType(name = "ServiceProviderType", namespace = Namespaces.OWS, propOrder = {
    "providerName",
    "providerSite",
    "serviceContact"
})
@XmlRootElement(name = "ServiceProvider", namespace = Namespaces.OWS)
/**
 * Metadata about the organization that provides this specific service instance 
 * or server.
 */
public class OwsServiceProvider {
    /**
     * A unique identifier for the service provider organization.
     */
    private String providerName;
    /**
     * Reference to the most relevant web site of the service provider.
     */
    private OnlineResource providerSite;
    /**
     * Information for contacting the service provider. 
     * The OnlineResource element within this ServiceContact element should not 
     * be used to reference a web site of the service provider.
     */
    private ResponsiblePartySubset serviceContact;

    /**
     * Return A unique identifier for the service provider organization.
     * @return A unique identifier for the service provider organization.
     */
    @XmlElement(name = "ProviderName", namespace = Namespaces.OWS)
    public String getProviderName() {
        return providerName;
    }

    /**
     * Set A unique identifier for the service provider organization.
     * @param providerName
     */
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    /**
     * Return Reference to the most relevant web site of the service provider.
     * @return Reference to the most relevant web site of the service provider.
     */
    @XmlElement(name = "ProviderSite", namespace = Namespaces.OWS)
    public OnlineResource getProviderSite() {
        return providerSite;
    }

    /**
     * Set Reference to the most relevant web site of the service provider.
     * @param providerSite
     */
    public void setProviderSite(OnlineResource providerSite) {
        this.providerSite = providerSite;
    }

    /**
     * Return Information for contacting the service provider. 
     * @return Information for contacting the service provider. 
     */
    @XmlElement(name = "ServiceContact", namespace = Namespaces.OWS)
    public ResponsiblePartySubset getServiceContact() {
        return serviceContact;
    }

    /**
     * Set Information for contacting the service provider. 
     * @param serviceContact
     */
    public void setServiceContact(ResponsiblePartySubset serviceContact) {
        this.serviceContact = serviceContact;
    }

}
