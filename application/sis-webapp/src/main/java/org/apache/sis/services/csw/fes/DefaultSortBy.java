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
package org.apache.sis.services.csw.fes;

import javax.xml.bind.annotation.*;
import org.opengis.filter.expression.PropertyName;
import org.opengis.filter.sort.SortBy;
import org.opengis.filter.sort.SortOrder;

/**
 *
 * @author haonguyen
 */
@XmlType(name="DefaultSortByType", namespace =Namespaces.FES,propOrder = {
    "propertyName",
    "sortOrder",})
@XmlRootElement(name="DefaultSortBy", namespace =Namespaces.FES)
public class DefaultSortBy implements SortBy {
    private PropertyName propertyName;
    private SortOrder sortOrder;
    @XmlElement(name="PropertyName", namespace =Namespaces.FES,type = DefaultPropertyName.class)
    @Override
    public PropertyName getPropertyName() {
        return propertyName;
    }
    public void setPropertyName(PropertyName propertyName) {
        this.propertyName = propertyName;
    }
    @XmlElement(name="SortOrder", namespace =Namespaces.FES)
    @Override
    public SortOrder getSortOrder() {
        return sortOrder;
    }
    public void setSortOrder(SortOrder sortOrder) {
        this.sortOrder = sortOrder;
    }
}
