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
@XmlType(name = "OperationType", namespace = Namespaces.OWS, propOrder = {
    "dcp",
    "parameter",
    "constraint"
})
@XmlRootElement(name = "Operation", namespace = Namespaces.OWS)
public class OwsOperation {
    /**
     * Unordered list of Distributed Computing Platforms (DCPs) supported for
     * this operation. At present, only the HTTP DCP is defined, so this element
     * will appear only once.
     */
    private DCP dcp;
    /**
     * Optional unordered list of parameter domains that each apply to this
     * operation which this server implements.
     * If one of these Parameter elements has the same "name" attribute as a
     * Parameter element in the OperationsMetadata element, this Parameter element
     * shall override the other one for this operation. The list of required and
     * optional parameter domain limitations for this operation shall be specified
     * in the Implementation Specification for this service.
     */
    private List<OwsDomain> parameter;
    /**
     * Optional unordered list of valid domain constraints on non-parameter
     * quantities that each apply to this operation.
     * If one of these Constraint elements has the same "name" attribute as a
     * Constraint element in the OperationsMetadata element, this Constraint
     * element shall override the other one for this operation. The list of
     * required and optional constraints for this operation shall be specified
     * in the Implementation Specification for this service.
     */
    private List<OwsDomain> constraint;
    /**
     * Name or identifier of this operation (request) (for example, GetCapabilities).
     * The list of required and optional operations implemented shall be specified
     * in the Implementation Specification for this service.

     */
    private String name;

    /**
     * Return unordered list of Distributed Computing Platforms (DCPs) supported for
     * this operation.
     * @return unordered list of Distributed Computing Platforms (DCPs) supported for
     * this operation.
     */
    @XmlElement(name = "DCP", namespace = Namespaces.OWS)
    public DCP getDcp() {
        return dcp;
    }

    /**
     * get unordered list of Distributed Computing Platforms (DCPs) supported for
     * this operation.
     * @param dcp
     */
    public void setDcp(DCP dcp) {
        this.dcp = dcp;
    }

    /**
     * Return Optional unordered list of parameter domains that each apply to this
     * operation.
     * @return Return Optional unordered list of parameter domains that each apply to this
     * operation.
     */
    @XmlElement(name = "Parameter", namespace = Namespaces.OWS)
    public List<OwsDomain> getParameter() {
        return parameter;
    }

    /**
     * Set optional unordered list of parameter domains that each apply to this
     * operation.
     * @param parameter
     */
    public void setParameter(List<OwsDomain> parameter) {
        this.parameter = parameter;
    }

    /**
     * Return optional unordered list of valid domain constraints on non-parameter
     * quantities.
     * @return optional unordered list of valid domain constraints on non-parameter
     * quantities.
     */
    @XmlElement(name = "Constraint", namespace = Namespaces.OWS)
    public List<OwsDomain> getConstraint() {
        return constraint;
    }

    /**
     * Set optional unordered list of valid domain constraints on non-parameter
     * quantities.
     * @param constraint
     */
    public void setConstraint(List<OwsDomain> constraint) {
        this.constraint = constraint;
    }

    /**
     * Return name or identifier of this operation (request)
     * @return name or identifier of this operation (request)
     */
    @XmlAttribute
    public String getName() {
        return name;
    }

    /**
     * Set name or identifier of this operation (request)
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

}
