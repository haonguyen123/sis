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
@SuppressWarnings("CloneableClassWithoutClone")
@XmlType(name = "LanguageType", namespace = Namespaces.OWS, propOrder = {
    "language",})
@XmlRootElement(name = "Language", namespace = Namespaces.OWS)
public class Language {
    /** 
     * Identifier of a language used by the data(set) contents. This language 
     * identifier shall be as specified in IETF RFC 4646. The language tags shall 
     * be either complete 5 character codes (e.g. "en-CA"), or abbreviated 2 
     * character codes (e.g. "en"). In addition to the RFC 4646 codes, the server 
     * shall support the single special value "*" which is used to indicate "any 
     * language".
     */
    private String language;

    /**
     * Return a language used by the data(set) contents
     * @return a language used by the data(set) contents
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Set a language used by the data(set) contents
     * @param language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

}
