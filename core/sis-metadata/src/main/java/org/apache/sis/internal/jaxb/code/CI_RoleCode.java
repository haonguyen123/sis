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
package org.apache.sis.internal.jaxb.code;

import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElement;
import org.opengis.metadata.citation.Role;
import org.apache.sis.internal.jaxb.gmd.CodeListAdapter;
import org.apache.sis.internal.jaxb.gmd.CodeListUID;
import org.apache.sis.xml.Namespaces;


/**
 * JAXB adapter for {@link Role}
 * in order to wrap the value in an XML element as specified by ISO 19115-3 standard.
 * See package documentation for more information about the handling of {@code CodeList} in ISO 19115-3.
 *
 * @author  Cédric Briançon (Geomatys)
 * @author  Cullen Rombach (Image Matters)
 * @author  Martin Desruisseaux (Geomatys)
 * @version 1.0
 * @since   0.3
 * @module
 */
@XmlType(namespace = Namespaces.CIT)
public class CI_RoleCode extends CodeListAdapter<CI_RoleCode, Role> {
    /**
     * Empty constructor for JAXB only.
     */
    public CI_RoleCode() {
    }

    /**
     * Creates a new adapter for the given value.
     */
    private CI_RoleCode(final CodeListUID value) {
        super(value);
    }

    /**
     * {@inheritDoc}
     *
     * @return the wrapper for the code list value.
     */
    @Override
    protected CI_RoleCode wrap(final CodeListUID value) {
        return new CI_RoleCode(value);
    }

    /**
     * {@inheritDoc}
     *
     * @return the code list class.
     */
    @Override
    protected final Class<Role> getCodeListClass() {
        return Role.class;
    }

    /**
     * Invoked by JAXB on marshalling.
     *
     * @return the value to be marshalled.
     */
    @Override
    @XmlElement(name = "CI_RoleCode")
    public final CodeListUID getElement() {
        return identifier;
    }

    /**
     * Invoked by JAXB on unmarshalling.
     *
     * @param  value  the unmarshalled value.
     */
    public final void setElement(final CodeListUID value) {
        identifier = value;
    }

    /**
     * Wraps the value only if marshalling an element from the ISO 19115:2003 metadata model.
     * Otherwise (i.e. if marshalling according legacy ISO 19115:2014 model), omits the element.
     */
    public static final class Since2014 extends CI_RoleCode {
        /** Empty constructor used only by JAXB. */
        public Since2014() {
        }

        /**
         * Wraps the given value in an ISO 19115-3 element, unless we are marshalling an older document.
         *
         * @return a non-null value only if marshalling ISO 19115-3 or newer.
         */
        @Override protected CI_RoleCode wrap(final CodeListUID value) {
            return accept2014() ? super.wrap(value) : null;
        }
    }
}
