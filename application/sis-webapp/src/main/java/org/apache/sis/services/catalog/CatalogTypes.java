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
import java.util.Collection;
import org.apache.sis.internal.jaxb.TypeRegistration;
import org.apache.sis.services.csw.ogcservice.Capabilities;
import org.apache.sis.services.ows.Address;
import org.apache.sis.services.ows.AllowedValues;
import org.apache.sis.services.ows.CapabilitiesBase;
import org.apache.sis.services.ows.DCP;
import org.apache.sis.services.ows.Description;
import org.apache.sis.services.ows.HTTP;
import org.apache.sis.services.ows.Language;
import org.apache.sis.services.ows.OnlineResource;
import org.apache.sis.services.ows.OwsDomain;
import org.apache.sis.services.ows.OwsKeywords;
import org.apache.sis.services.ows.OwsOperation;
import org.apache.sis.services.ows.OwsOperationsMetadata;
import org.apache.sis.services.ows.OwsServiceIdentification;
import org.apache.sis.services.ows.OwsServiceProvider;
import org.apache.sis.services.ows.ResponsiblePartySubset;
import org.apache.sis.services.ows.Telephone;
import org.apache.sis.services.ows.UnNamedDomain;

public class CatalogTypes extends TypeRegistration {
    @Override
    protected void getTypes(final Collection<Class<?>> addTo) {
        addTo.add(Language.class);
        addTo.add(Capabilities.class);
        addTo.add(CapabilitiesBase.class);
        addTo.add(OwsServiceIdentification.class);
        addTo.add(Description.class);
        addTo.add(OwsKeywords.class);
        addTo.add(OwsServiceProvider.class);
        addTo.add(Address.class);
        addTo.add(Telephone.class);
        addTo.add(OnlineResource.class);
        addTo.add(ResponsiblePartySubset.class);
        addTo.add(OwsOperationsMetadata.class);
        addTo.add(OwsOperation.class);
        addTo.add(DCP.class);
        addTo.add(HTTP.class);
        addTo.add(OwsDomain.class);
        addTo.add(UnNamedDomain.class);
        addTo.add(AllowedValues.class);
        // Continue avec tous les nouveaux types ajoutés par tes classes.
    }
}
