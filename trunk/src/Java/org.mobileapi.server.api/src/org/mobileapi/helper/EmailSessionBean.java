package org.mobileapi.helper;

import java.util.Date;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Named
@RequestScoped
public class EmailSessionBean {

	@Resource(lookup = "email")
	private Session mailSession;

	public void sendEmail(String to, String subject, String body) {
		MimeMessage message = new MimeMessage(mailSession);
		try {
			message.setFrom(new InternetAddress(mailSession.getProperty("mail.from")));
			InternetAddress[] address = {new InternetAddress(to)};
			message.setRecipients(Message.RecipientType.TO, address);
			message.setSubject(subject);
			message.setSentDate(new Date());
			message.setText(body);
			Transport.send(message);
			} 
		catch (MessagingException ex) {
			ex.printStackTrace();
		}
	}
}
