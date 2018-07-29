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
@XmlType(name = "DescriptionType", namespace = Namespaces.OWS, propOrder = {
    "title",
    "abstracts",
    "keywords"
})
@XmlRootElement(name = "Description", namespace = Namespaces.OWS)
public class Description {
    /**
     * Descriptive title for the object.
     */
    private String title;
    /**
     * Descriptive abstracts for the object.
     */
    private String abstracts;
    /**
     * Descriptive keyword for the object.
     */
    private List<OwsKeywords> keywords;

    /**
     * Return title for the object.
     * @return title for the object
     */
    @XmlElement(name = "Title", namespace = Namespaces.OWS)
    public String getTitle() {
        return title;
    }

    /**
     * Set title for the object.
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Return abstracts for the object.
     * @return abstracts for the object
     */
    @XmlElement(name = "Abstract", namespace = Namespaces.OWS)
    public String getAbstracts() {
        return abstracts;
    }

    /**
     * Set abstracts for the object
     * @param abstracts
     */
    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    /**
     * Return  keywords for the object.
     * @return keywords for the object.
     */
    @XmlElement(name = "Keywords", namespace = Namespaces.OWS)
    public List<OwsKeywords> getKeywords() {
        return keywords;
    }

    /**
     * Set keywords for the object.
     * @param keywords
     */
    public void setKeywords(List<OwsKeywords> keywords) {
        this.keywords = keywords;
    }

}
