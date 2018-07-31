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
package org.apache.sis.services.csw.discovery;


/**
 *
 * @author haonguyen
 */
public class FilterFesKvp {
    private String q;
    private String recordIds;
    private String bbox;
    private String time;
    private String geometry;
    private String relation;
    

    /**
     *
     * @return
     */
    public String getQ() {
        return q;
    }

    /**
     *
     * @param q
     */
    public void setQ(String q) {
        this.q = q;
    }

    /**
     *
     * @return
     */
    public String getRecordIds() {
        return recordIds;
    }

    /**
     *
     * @param recordIds
     */
    public void setRecordIds(String recordIds) {
        this.recordIds = recordIds;
    }

    /**
     *
     * @return
     */
    public String getBbox() {
        return bbox;
    }

    /**
     *
     * @param bbox
     */
    public void setBbox(String bbox) {
        this.bbox = bbox;
    }

    /**
     *
     * @return
     */
    public String getTime() {
        return time;
    }

    /**
     *
     * @param time
     */
    public void setTime(String time) {
        this.time = time;
    }

    public String getGeometry() {
        return geometry;
    }

    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
    
}
