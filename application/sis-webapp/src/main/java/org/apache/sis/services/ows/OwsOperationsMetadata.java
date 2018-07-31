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
@XmlType(name = "OperationsMetadataType", namespace = Namespaces.OWS, propOrder = {
    "operation",
    "parameter",
    "constraint"
})
@XmlRootElement(name = "OperationsMetadata", namespace = Namespaces.OWS)
public class OwsOperationsMetadata {
    /**
     * Metadata for unordered list of all the (requests for) operations that
     * this server interface implements.
     * The list of required and optional operations implemented shall be specified
     * in the Implementation Specification for this service.
     */
    private List<OwsOperation> operation;
    /**
     * Optional unordered list of parameter valid domains that each apply to one
     * or more operations which this server interface implements.
     * The list of required and optional parameter domain limitations shall be
     * specified in the Implementation Specification for this service.
     */
    private List<OwsDomain> parameter;
    /**
     * Optional unordered list of valid domain constraints on non-parameter
     * quantities that each apply to this server.
     * The list of required and optional constraints shall be specified in the
     * Implementation Specification for this service.
     */
    private List<OwsDomain> constraint;

    /**
     * Return metadata for unordered list of all the (requests for) operations.
     * @return metadata for unordered list of all the (requests for) operations.
     */
    @XmlElement(name = "Operation", namespace = Namespaces.OWS)

    public List<OwsOperation> getOperation() {
        return operation;
    }

    /**
     * Set metadata for unordered list of all the (requests for) operations.
     * @param operation
     */
    public void setOperation(List<OwsOperation> operation) {
        this.operation = operation;
    }

    /**
     * Return optional unordered list of parameter valid domains.
     * @return optional unordered list of parameter valid domains.
     */
    @XmlElement(name = "Parameter", namespace = Namespaces.OWS)

    public List<OwsDomain> getParameter() {
        return parameter;
    }

    /**
     * Set optional unordered list of parameter valid domains.
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

}
