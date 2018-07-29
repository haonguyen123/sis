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
@XmlType(name = "ResponsiblePartySubsetType", namespace = Namespaces.OWS, propOrder = {
    "individualName",
    "positionName",
    "contactInfo",
    "role"
})
    /**
     * Identification of, and means of communication with, person responsible
     * for the server.
     */
public class ResponsiblePartySubset {
    /**
     * Name of the responsible person: surname, given name, title separated by a delimiter.
     */
    private String individualName;
    /**
     * Name of the responsible organization.
     */
    private String positionName;
    /**
     * Role or position of the responsible person.
     */
    private OwsContact contactInfo;
    /**
     * Function performed by the responsible party.
     * Possible values of this Role shall include the values and the meanings
     * listed in Subclause B.5.5 of ISO 19115:2003.
     */
    private String role;

    /**
     * Return Name of the responsible person: surname, given name, title separated by a delimiter.
     * @return Name of the responsible person: surname, given name, title separated by a delimiter.
     */
    @XmlElement(name = "IndividualName", namespace = Namespaces.OWS, required = true)
    public String getIndividualName() {
        return individualName;
    }

    /**
     * Set Name of the responsible person: surname, given name, title separated by a delimiter.
     * @param individualName
     */
    public void setIndividualName(String individualName) {
        this.individualName = individualName;
    }

    /**
     * Return Name of the responsible organization.
     * @return Name of the responsible organization.
     */
    @XmlElement(name = "PositionName", namespace = Namespaces.OWS)
    public String getPositionName() {
        return positionName;
    }

    /**
     * Set Name of the responsible organization.
     * @param positionName
     */
    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    /**
     * Return Role or position of the responsible person.
     * @return Role or position of the responsible person.
     */
    @XmlElement(name = "ContactInfo", namespace = Namespaces.OWS)
    public OwsContact getContactInfo() {
        return contactInfo;
    }

    /**
     * Set Role or position of the responsible person.
     * @param contactInfo
     */
    public void setContactInfo(OwsContact contactInfo) {
        this.contactInfo = contactInfo;
    }

    /**
     * Return Function performed by the responsible party.
     * @return Function performed by the responsible party.
     */
    @XmlElement(name = "Role", namespace = Namespaces.OWS)
    public String getRole() {
        return role;
    }

    /**
     * Set Function performed by the responsible party.
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }

}
