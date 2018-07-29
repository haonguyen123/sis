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
@XmlType(name = "QueryType", namespace = Namespaces.CSW, propOrder = {
    "elementName",
    "constraint",
    "sortBy"
})
@XmlRootElement(name = "Query", namespace = Namespaces.CSW)
public class Query extends AbstractQuery {
    /**
     * Named subsets of catalogue object properties;
     * these views are mapped to a specific information model and are defined in
     * an application profile.
     */
    private Object elementName;
    /**
     * A search constraint that adheres to one of the following syntaxes:
     * Filter - OGC filter expression
     * CqlText - OGC CQL predicate
     */
    private Constraint constraint;
    /**
     * The result set may be sorted by specifying one or more metadata record
     * elements upon which to sort.
     */
    private SortBy sortBy;
    /**
     * The exact syntax is defined in an application profile.
     * If querying against the common record properties, only a single type may
     * be specified (Record).
     */
    private TypeNameList typeNameList;

    /**
     * Return Named subsets of catalogue object properties.
     * @return Named subsets of catalogue object properties.
     */
    @XmlElements(value = {
        @XmlElement(name = "ElementSetName", type = ElementSetName.class),
        @XmlElement(name = "ElementName", type = String.class),})
    public Object getElementName() {
        return elementName;
    }

    /**
     * Set Named subsets of catalogue object properties.
     * @param elementName
     */
    public void setElementName(Object elementName) {
        this.elementName = elementName;
    }

    /**
     * Return A search constraint that adheres to one of the following syntaxes.
     * @return A search constraint that adheres to one of the following syntaxes.
     */
    @XmlElement(name = "Constraint", namespace = Namespaces.CSW)
    public Constraint getConstraint() {
        return constraint;
    }

    /**
     * Set A search constraint that adheres to one of the following syntaxes.
     * @param constraint
     */
    public void setConstraint(Constraint constraint) {
        this.constraint = constraint;
    }

    /**
     * Return The result set may be sorted by specifying one or more metadata record
     * elements upon which to sort.
     * @return result set may be sorted by specifying one or more metadata record
     * elements upon which to sort.
     */
    @XmlElement(name = "SortBy", namespace = Namespaces.FES, type = DefaultSortBy.class)
    public SortBy getSortBy() {
        return sortBy;
    }

    /**
     * Set the result set may be sorted by specifying one or more metadata record
     * elements upon which to sort.
     * @param sortBy
     */
    public void setSortBy(SortBy sortBy) {
        this.sortBy = sortBy;
    }

    /**
     * Reuturn The exact syntax is defined in an application profile.
     * @return The exact syntax is defined in an application profile.
     */
    @XmlAttribute
    public TypeNameList getTypeNameList() {
        return typeNameList;
    }

    /**
     * Set The exact syntax is defined in an application profile.
     * @param typeNameList
     */
    public void setTypeNameList(TypeNameList typeNameList) {
        this.typeNameList = typeNameList;
    }

}
