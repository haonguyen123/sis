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
@XmlType(name = "ContactType", namespace = Namespaces.OWS, propOrder = {
    "address",
    "phone",
    "onlineResource"
})
@XmlRootElement(name = "ContactInfo", namespace = Namespaces.OWS)
public class OwsContact {
    /**
     * Physical and email address at which the organization or individual may be contacted.
     */
    private Address address;
    /**
     * Telephone numbers at which the organization or individual may be contacted.
     */
    private Telephone phone;
    /**
     * On-line information that can be used to contact the individual or organization. 
     * OWS specifics: The xlink:href attribute in the xlink:simpleAttrs attribute 
     * group shall be used to reference this resource. Whenever practical, 
     * the xlink:href attribute with type anyURI should be a URL from which more 
     * contact information can be electronically retrieved. 
     * The xlink:title attribute with type "string" can be used to name this set 
     * of information. The other attributes in the xlink:simpleAttrs attribute 
     * group should not be used.
     */
    private OnlineResource onlineResource;

    /**
     * Return Physical and email address at which the organization or individual may be contacted.
     * @return Physical and email address at which the organization or individual may be contacted.
     */
    @XmlElement(name = "Address", namespace = Namespaces.OWS)
    public Address getAddress() {
        return address;
    }

    /**
     * Set Physical and email address at which the organization or individual may be contacted.
     * @param address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Return Telephone numbers at which the organization or individual may be contacted.
     * @return Telephone numbers at which the organization or individual may be contacted.
     */
    @XmlElement(name = "Phone", namespace = Namespaces.OWS)
    public Telephone getPhone() {
        return phone;
    }

    /**
     * Set Telephone numbers at which the organization or individual may be contacted.
     * @param phone
     */
    public void setPhone(Telephone phone) {
        this.phone = phone;
    }

    /**
     * Return On-line information that can be used to contact the individual or organization. 
     * @return On-line information that can be used to contact the individual or organization. 
     */
    @XmlElement(name = "OnlineResource", namespace = Namespaces.OWS)
    public OnlineResource getOnlineResource() {
        return onlineResource;
    }

    /**
     * Set On-line information that can be used to contact the individual or organization. 
     * @param onlineResource
     */
    public void setOnlineResource(OnlineResource onlineResource) {
        this.onlineResource = onlineResource;
    }

}
