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

import java.net.URI;
import java.util.UUID;
import javax.ws.rs.*;
import javax.xml.bind.JAXBException;
import org.apache.sis.services.csw.DAO.OGCServiceDAO;
import org.apache.sis.services.csw.common.BasicRetrievalOptions;
import org.apache.sis.services.csw.common.Constraint;
import org.apache.sis.services.csw.common.Query;
import org.apache.sis.services.csw.discovery.Discovery;
import org.apache.sis.services.csw.discovery.FilterFesKvp;
import org.apache.sis.services.csw.discovery.GetRecordById;
import org.apache.sis.services.csw.discovery.GetRecords;
import org.apache.sis.services.csw.discovery.GetRecordsResponse;
import org.apache.sis.services.csw.impl.DiscoveryImpl;
import org.apache.sis.storage.DataStoreException;
import org.apache.sis.xml.XML;

/**
 *
 * @author haonguyen
 */
@Path("/csw")
@Produces("application/xml")
public class GetCapabilitiesService {

    @Path("/")
    public Object sub(@QueryParam("request") String operation,
            @QueryParam("service") String service) {
        if ("CSW".equals(service)) {
            if ("GetCapabilities".equals(operation)) {
                return new O_GetCapabilities();
            } else if ("GetRecordById".equals(operation)) {
                return new O_GetRecordById();
            } else if ("GetRecords".equals(operation)) {
                return new O_GetRecords();
            }
            return null;
        } else {
            return null;
        }

    }

    public class O_GetCapabilities {

        @GET
        @Consumes("application/xml")
        public String getCapabilities() throws JAXBException {
            OGCServiceDAO catalogue = new OGCServiceDAO();
            return XML.marshal(catalogue.capa());
        }
    }

    public class O_GetRecordById {

        @GET
        @Consumes("application/xml")
        public String getRecordById(@QueryParam("Id") String id) throws JAXBException, DataStoreException {
            Discovery discovery = new DiscoveryImpl();
            GetRecordById getRecordById = new GetRecordById();
            getRecordById.setId(id);
            return XML.marshal(discovery.getRecordById(getRecordById));
        }
    }

    public class O_GetRecords {

        @GET
        @Consumes("application/xml")
        public String getRecords(   @QueryParam("requestid") URI requestId,
                                    @QueryParam("startposition") @DefaultValue("1") int startPosition,
                                    @QueryParam("maxrecords") @DefaultValue("4") int maxRecords,
                                    //                                    @QueryParam("sortby") String sortby,
                                    @QueryParam("q") String q,
                                    @QueryParam("recordids") String recordids,
                                    @QueryParam("bbox") String bbox,
        //                                    @QueryParam("geometry") String geometry,
        //                                    @QueryParam("relation") String relation,
                                    @QueryParam("time") String time,
        //                                    @QueryParam("trelation") String trelation,
                                    @QueryParam("constraintlanguage") String constraintlanguage,
                                    @QueryParam("constraintlanguageversion") String constraintlanguageversion,
                                    @QueryParam("constraint") String constraint
        ) throws JAXBException, DataStoreException {
            GetRecordsResponse record = new GetRecordsResponse();
            Discovery discovery = new DiscoveryImpl();
            GetRecords params = new GetRecords();
            if (requestId != null) {
                params.setRequestId(requestId);
            }
            if (requestId == null) {
                params.setRequestId(URI.create("" + UUID.randomUUID() + ""));
            }
            BasicRetrievalOptions option = new BasicRetrievalOptions();
            option.setMaxRecords(maxRecords);
            option.setStartPosition(startPosition);
            params.setBasicRetrievalOptions(option);
            if (q != null || recordids != null || bbox != null || time !=null) {
                FilterFesKvp fes = new FilterFesKvp();
                if (q != null) {
                    fes.setQ(q);
                }
                if (bbox != null) {
                    fes.setBbox(bbox);
                }
                if (recordids != null) {
                    fes.setRecordIds(recordids);
                }
                if (time != null) {
                    fes.setTime(time);
                }
                record = discovery.getRecords(params, fes);
            }
            if (constraint != null && "FIQL".equals(constraintlanguage)) {
                Constraint cons = new Constraint();
                cons.setSearch(constraint);
                Query query = new Query ();
                query.setConstraint(cons);
                params.setQuery(query);
            }
            
//            System.out.println(constraint);
//            long elapsedTime = System.currentTimeMillis() - start;

            if (q == null && recordids == null && bbox == null && time ==null) {
                record = discovery.getRecords(params);
            }
//            record.getSearchResults().setElapsedTime(elapsedTime);
            return XML.marshal(record);
        }
    }

    public class O_GetDomain {

    }

    public class O_Harvest {

    }

    public class O_UnHarvest {

    }

    public class O_Transaction {

    }
}
