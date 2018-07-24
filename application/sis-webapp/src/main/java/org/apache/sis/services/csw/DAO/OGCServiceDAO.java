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
package org.apache.sis.services.csw.DAO;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.sis.parameter.DefaultParameterDescriptor;
import org.apache.sis.services.csw.ogcservice.Capabilities;
import org.apache.sis.services.ows.Address;
import org.apache.sis.services.ows.AllowedValues;
import org.apache.sis.services.ows.DCP;
import org.apache.sis.services.ows.HTTP;
import org.apache.sis.services.ows.OnlineResource;
import org.apache.sis.services.ows.OwsContact;
import org.apache.sis.services.ows.OwsDomain;
import org.apache.sis.services.ows.OwsKeywords;
import org.apache.sis.services.ows.OwsOperation;
import org.apache.sis.services.ows.OwsOperationsMetadata;
import org.apache.sis.services.ows.OwsServiceIdentification;
import org.apache.sis.services.ows.OwsServiceProvider;
import org.apache.sis.services.ows.RequestMethod;
import org.apache.sis.services.ows.ResponsiblePartySubset;
import org.apache.sis.services.ows.Telephone;
import org.apache.sis.services.ows.Value;
import org.apache.sis.services.ows.Version;

/**
 *
 * @author haonguyen
 */
public class OGCServiceDAO {

    private static Map<String, Object> properties(final String name) {
        final Map<String, Object> properties = new HashMap<>(4);
        properties.put(DefaultParameterDescriptor.NAME_KEY, name);
        return properties;
    }

    static <T> DefaultParameterDescriptor<T> create(final String name, final Class<T> type,
            final T[] validValues, final T defaultValue) {
        return new DefaultParameterDescriptor<>(properties(name), 1, 1, type, null, validValues, defaultValue);
    }

    /**
     *
     * @return
     */
    private OwsServiceIdentification serviceIdentification() {
        OwsServiceIdentification service = new OwsServiceIdentification();
        service.setServiceType("CSW");
        service.setServiceTypeVersion(new Version("3.0.0"));
        service.setTitle("Catalogue Service for Spatial Information");
        service.setAbstracts("SisCatalog based OGC CSW 3.0 Catalogue Service for OGC core and ISO metadata (describing geospatial services, datasets and series)");
        List<OwsKeywords> keywords = new ArrayList<>();
        OwsKeywords a = new OwsKeywords();
        List<String> keyword = new ArrayList<>();
        keyword.add("OGC");
        keyword.add("CSW");
        keyword.add("Catalog Service");
        keyword.add("metadata");
        keyword.add("CSW");
        a.setKeyword(keyword);
        keywords.add(a);
        service.setKeywords(keywords);
        return service;
    }

    private OwsServiceProvider serviceProvider() {
        OwsServiceProvider service = new OwsServiceProvider();
        service.setProviderName("Apache SIS");
        OnlineResource site = new OnlineResource();
        site.setType("simple");
        site.setHref(URI.create("http://sis.apache.org/"));
        service.setProviderSite(site);
        ResponsiblePartySubset party = new ResponsiblePartySubset();
        party.getIndividualName();
        party.getPositionName();
        OwsContact contact = new OwsContact();
        Address address = new Address();
        address.setDeliveryPoint("401 Edgewater Place");
        address.setCity("Wakefield");
        address.setAdministrativeArea("SIS");
        address.setPostalCode("01880");
        address.setCountry("U.S.A");
        address.setElectronicMailAddress("apache@apache.org");
        Telephone phone = new Telephone();
        phone.setVoice("+1.919.573.9199");
        phone.setFacsimile("+1.919.573.9199");
        OnlineResource resource = new OnlineResource();
        resource.setHref(URI.create("mailto:apache@apache.org"));
        contact.setAddress(address);
        contact.setPhone(phone);
        contact.setOnlineResource(resource);
        party.setContactInfo(contact);
        service.setServiceContact(party);
        return service;
    }

    private OwsOperationsMetadata operationsMetadata() {
        OwsOperationsMetadata operations = new OwsOperationsMetadata();
        List<OwsOperation> listoperation = new ArrayList<>();
        OwsOperation getCapabilities = new OwsOperation();
        getCapabilities.setName("GetCapabilities");
        DCP capaDCP = new DCP();
        HTTP capaHTTP = new HTTP();
        RequestMethod capaMethod = new RequestMethod();
        capaMethod.setHref(URI.create("http://www.sdisuite.de/terraCatalog/soapService/services/CSWDiscovery"));
        capaHTTP.setGet(capaMethod);
        capaDCP.setHttp(capaHTTP);
        getCapabilities.setDcp(capaDCP);
        listoperation.add(getCapabilities);
        operations.setOperation(listoperation);
        List<OwsDomain> parameters = new ArrayList<>();
        OwsDomain parameter = new OwsDomain();
        AllowedValues allow = new AllowedValues();
        List<Value> values = new ArrayList<>();
        Value value = new Value();
        value.setValue("3.0.3");
        values.add(value);
        allow.setValue(values);
        parameter.setName("AcceptVersions");
        parameter.setAllowedValues(allow);
        parameters.add(parameter);
        List<OwsDomain> constraints = new ArrayList<>();
        OwsDomain constraint = new OwsDomain();
        AllowedValues allowconstraint = new AllowedValues();
        List<Value> valuesconstraint = new ArrayList<>();
        Value valueconstraint = new Value();
        valueconstraint.setValue("true");
        valuesconstraint.add(valueconstraint);
        allowconstraint.setValue(valuesconstraint);
        constraint.setName("OpenSearch");
        constraint.setAllowedValues(allowconstraint);
        constraints.add(constraint);
        getCapabilities.setParameter(parameters);
        operations.setConstraint(constraints);
        return operations;
    }

    /**
     *
     * @return
     */
    public Capabilities capa() {
        Capabilities capabilities = new Capabilities();
        capabilities.setOperationsMetadata(operationsMetadata());
        capabilities.setServiceIdentification(serviceIdentification());
        capabilities.setServiceProvider(serviceProvider());
        return capabilities;
    }
}
