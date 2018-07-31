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
@XmlType(name = "SectionsType", namespace = Namespaces.OWS)
@XmlRootElement(name = "Sections", namespace = Namespaces.OWS)
public class Sections {
    /**
     * Unordered list of zero or more names of requested sections in complete
     * service metadata document.
     * Each Section value shall contain an allowed section name as specified by
     * each OWS specification. See Sections parameter subclause for more information.
     */
    private List<Section> section;

    /**
     * Return Unordered list of zero or more names of requested sections in complete
     * service metadata document.
     * @return Unordered list of zero or more names of requested sections in complete
     * service metadata document.
     */
    @XmlElement(name = "Section", namespace = Namespaces.OWS)
    public List<Section> getSection() {
        return section;
    }

    /**
     * Set Unordered list of zero or more names of requested sections in complete
     * service metadata document.
     * @param section
     */
    public void setSection(List<Section> section) {
        this.section = section;
    }

}
