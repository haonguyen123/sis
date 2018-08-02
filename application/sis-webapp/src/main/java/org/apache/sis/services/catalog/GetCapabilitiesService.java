package org.apache.sis.services.catalog;

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


import java.io.File;
import java.net.URI;
import java.util.UUID;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
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
import org.apache.sis.services.csw.fes.DefaultPropertyName;
import org.apache.sis.services.csw.fes.DefaultSortBy;
import org.apache.sis.services.csw.impl.DiscoveryImpl;
import org.apache.sis.storage.DataStoreException;
import org.apache.sis.xml.XML;
import org.opengis.filter.sort.SortOrder;

/**
 *
 * @author haonguyen
 */
@Path("/csw")
@Produces("application/xml")
public class GetCapabilitiesService {
    private final Discovery discovery;;

    public GetCapabilitiesService() throws DataStoreException {
        this.discovery = new DiscoveryImpl();
    }

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
        public Response getRecordById(@QueryParam("Id") String id) throws JAXBException, DataStoreException {
            GetRecordById getRecordById = new GetRecordById();
            getRecordById.setId(id);
            return Response
                    .status(200)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                    .header("Access-Control-Allow-Credentials", "true")
                    .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                    .header("Access-Control-Max-Age", "1209600")
                    .entity(XML.marshal(discovery.getRecordById(getRecordById)))
                    .build();
        }
    }

    public class O_GetRecords {

        @GET
        @Consumes("application/xml")
        public Response getRecords( @QueryParam("requestid") URI requestId,
                                    @QueryParam("startposition") @DefaultValue("1") int startPosition,
                                    @QueryParam("maxrecords") @DefaultValue("10") int maxRecords,
                                    @QueryParam("sortby") String sortby,
                                    @QueryParam("q") String q,
                                    @QueryParam("recordids") String recordids,
                                    @QueryParam("bbox") String bbox,
                                    @QueryParam("geometry") String geometry,
                                    @QueryParam("relation") String relation,
                                    @QueryParam("time") String time,
                                    //                                    @QueryParam("trelation") String trelation,
                                    @QueryParam("constraintlanguage") String constraintlanguage,
                                    @QueryParam("constraintlanguageversion") String constraintlanguageversion,
                                    @QueryParam("constraint") String constraint
        ) throws JAXBException, DataStoreException {
            GetRecordsResponse record = new GetRecordsResponse();
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
            Query query = new Query();
            if (sortby != null) {
                String[] element = sortby.split(":");
                if (element.length == 2) {
                    DefaultSortBy sort = new DefaultSortBy();
                    DefaultPropertyName name = new DefaultPropertyName();
                    name.setPropertyName(element[0]);
                    sort.setPropertyName(name);
                    if ("A".equals(element[1])) {
                        sort.setSortOrder(SortOrder.ASCENDING);
                    }
                    if ("D".equals(element[1])) {
                        sort.setSortOrder(SortOrder.DESCENDING);
                    }
                    query.setSortBy(sort);
                    params.setQuery(query);
                }
            }
            if (relation == null) {
                relation = GeometryRelation.INTERSECTS;
            }
            if (constraint != null && "FIQL".equals(constraintlanguage)) {
                Constraint cons = new Constraint();
                cons.setSearch(constraint);
                query.setConstraint(cons);
                params.setQuery(query);
            }
            if (q != null || recordids != null || bbox != null || time != null || geometry != null) {
                FilterFesKvp fes = new FilterFesKvp();
                fes.setRelation(relation);
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
                if (geometry !=null ) {
                    fes.setGeometry(geometry);
                }
                record = discovery.getRecords(params, fes);
            }
            if (q == null && recordids == null && bbox == null && time == null && geometry == null) {
                record = discovery.getRecords(params);
            }
            return Response
                    .status(200)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                    .header("Access-Control-Allow-Credentials", "true")
                    .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                    .header("Access-Control-Max-Age", "1209600")
                    .entity(XML.marshal(record))
                    .build();
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

    @GET
    @Path("/download/{name}")
    @Produces("text/plain")
    public Response getFile(@PathParam("name") String name) throws DataStoreException  {
        File file = discovery.getPath(name);
        Response.ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition", "attachment; filename=" + file.getName());
        return response.build();
    }
}
