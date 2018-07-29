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
    /**
     * When omitted, server shall return latest supported version.
     */
    private AcceptVersions acceptVersions;
    /**
     * When omitted or not supported by server, server shall return complete 
     * service metadata (Capabilities) document.
     */
    private Sections sections;
    /**
     * When omitted or not supported by server, server shall return service 
     * metadata document using the MIME type "text/xml".
     */
    private AcceptFormats acceptFormats;
    /**
     * Ordered list of languages desired by the client for all human readable 
     * text in the response, in order of preference. 
     * For every element, the first matching language available from the server 
     * shall be present in the response.
     */
    private List<Language> AcceptLanguages;
    /**
     * When omitted or not supported by server, server shall return latest 
     * complete service metadata document.
     */
    private UpdateSequence updateSequence;

    /**
     * Return latest supported version.
     * @return latest supported version.
     */
    @XmlElement(name = "AcceptVersions")
    public AcceptVersions getAcceptVersions() {
        return acceptVersions;
    }

    /**
     * Set latest supported version.
     * @param acceptVersions
     */
    public void setAcceptVersions(AcceptVersions acceptVersions) {
        this.acceptVersions = acceptVersions;
    }

    /**
     * Return complete service metadata (Capabilities) document.
     * @return complete service metadata (Capabilities) document.
     */
    @XmlElement(name = "Sections")
    public Sections getSections() {
        return sections;
    }

    /**
     * Set complete service metadata (Capabilities) document.
     * @param sections
     */
    public void setSections(Sections sections) {
        this.sections = sections;
    }

    /**
     * Return service metadata document using the MIME type "text/xml".
     * @return  service metadata document using the MIME type "text/xml".
     */
    @XmlElement(name = "AcceptFormats")
    public AcceptFormats getAcceptFormats() {
        return acceptFormats;
    }

    /**
     * Set service metadata document using the MIME type "text/xml".
     * @param acceptFormats
     */
    public void setAcceptFormats(AcceptFormats acceptFormats) {
        this.acceptFormats = acceptFormats;
    }

    /**
     * Return Ordered list of languages desired by the client for all human readable 
     * text in the response, in order of preference.
     * @return Ordered list of languages desired by the client for all human readable 
     * text in the response, in order of preference.
     */
    @XmlElement(name = "AcceptLanguages")
    public List<Language> getAcceptLanguages() {
        return AcceptLanguages;
    }

    /**
     * Set Ordered list of languages desired by the client for all human readable 
     * text in the response, in order of preference.
     * @param AcceptLanguages
     */
    public void setAcceptLanguages(List<Language> AcceptLanguages) {
        this.AcceptLanguages = AcceptLanguages;
    }

    /**
     * Return latest complete service metadata document.
     * @return latest complete service metadata document.
     */
    @XmlElement(name = "UpdateSequence")
    public UpdateSequence getUpdateSequence() {
        return updateSequence;
    }

    /**
     * Set latest complete service metadata document.
     * @param updateSequence
     */
    public void setUpdateSequence(UpdateSequence updateSequence) {
        this.updateSequence = updateSequence;
    }

}
