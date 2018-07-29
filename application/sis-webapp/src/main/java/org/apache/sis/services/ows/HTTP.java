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
@XmlType(name = "HTTP", namespace = Namespaces.OWS, propOrder = {
    "get",
    "post"
})
@XmlRootElement(name = "HTTP", namespace = Namespaces.OWS)
public class HTTP {
    /**
     * Connect point URL prefix and any constraints for the HTTP "Get" request 
     * method for this operation request.
     */
    private RequestMethod get;
    /**
     * Connect point URL and any constraints for the HTTP "Post" request method 
     * for this operation request.
     */
    private RequestMethod post;

    /**
     * Return Connect point URL prefix and any constraints for the HTTP "Get" request 
     * method
     * @return Connect point URL prefix and any constraints for the HTTP "Get" request 
     * method.
     */
    @XmlElement(name = "Get", namespace = Namespaces.OWS)
    public RequestMethod getGet() {
        return get;
    }

    /**
     * Set Connect point URL prefix and any constraints for the HTTP "Get" request 
     * method.
     * @param get
     */
    public void setGet(RequestMethod get) {
        this.get = get;
    }

    /**
     * Return Connect point URL and any constraints for the HTTP "Post" request 
     * method.
     * @return
     */
    @XmlElement(name = "Post", namespace = Namespaces.OWS)
    public RequestMethod getPost() {
        return post;
    }

    /**
     * Set Connect point URL and any constraints for the HTTP "Post" request 
     * method
     * @param post
     */
    public void setPost(RequestMethod post) {
        this.post = post;
    }

}
