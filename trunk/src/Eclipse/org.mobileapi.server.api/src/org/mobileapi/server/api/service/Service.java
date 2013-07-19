package org.mobileapi.server.api.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.UUID;

import javax.inject.Inject;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.ejb.Stateless;

import org.mobileapi.entity.ErrorCode;
import org.mobileapi.helper.EmailSessionBean;
import org.mobileapi.helper.Emailer;
import org.mobileapi.helper.HelperTime;
import org.mobileapi.helper.Validator;
import org.mobileapi.server.api.interfaces.Api;
import org.mobileapi.server.db.DBFactory;
import org.mobileapi.server.db.UserService;
import org.mobileapi.server.entity.*;

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
        endpointInterface = "org.mobileapi.server.entity.MobileAPIType")
@Stateless()
public class Service implements MobileAPIType {
	
	private UserService userService = new UserService();
	private Validator validator = new Validator();
	
	@Inject
	private Emailer emailer;

	@Override
	public ReadUserResponse readUser(ReadUserRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SaveUserResponse saveUser(SaveUserRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReadAppResponse readApp(ReadAppRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SaveAppResponse saveApp(SaveAppRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListAppsResponse listApps(ListAppsRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReadDeviceResponse readDevice(ReadDeviceRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListDevicesResponse listDevices(ListDevicesRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SaveDeviceResponse saveDevice(SaveDeviceRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReadChannelResponse readChannel(ReadChannelRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListChannelsResponse listChannels(ListChannelsRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SaveChannelResponse saveChannel(SaveChannelRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegisterUserResponse registerUser(RegisterUserRequest request) {
		RegisterUserResponse r = new RegisterUserResponse();
		
		// validate email
		if(!validator.IsEmail(request.getEmail()))
		{
			r.setStatus(BigInteger.valueOf(ErrorCode.NOTAVALIDEMAIL));
			r.setStatusMsg(ErrorCode.ToString(ErrorCode.NOTAVALIDEMAIL));
			return r;
		}
		
		// user exists
		if(userService.exists(request.getEmail()))
		{
			r.setStatus(BigInteger.valueOf(ErrorCode.USEREXISTS));
			r.setStatusMsg(ErrorCode.ToString(ErrorCode.USEREXISTS));
			return r;
		}
		
		// insert user
		User user = new User();
		user.setUserId(UUID.randomUUID().toString());
		user.setEmail(request.getEmail());
		user.setToken(UUID.randomUUID().toString());
		user.setStatus(EnumUserStatus.INVITED);
		user.setUpdate(HelperTime.now());
		user.setCreate(HelperTime.now());
		user.setName("");
		try
		{
			userService.insert(user);
		}
		catch(Exception err)
		{
			r.setStatus(BigInteger.valueOf(ErrorCode.GENERALERROR));
			r.setStatusMsg(ErrorCode.ToString(ErrorCode.GENERALERROR));
			return r;
		}
		
		// send Email
		emailer.invite(user.getEmail(), user.getToken(), user.getLanguage());
		
		// confirm
		r.setToken(user.getToken());
		r.setStatus(BigInteger.valueOf(ErrorCode.OK));
		return r;
	}

	@Override
	public ConfirmUserResponse confirmUser(ConfirmUserRequest request) {
		// TODO Auto-generated method stub
		ConfirmUserResponse r = new ConfirmUserResponse();
		r.setStatus(BigInteger.valueOf(ErrorCode.OK));
		return r;
	}

	@Override
	public InitPwdUserResponse initPwdUser(InitPwdUserRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LogonResponse logon(LogonRequest request) {
		LogonResponse r = new LogonResponse();
		r.setStatus(BigInteger.valueOf(ErrorCode.OK));
		r.setToken("thisisatoken");
		return r;
	}

}
