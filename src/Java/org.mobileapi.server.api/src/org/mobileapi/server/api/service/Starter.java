package org.mobileapi.server.api.service;

import java.net.UnknownHostException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


import javax.inject.Inject;
import javax.inject.Named;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.mobileapi.helper.AMPQClient;
import org.mobileapi.helper.Zoo;

@Named
@Startup
@Singleton
public class Starter {
	
	@Inject
	private Zoo _zoo;
	
	@Inject
	private AMPQClient _aMPQClient;
	
	@PostConstruct
	public void start()
	{

		try {
			String localhostname = java.net.InetAddress.getLocalHost().getHostName();
			
			System.out.println("localhostname:" + localhostname);
			
			System.out.println("================");
			_zoo.startup();
			System.out.println(" Zookepper connected ");
			System.out.println("================");
			
			
			System.out.println("================");
			_aMPQClient.startup();
			System.out.println(" AMPQClient connected ");
			System.out.println("================");
			
			// 
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@PreDestroy
	private void shutdown() {
		
		
	}
}
