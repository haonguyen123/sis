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
@XmlType(name="OperationsMetadataType", namespace=Namespaces.OWS, propOrder = {
    "operation",
    "parameter",
    "constraint"
})
@XmlRootElement(name="OperationsMetadata",namespace=Namespaces.OWS)
public class OwsOperationsMetadata {
    private List<OwsOperation> operation;
    private List<OwsDomain> parameter;
    private List<OwsDomain> constraint;
    @XmlElement(name="Operation",namespace = Namespaces.OWS)

    public List<OwsOperation> getOperation() {
        return operation;
    }

    public void setOperation(List<OwsOperation> operation) {
        this.operation = operation;
    }
    @XmlElement(name="Parameter",namespace = Namespaces.OWS)
    
    public List<OwsDomain> getParameter() {
        return parameter;
    }

    public void setParameter(List<OwsDomain> parameter) {
        this.parameter = parameter;
    }
    @XmlElement(name="Constraint",namespace = Namespaces.OWS)

    public List<OwsDomain> getConstraint() {
        return constraint;
    }

    public void setConstraint(List<OwsDomain> constraint) {
        this.constraint = constraint;
    }
    
    
    
}
