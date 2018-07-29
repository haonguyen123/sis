package org.apache.sis.services.csw.ogcservice;

import javax.xml.bind.annotation.*;
import org.apache.sis.services.ows.CapabilitiesBase;

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
/**
 *
 * @author haonguyen
 */
@XmlType(name = "CapabilitiesType", namespace = Namespaces.CSW)
@XmlRootElement(name = "Capabilities", namespace = Namespaces.CSW)
/**
 * This type extends ows:CapabilitiesBaseType defined in OGC 06-121r9 to include
 * information about supported OGC filter components.
 * A profile may extend this type to describe additional capabilities.
 */
public class Capabilities extends CapabilitiesBase {
//    private FilterCapabilities filterCapabilities;
//     /**
//     *
//     * @return
//     */
//    @XmlElement(name="Filter_Capabilities")
//
//    public FilterCapabilities getFilterCapabilities() {
//        return filterCapabilities;
//    }
//
//    /**
//     *
//     * @param filterCapabilities
//     */
//    public void setFilterCapabilities(FilterCapabilities filterCapabilities) {
//        this.filterCapabilities = filterCapabilities;
//    }
}
