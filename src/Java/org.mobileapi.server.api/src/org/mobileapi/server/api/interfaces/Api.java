package org.mobileapi.server.api.interfaces;

import java.util.*;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.mobileapi.entity.User;

@WebService(targetNamespace = "http://org.mobileapi")
public interface Api {

	public Date ping();
	
	public User readUserByEmail(@WebParam(name="email") String email);
}
