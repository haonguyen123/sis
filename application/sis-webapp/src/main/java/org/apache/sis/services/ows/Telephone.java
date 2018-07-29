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
@XmlType(name = "TelephoneType", namespace = Namespaces.OWS, propOrder = {
    "voice",
    "facsimile",})
@XmlRootElement(name = "Telephone ", namespace = Namespaces.OWS)
public class Telephone {
    /**
     * Telephone number by which individuals can speak to the responsible
     * organization or individual.
     */
    private String voice;
    /**
     * Telephone number of a facsimile machine for the responsible organization
     * or individual.
     */
    private String facsimile;

    /**
     * Return Telephone number by which individuals can speak to the responsible
     * organization or individual.
     * @return Telephone number by which individuals can speak to the responsible
     * organization or individual.
     */
    @XmlElement(name = "Voice", namespace = Namespaces.OWS)
    public String getVoice() {
        return voice;
    }

    /**
     * Set Telephone number by which individuals can speak to the responsible
     * organization or individual.
     * @param voice
     */
    public void setVoice(String voice) {
        this.voice = voice;
    }

    /**
     * Return Telephone number of a facsimile machine for the responsible organization
     * or individual.
     * @return Telephone number of a facsimile machine for the responsible organization
     * or individual.
     */
    @XmlElement(name = "Facsimile", namespace = Namespaces.OWS)
    public String getFacsimile() {
        return facsimile;
    }

    /**
     * Set Telephone number of a facsimile machine for the responsible organization
     * or individual.
     * @param facsimile
     */
    public void setFacsimile(String facsimile) {
        this.facsimile = facsimile;
    }

}
