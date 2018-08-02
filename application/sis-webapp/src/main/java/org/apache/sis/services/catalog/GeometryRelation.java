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
package org.apache.sis.services.catalog;

/**
 *
 * @author haonguyen
 */
public final class GeometryRelation  {

    private GeometryRelation() {
    }

    public static final String EQUALS = "equals";
    public static final String  DISJOINT = "disjoint";
    public static final String  TOUCHES = "touches";
    public static final String  WITHIN = "within";
    public static final String  OVERLAPS = "overlaps";
    public static final String  CROSSES = "crosses";
    public static final String  INTERSECTS = "intersects";
    public static final String  CONTAINS = "contains";
    public static final String  DWITHIN ="dwithin";
    public static final String  BEYOND = "beyond";
}
