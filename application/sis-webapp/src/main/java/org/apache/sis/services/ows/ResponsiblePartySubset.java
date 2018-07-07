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
@XmlType(name="ResponsiblePartySubsetType", namespace=Namespaces.OWS, propOrder = {
    "individualName",
    "positionName",
    "contactInfo",
    "role"
})
public class ResponsiblePartySubset {
    private String individualName;
    private String positionName;
    private OwsContact contactInfo;
    private String role;

    /**
     *
     * @return
     */
    @XmlElement(name="IndividualName",namespace = Namespaces.OWS,required = true)
    public String getIndividualName() {
        return individualName;
    }

    /**
     *
     * @param individualName
     */
    public void setIndividualName(String individualName) {
        this.individualName = individualName;
    }

    /**
     *
     * @return
     */
    @XmlElement(name="PositionName",namespace = Namespaces.OWS)
    public String getPositionName() {
        return positionName;
    }

    /**
     *
     * @param positionName
     */
    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    /**
     *
     * @return
     */
    @XmlElement(name="ContactInfo",namespace = Namespaces.OWS)
    public OwsContact getContactInfo() {
        return contactInfo;
    }

    /**
     *
     * @param contactInfo
     */
    public void setContactInfo(OwsContact contactInfo) {
        this.contactInfo = contactInfo;
    }

    /**
     *
     * @return
     */
    @XmlElement(name="Role",namespace = Namespaces.OWS)
    public String getRole() {
        return role;
    }

    /**
     *
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }
    
}
