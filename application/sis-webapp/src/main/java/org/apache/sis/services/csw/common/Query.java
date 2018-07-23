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
package org.apache.sis.services.csw.common;

import javax.xml.bind.annotation.*;
import org.apache.sis.services.csw.fes.DefaultSortBy;
import org.opengis.filter.sort.SortBy;

/**
 *
 * @author haonguyen
 */
@XmlType(name="QueryType", namespace =Namespaces.CSW,propOrder = {    
    "elementName",
    "constraint",
    "sortBy"
})
@XmlRootElement(name="Query", namespace =Namespaces.CSW)
public class Query extends AbstractQuery{
    private Object elementName;
    private Constraint constraint;
    private SortBy sortBy;
    private TypeNameList typeNameList;

    /**
     *
     * @return
     */
    @XmlElements(value = { 
            @XmlElement(name="ElementSetName",type=ElementSetName.class),
            @XmlElement(name="ElementName",type=String.class),
    })
    public Object getElementName() {
        return elementName;
    }
    
    /**
     *
     * @param elementName
     */
    public void setElementName(Object elementName) {
        this.elementName = elementName;
    }

    /**
     *
     * @return
     */
    @XmlElement(name="Constraint",namespace=Namespaces.CSW)
    public Constraint getConstraint() {
        return constraint;
    }

    /**
     *
     * @param constraint
     */
    public void setConstraint(Constraint constraint) {
        this.constraint = constraint;
    }

    /**
     *
     * @return
     */
    @XmlElement(name="SortBy",namespace=Namespaces.FES,type = DefaultSortBy.class)
    public SortBy getSortBy() {
        return sortBy;
    }

    /**
     *
     * @param sortBy
     */
    public void setSortBy(SortBy sortBy) {
        this.sortBy = sortBy;
    }

    /**
     *
     * @return
     */
    @XmlAttribute
    public TypeNameList getTypeNameList() {
        return typeNameList;
    }

    /**
     *
     * @param typeNameList
     */
    public void setTypeNameList(TypeNameList typeNameList) {
        this.typeNameList = typeNameList;
    }
    
}
