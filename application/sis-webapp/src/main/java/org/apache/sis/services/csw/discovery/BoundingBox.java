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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;
import org.opengis.metadata.extent.GeographicBoundingBox;

/**
 *
 * @author haonguyen
 */
@XmlType(name = "BoundingBoxType", namespace = Namespaces.OWS, propOrder = {
    "lowerCorner",
    "upperCorner",})
@XmlRootElement(name = "BoundingBox", namespace = Namespaces.OWS)
/**
 * XML encoded minimum rectangular bounding box (or region) parameter,
 * surrounding all the associated data.
 */
public class BoundingBox {
    /**
     * Position of the bounding box corner at which the value of each coordinate
     * normally is the algebraic minimum within this bounding box.
     * In some cases, this position is normally displayed at the top, such as the
     * top left for some image coordinates. For more information, see Subclauses
     * 10.2.5 and C.13.
     */
    private List<Double> lowerCorner;
    /**
     * Position of the bounding box corner at which the value of each coordinate
     * normally is the algebraic maximum within this bounding box.
     * In some cases, this position is normally displayed at the bottom, such as
     * the bottom right for some image coordinates. For more information,
     * see Subclauses 10.2.5 and C.13.
     */
    private List<Double> upperCorner;
    /**
     * Usually references the definition of a CRS, as specified in [OGC Topic 2].
     * Such a CRS definition can be XML encoded using the
     * gml:CoordinateReferenceSystemType in [GML 3.1].
     * For well known references, it is not required that a CRS definition exist
     * at the location the URI points to. If no anyURI value is included,
     * the applicable CRS must be either: a) Specified outside the bounding box,
     * but inside a data structure that includes this bounding box, as specified
     * for a specific OWS use of this bounding box type. b) Fixed and specified
     * the Implementation Specification for a specific OWS use of the bounding box type.
     */
    private String crs;
    /**
     * The number of dimensions in this CRS (the length of a coordinate sequence
     * in this use of the PositionType).
     * This number is specified by the CRS definition, but can also be specified here.
     */
    private String dimensions;

    /**
     * Return Position of the bounding box corner at which the value of each coordinate
     * normally is the algebraic minimum within this bounding box.
     * @return Position of the bounding box corner at which the value of each coordinate
     * normally is the algebraic minimum within this bounding box.
     */
    @XmlElement(name = "LowerCorner", namespace = Namespaces.OWS)
    @XmlList
    public List<Double> getLowerCorner() {
        return lowerCorner;
    }

    /**
     * Set Position of the bounding box corner at which the value of each coordinate
     * normally is the algebraic minimum within this bounding box.
     * @param lowerCorner
     */
    public void setLowerCorner(List<Double> lowerCorner) {
        this.lowerCorner = lowerCorner;
    }

    /**
     * Return Position of the bounding box corner at which the value of each coordinate
     * normally is the algebraic maximum within this bounding box.
     * @return Position of the bounding box corner at which the value of each coordinate
     * normally is the algebraic maximum within this bounding box.
     */
    @XmlElement(name = "UpperCorner", namespace = Namespaces.OWS)
    @XmlList
    public List<Double> getUpperCorner() {
        return upperCorner;
    }

    /**
     * Set Position of the bounding box corner at which the value of each coordinate
     * normally is the algebraic maximum within this bounding box.
     * @param upperCorner
     */
    public void setUpperCorner(List<Double> upperCorner) {
        this.upperCorner = upperCorner;
    }

    public BoundingBox() {
    }

    BoundingBox(final GeographicBoundingBox bbox) {
        lowerCorner = new ArrayList<>();
        upperCorner = new ArrayList<>();
        lowerCorner.add(bbox.getWestBoundLongitude());
        lowerCorner.add(bbox.getSouthBoundLatitude());
        upperCorner.add(bbox.getEastBoundLongitude());
        upperCorner.add(bbox.getNorthBoundLatitude());
    }

    @Override
    public String toString() {
        return "BoundingBox{" + "lowerCorner=" + lowerCorner + ", upperCorner=" + upperCorner + ", crs=" + crs + ", dimensions=" + dimensions + '}';
    }
}
