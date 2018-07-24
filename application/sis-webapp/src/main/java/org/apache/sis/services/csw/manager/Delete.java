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
package org.apache.sis.services.csw.manager;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;

/**
 *
 * @author haonguyen
 */
@XmlType(name = "UpdateType", namespace = Namespaces.CSW)
@XmlRootElement(name = "Update", namespace = Namespaces.CSW)
class Delete {

    private Constraint constraint;
    private QName typName;
    private String id;

    @XmlElement(name = "Constraint", namespace = Namespaces.CSW)
    public Constraint getConstraint() {
        return constraint;
    }

    public void setConstraint(Constraint constraint) {
        this.constraint = constraint;
    }

    @XmlAttribute
    public QName getTypName() {
        return typName;
    }

    public void setTypName(QName typName) {
        this.typName = typName;
    }

    @XmlAttribute
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}