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
@XmlType(name="AddressType", namespace=Namespaces.OWS, propOrder = {
    "deliveryPoint",
    "city",
    "administrativeArea",
    "postalCode",
    "country",
    "electronicMailAddress",
})
@XmlRootElement(name="Address",namespace=Namespaces.OWS)
public class Address {
    private String deliveryPoint;
    private String city;
    private String administrativeArea;
    private String postalCode;
    private String country;
    private String electronicMailAddress;
    @XmlElement(name="DeliveryPoint",namespace = Namespaces.OWS)
    public String getDeliveryPoint() {
        return deliveryPoint;
    }

    public void setDeliveryPoint(String deliveryPoint) {
        this.deliveryPoint = deliveryPoint;
    }
    @XmlElement(name="City",namespace = Namespaces.OWS)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @XmlElement(name="AdministrativeArea",namespace = Namespaces.OWS)

    public String getAdministrativeArea() {
        return administrativeArea;
    }

    public void setAdministrativeArea(String administrativeArea) {
        this.administrativeArea = administrativeArea;
    }
    @XmlElement(name="PostalCode",namespace = Namespaces.OWS)
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    
    @XmlElement(name="Country",namespace = Namespaces.OWS)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    @XmlElement(name="ElectronicMailAddress",namespace = Namespaces.OWS)
    public String getElectronicMailAddress() {
        return electronicMailAddress;
    }

    public void setElectronicMailAddress(String electronicMailAddress) {
        this.electronicMailAddress = electronicMailAddress;
    }
    
}
