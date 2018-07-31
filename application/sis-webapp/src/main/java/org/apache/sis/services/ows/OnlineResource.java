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

import java.net.URI;
import javax.xml.bind.annotation.*;

/**
 *
 * @author haonguyen
 */
public class OnlineResource {
    /**
     * This type contains only a restricted and annotated set of the attributes
     * from the xlink:simpleAttrs attributeGroup.
     */
    private String type;
    /**
     * Reference to a remote resource or local payload.
     * A remote resource is typically addressed by a URL. For a local payload
     * (such as a multipart mime message), the xlink:href must start with the prefix cid:.
     */
    private URI href;

    /**
     * Return This type contains only a restricted and annotated set of the attributes
     * from the xlink:simpleAttrs attributeGroup.
     * @return
     */
    @XmlAttribute(name = "xlink:type")
    public String getType() {
        return type;
    }

    /**
     * Set This type contains only a restricted and annotated set of the attributes
     * from the xlink:simpleAttrs attributeGroup.
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Return  Reference to a remote resource or local payload.
     * @return Reference to a remote resource or local payload.
     */
    @XmlAttribute(name = "xlink:href")
    public URI getHref() {
        return href;
    }

    /**
     * Set Reference to a remote resource or local payload.
     * @param href
     */
    public void setHref(URI href) {
        this.href = href;
    }

}
