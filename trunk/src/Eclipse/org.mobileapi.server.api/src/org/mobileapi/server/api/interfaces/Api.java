package org.mobileapi.server.api.interfaces;

import java.util.*;

import javax.jws.WebService;

@WebService(targetNamespace = "http://org,mobileapi")
public interface Api {

	public Date ping();
}
