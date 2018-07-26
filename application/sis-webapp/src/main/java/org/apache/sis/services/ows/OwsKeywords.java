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
@XmlType(name = "KeywordsType", namespace = Namespaces.OWS, propOrder = {
    "keyword",})
@XmlRootElement(name = "Keywords", namespace = Namespaces.OWS)
public class OwsKeywords {
    /**
     * Unordered list of one or more commonly used or formalised word(s) or 
     * phrase(s) used to describe the subject. 
     * When needed, the optional "type" can name the type of the associated list 
     * of keywords that shall all have the same type. Also when needed, 
     * the codeSpace attribute of that "type" can reference the type name authority 
     * and/or thesaurus. If the xml:lang attribute is not included in a Keyword element, 
     * then no language is specified for that element unless specified by another means. 
     * All Keyword elements in the same Keywords element that share the same xml:lang 
     * attribute value represent different keywords in that language.
     */
    private List<String> keyword;

    /**
     * Return Unordered list of one or more commonly used or formalised word(s) or 
     * phrase(s) used to describe the subject.
     * @return Unordered list of one or more commonly used or formalised word(s) or 
     * phrase(s) used to describe the subject.
     */
    @XmlElement(name = "Keyword", namespace = Namespaces.OWS)
    public List<String> getKeyword() {
        return keyword;
    }

    /**
     * Set Unordered list of one or more commonly used or formalised word(s) or 
     * phrase(s) used to describe the subject.
     * @param keyword
     */
    public void setKeyword(List<String> keyword) {
        this.keyword = keyword;
    }

}
