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
import org.apache.sis.services.csw.common.Namespaces;

/**
 *
 * @author haonguyen
 */
@XmlType(name = "CapabilitiesBaseType", namespace = Namespaces.OWS, propOrder = {
    "serviceIdentification",
    "serviceProvider",
    "operationsMetadata"
})
@XmlRootElement(name = "CapabilitiesBase", namespace = Namespaces.OWS)
public class CapabilitiesBase {

    private OwsServiceIdentification serviceIdentification;
    private OwsServiceProvider serviceProvider;
    private OwsOperationsMetadata operationsMetadata;
//    private List<Language> languages;
//    private List<Metadata> content;

    /**
     *
     * @return
     */
    @XmlElement(name = "ServiceIdentification", namespace = Namespaces.OWS)

    public OwsServiceIdentification getServiceIdentification() {
        return serviceIdentification;
    }

    /**
     *
     * @param serviceIdentification
     */
    public void setServiceIdentification(OwsServiceIdentification serviceIdentification) {
        this.serviceIdentification = serviceIdentification;
    }

    /**
     *
     * @return
     */
    @XmlElement(name = "ServiceProvider", namespace = Namespaces.OWS)

    public OwsServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    /**
     *
     * @param serviceProvider
     */
    public void setServiceProvider(OwsServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    /**
     *
     * @return
     */
    @XmlElement(name = "OperationsMetadata", namespace = Namespaces.OWS)

    public OwsOperationsMetadata getOperationsMetadata() {
        return operationsMetadata;
    }

    /**
     *
     * @param operationsMetadata
     */
    public void setOperationsMetadata(OwsOperationsMetadata operationsMetadata) {
        this.operationsMetadata = operationsMetadata;
    }

//
//    /**
//     *
//     * @return
//     */
//    @XmlElement(name="Languages")
//    public List<Language> getLanguages() {
//        return languages;
//    }
//
//    /**
//     *
//     * @param languages
//     */
//    public void setLanguages(List<Language> languages) {
//        this.languages = languages;
//    }
    /**
     *
     * @return
     */
//    @XmlElement(name="Content")
//    public List<Metadata> getContent() {
//        return content;
//    }
//
//    /**
//     *
//     * @param content
//     */
//    public void setContent(List<Metadata> content) {
//        this.content = content;
//    }
}
