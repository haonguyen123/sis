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
@XmlType(name = "DCP", namespace = Namespaces.OWS, propOrder = {
    "http"
})
@XmlRootElement(name = "DCP", namespace = Namespaces.OWS)
/**
 * Information for one distributed Computing Platform (DCP) supported for this
 * operation.
 * At present, only the HTTP DCP is defined, so this element only includes the HTTP element.
 */
public class DCP {
    /**
     * Connect point URLs for the HTTP Distributed Computing Platform (DCP).
     * Normally, only one Get and/or one Post is included in this element.
     * More than one Get and/or Post is allowed to support including alternative
     * URLs for uses such as load balancing or backup.
     */
    private HTTP http;

    /**
     * Return Connect point URLs for the HTTP Distributed Computing Platform (DCP).
     * @return Connect point URLs for the HTTP Distributed Computing Platform (DCP).
     */
    @XmlElement(name = "HTTP", namespace = Namespaces.OWS)
    public HTTP getHttp() {
        return http;
    }

    /**
     * Set Connect point URLs for the HTTP Distributed Computing Platform (DCP).
     * @param http
     */
    public void setHttp(HTTP http) {
        this.http = http;
    }

}
