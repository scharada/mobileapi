package org.mobileapi.server.api.service;

import java.util.Date;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

import org.mobileapi.server.api.interfaces.Api;
import org.mobileapi.server.db.DBFactory;
import com.mongodb.DB;

// http://tomee.apache.org/examples-trunk/simple-webservice/

// tomee
//http://localhost:8080/mobileapi/webservices/Service?wsdl

//glassfish 4
// http://localhost:8080/mobile/Service?wsdl

@WebService(
        portName = "MobileApiPort",
        serviceName = "mobile",
        targetNamespace = "http://mobileapi.org",
        endpointInterface = "org.mobileapi.server.api.interfaces.Api")
@Stateless()
public class Service implements Api {

	@Override
	 @WebMethod(operationName = "ping")
	// @WebParam(name = "i") final int i
	public Date ping() {
		DBFactory factory = new DBFactory();
		DB  db = factory.get();
		System.out.print(db);
		return new Date();
	}
}
