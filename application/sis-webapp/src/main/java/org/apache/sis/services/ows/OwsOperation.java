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
@XmlType(name="OperationType", namespace=Namespaces.OWS, propOrder = {
    "dcp",
    "parameter",
    "constraint"
})
@XmlRootElement(name="Operation",namespace=Namespaces.OWS)
public class OwsOperation {
    private DCP dcp;
    private List<OwsDomain> parameter;
    private List<OwsDomain> constraint;
    private String name;

    /**
     *
     * @return
     */
    @XmlElement(name="DCP",namespace = Namespaces.OWS)
    public DCP getDcp() {
        return dcp;
    }

    /**
     *
     * @param dcp
     */
    public void setDcp(DCP dcp) {
        this.dcp = dcp;
    }
    
    /**
     *
     * @return
     */
    @XmlElement(name="Parameter",namespace = Namespaces.OWS)   
    public List<OwsDomain> getParameter() {
        return parameter;
    }

    /**
     *
     * @param parameter
     */
    public void setParameter(List<OwsDomain> parameter) {
        this.parameter = parameter;
    }

    /**
     *
     * @return
     */
    @XmlElement(name="Constraint",namespace = Namespaces.OWS)    
    public List<OwsDomain> getConstraint() {
        return constraint;
    }

    /**
     *
     * @param constraint
     */
    public void setConstraint(List<OwsDomain> constraint) {
        this.constraint = constraint;
    }
    
    /**
     *
     * @return
     */
    @XmlAttribute
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    
}
