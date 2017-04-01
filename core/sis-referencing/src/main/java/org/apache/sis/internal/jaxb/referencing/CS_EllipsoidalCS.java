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
package org.apache.sis.internal.jaxb.referencing;

import javax.xml.bind.annotation.XmlElement;
import org.opengis.referencing.cs.EllipsoidalCS;
import org.apache.sis.referencing.cs.DefaultEllipsoidalCS;
import org.apache.sis.internal.jaxb.gco.PropertyType;


/**
 * JAXB adapter mapping implementing class to the GeoAPI interface. See
 * package documentation for more information about JAXB and interface.
 *
 * @author  Cédric Briançon (Geomatys)
 * @author  Martin Desruisseaux (Geomatys)
 * @version 0.4
 * @since   0.4
 * @module
 */
public final class CS_EllipsoidalCS extends PropertyType<CS_EllipsoidalCS, EllipsoidalCS> {
    /**
     * Empty constructor for JAXB only.
     */
    public CS_EllipsoidalCS() {
    }

    /**
     * Returns the GeoAPI interface which is bound by this adapter.
     * This method is indirectly invoked by the private constructor
     * below, so it shall not depend on the state of this object.
     *
     * @return {@code EllipsoidalCS.class}
     */
    @Override
    protected Class<EllipsoidalCS> getBoundType() {
        return EllipsoidalCS.class;
    }

    /**
     * Constructor for the {@link #wrap} method only.
     */
    private CS_EllipsoidalCS(final EllipsoidalCS cs) {
        super(cs);
    }

    /**
     * Invoked by {@link PropertyType} at marshalling time for wrapping the given value
     * in a {@code <gml:EllipsoidalCS>} XML element.
     *
     * @param  cs  the element to marshall.
     * @return a {@code PropertyType} wrapping the given the element.
     */
    @Override
    protected CS_EllipsoidalCS wrap(final EllipsoidalCS cs) {
        return new CS_EllipsoidalCS(cs);
    }

    /**
     * Invoked by JAXB at marshalling time for getting the actual element to write
     * inside the {@code <gml:EllipsoidalCS>} XML element.
     * This is the value or a copy of the value given in argument to the {@code wrap} method.
     *
     * @return the element to be marshalled.
     */
    @XmlElement(name = "EllipsoidalCS")
    public DefaultEllipsoidalCS getElement() {
        return DefaultEllipsoidalCS.castOrCopy(metadata);
    }

    /**
     * Invoked by JAXB at unmarshalling time for storing the result temporarily.
     *
     * @param  cs  the unmarshalled element.
     */
    public void setElement(final DefaultEllipsoidalCS cs) {
        metadata = cs;
    }
}
