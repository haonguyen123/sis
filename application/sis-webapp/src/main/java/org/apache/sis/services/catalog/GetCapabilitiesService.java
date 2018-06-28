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

import org.apache.sis.services.csw.ogcservice.GetCapabilities;
import java.io.StringWriter;
import java.util.Collections;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.bind.JAXBException;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import org.apache.sis.metadata.iso.identification.DefaultServiceIdentification;
import org.apache.sis.services.csw.DAO.OGCServiceDAO;
import org.apache.sis.xml.XML;

/**
 *
 * @author haonguyen
 */
@Path("/csw")
@Produces("application/xml")
public class GetCapabilitiesService {           
    @GET
    @Path("/GetCapabilities")
    @Consumes("application/xml")
    public String  getTest() throws JAXBException{
        OGCServiceDAO catalogue =new OGCServiceDAO();  
        return XML.marshal(catalogue.capa());
    }
}