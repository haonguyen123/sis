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
@XmlType(name="ServiceProviderType", namespace=Namespaces.OWS, propOrder = {
    "providerName",
    "providerSite",
    "serviceContact"
})
@XmlRootElement(name="ServiceProvider",namespace=Namespaces.OWS)
public class OwsServiceProvider {
    private String  providerName;
    private OnlineResource providerSite;
    private ResponsiblePartySubset serviceContact;
    @XmlElement(name="ProviderName",namespace = Namespaces.OWS)
    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
    @XmlElement(name="ProviderSite",namespace = Namespaces.OWS)
    public OnlineResource getProviderSite() {
        return providerSite;
    }

    public void setProviderSite(OnlineResource providerSite) {
        this.providerSite = providerSite;
    }
    @XmlElement(name="ServiceContact",namespace = Namespaces.OWS)
    public ResponsiblePartySubset getServiceContact() {
        return serviceContact;
    }

    public void setServiceContact(ResponsiblePartySubset serviceContact) {
        this.serviceContact = serviceContact;
    }
    
}
