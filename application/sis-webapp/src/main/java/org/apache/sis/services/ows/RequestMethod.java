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
@XmlType(name = "RequestMethodType", namespace = Namespaces.OWS, propOrder = {
    "contraint"
})
@XmlRootElement(name = "RequestMethod", namespace = Namespaces.OWS)
/**
 * Connect point URL and any constraints for this HTTP request method for this
 * operation request.
 * In the OnlineResourceType, the xlink:href attribute in the xlink:simpleAttrs
 * attribute group shall be used to contain this URL. The other attributes in
 * the xlink:simpleAttrs attribute group should not be used.
 */
public class RequestMethod extends OnlineResource {
    /**
     * Optional unordered list of valid domain constraints on non-parameter
     * quantities that each apply to this request method for this operation.
     * If one of these Constraint elements has the same "name" attribute as a
     * Constraint element in the OperationsMetadata or Operation element, this
     * Constraint element shall override the other one for this operation. The
     * list of required and optional constraints for this request method for
     * this operation shall be specified in the Implementation Specification for
     * this service.
     */
    private OwsDomain contraint;

    /**
     * Return Optional unordered list of valid domain constraints on non-parameter
     * quantities.
     * @return Optional unordered list of valid domain constraints on non-parameter
     * quantities.
     */
    @XmlElement(name = "Contraint", namespace = Namespaces.OWS)
    public OwsDomain getContraint() {
        return contraint;
    }

    /**
     * Set Optional unordered list of valid domain constraints on non-parameter
     * quantities.
     * @param contraint
     */
    public void setContraint(OwsDomain contraint) {
        this.contraint = contraint;
    }

}
