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
@XmlType(name = "AddressType", namespace = Namespaces.OWS, propOrder = {
    "deliveryPoint",
    "city",
    "administrativeArea",
    "postalCode",
    "country",
    "electronicMailAddress",})
@XmlRootElement(name = "Address", namespace = Namespaces.OWS)
public class Address {
    /**
     * Address line for the location.
     */
    private String deliveryPoint;
    /**
     * City of the location.
     */
    private String city;
    /**
     * State or province of the location.
     */
    private String administrativeArea;
    /**
     * ZIP or other postal code.
     */
    private String postalCode;
    /**
     * Country of the physical address.
     */
    private String country;
    /**
     * Address of the electronic mailbox of the responsible organization or
     * individual.
     */
    private String electronicMailAddress;

    /**
     * Return Address line for the location.
     * @return Address line for the location.
     */
    @XmlElement(name = "DeliveryPoint", namespace = Namespaces.OWS)
    public String getDeliveryPoint() {
        return deliveryPoint;
    }

    /**
     * Set Address line for the location.
     * @param deliveryPoint
     */
    public void setDeliveryPoint(String deliveryPoint) {
        this.deliveryPoint = deliveryPoint;
    }

    /**
     * Return City of the location.
     * @return City of the location.
     */
    @XmlElement(name = "City", namespace = Namespaces.OWS)
    public String getCity() {
        return city;
    }

    /**
     * Set City of the location.
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Return State or province of the location.
     * @return State or province of the location.
     */
    @XmlElement(name = "AdministrativeArea", namespace = Namespaces.OWS)

    public String getAdministrativeArea() {
        return administrativeArea;
    }

    /**
     * set State or province of the location.
     * @param administrativeArea
     */
    public void setAdministrativeArea(String administrativeArea) {
        this.administrativeArea = administrativeArea;
    }

    /**
     * Return ZIP or other postal code.
     * @return ZIP or other postal code.
     */
    @XmlElement(name = "PostalCode", namespace = Namespaces.OWS)
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Set ZIP or other postal code.
     * @param postalCode
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Return Country of the physical address.
     * @return Country of the physical address.
     */
    @XmlElement(name = "Country", namespace = Namespaces.OWS)
    public String getCountry() {
        return country;
    }

    /**
     * Set Country of the physical address.
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Address of the electronic mailbox of the responsible organization or
     * individual.
     * @return Address of the electronic mailbox of the responsible organization or
     * individual.
     */
    @XmlElement(name = "ElectronicMailAddress", namespace = Namespaces.OWS)
    public String getElectronicMailAddress() {
        return electronicMailAddress;
    }

    /**
     * Set Address of the electronic mailbox of the responsible organization or
     * individual.
     * @param electronicMailAddress
     */
    public void setElectronicMailAddress(String electronicMailAddress) {
        this.electronicMailAddress = electronicMailAddress;
    }

}
