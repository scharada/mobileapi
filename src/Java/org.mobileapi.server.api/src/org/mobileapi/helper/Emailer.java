package org.mobileapi.helper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class Emailer {
	
	@Inject
	private EmailSessionBean emailBean;
	
	public void invite(String email, String token,String language)
	{
		emailBean.sendEmail(email, "some", "body");
	}

}
