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

    private String voice;
    private String facsimile;

    /**
     *
     * @return
     */
    @XmlElement(name = "Voice", namespace = Namespaces.OWS)
    public String getVoice() {
        return voice;
    }

    /**
     *
     * @param voice
     */
    public void setVoice(String voice) {
        this.voice = voice;
    }

    /**
     *
     * @return
     */
    @XmlElement(name = "Facsimile", namespace = Namespaces.OWS)
    public String getFacsimile() {
        return facsimile;
    }

    /**
     *
     * @param facsimile
     */
    public void setFacsimile(String facsimile) {
        this.facsimile = facsimile;
    }

}