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

import java.util.List;
import javax.xml.bind.annotation.*;

/**
 *
 * @author haonguyen
 */
@XmlType(name = "GetCapabilitiesType", namespace = Namespaces.OWS)
@XmlRootElement(name = "GetCapabilities", namespace = Namespaces.OWS)
public class GetCapabilities {

    private AcceptVersions acceptVersions;
    private Sections sections;
    private AcceptFormats acceptFormats;
    private List<Language> AcceptLanguages;
    private UpdateSequence updateSequence;

    /**
     *
     * @return
     */
    @XmlElement(name = "AcceptVersions")
    public AcceptVersions getAcceptVersions() {
        return acceptVersions;
    }

    /**
     *
     * @param acceptVersions
     */
    public void setAcceptVersions(AcceptVersions acceptVersions) {
        this.acceptVersions = acceptVersions;
    }

    /**
     *
     * @return
     */
    @XmlElement(name = "Sections")
    public Sections getSections() {
        return sections;
    }

    /**
     *
     * @param sections
     */
    public void setSections(Sections sections) {
        this.sections = sections;
    }

    /**
     *
     * @return
     */
    @XmlElement(name = "AcceptFormats")
    public AcceptFormats getAcceptFormats() {
        return acceptFormats;
    }

    /**
     *
     * @param acceptFormats
     */
    public void setAcceptFormats(AcceptFormats acceptFormats) {
        this.acceptFormats = acceptFormats;
    }

    /**
     *
     * @return
     */
    @XmlElement(name = "AcceptLanguages")
    public List<Language> getAcceptLanguages() {
        return AcceptLanguages;
    }

    /**
     *
     * @param AcceptLanguages
     */
    public void setAcceptLanguages(List<Language> AcceptLanguages) {
        this.AcceptLanguages = AcceptLanguages;
    }

    /**
     *
     * @return
     */
    @XmlElement(name = "UpdateSequence")
    public UpdateSequence getUpdateSequence() {
        return updateSequence;
    }

    /**
     *
     * @param updateSequence
     */
    public void setUpdateSequence(UpdateSequence updateSequence) {
        this.updateSequence = updateSequence;
    }

}
