package org.mobileapi.server.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.mobileapi.helper.Zoo;
import org.mobileapi.helper.ZookeeperKeyFilter;
import org.mobileapi.server.api.service.Factory;


/**
 * Servlet implementation class AdminZookeeper
 */
@WebServlet(description = "Configure Zookeeper", urlPatterns = { "/AdminZookeeper" })
public class AdminZookeeper extends HttpServlet {
	
	private Logger L = Logger.getLogger(AdminZookeeper.class);
	
	private static final long serialVersionUID = 1L;
	private static LinkedHashMap<String,String> conf = new  LinkedHashMap<String,String>();
	
	private String username = "";
	private String pwd = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminZookeeper() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		get(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		get(request, response);
	}
	
	public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{			
		boolean authenticated = false;
		String msg = "";
		
		username = request.getParameter("username");
		pwd = request.getParameter("pwd");
		
		Zoo zoo = Factory.zoo();
		
		// Authenticate
		if(Factory.xmlConfig().adminUsername.equals(username) && Factory.xmlConfig().adminPwd.equals(pwd))
		{
			authenticated = true;
		}
		else
		{
			username = "";
			pwd = "";
		}
		
		// cmd
		String cmd = "";
		cmd = request.getParameter("btn");

		if(cmd!=null && cmd.length() > 0)
		{
			// ********************************************
			if(cmd.equals("load from Zookeeper"))
			// ********************************************
			{
				List<String> keys =  zoo.list("/");
				java.util.Collections.sort(keys);
				conf.clear();
				for(int i=0; i < keys.size(); i++)
				{
					// filter out keys we keep internal
					if(ZookeeperKeyFilter.doFilter( keys.get(i)))
					{
						continue;
					}
					try {
						String v0 = zoo.get("/" + keys.get(i));
						if(!v0.equals("-"))
						{
							conf.put("/" + keys.get(i),  v0);
						}
						List<String> subkeys =  zoo.list("/" + keys.get(i));
						java.util.Collections.sort(subkeys);
						for(int j=0; j < subkeys.size(); j++)
						{
							String k = "/" +  keys.get(i) + "/" + subkeys.get(j);
							String v1 = zoo.get(k);
							if(!v1.equals("-"))
							{
								conf.put(k,  v1);
							}
							List<String> subkeysLevel3 =  zoo.list(k);
							java.util.Collections.sort(subkeysLevel3);
							for(int ks=0; ks < subkeysLevel3.size(); ks++)
							{
								String k3 = "/" +  keys.get(i)  + "/" + subkeys.get(j) + "/" + subkeysLevel3.get(ks);
								String v2 =  zoo.get(k3);
								if(!v2.equals("-"))
								{
									conf.put(k3, v2);
								}
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				msg = "Loaded from Zookeper " + new Date();
			}
			// ********************************************
			else if(cmd.equals("save to Zookeeper"))
			// ********************************************
			{
				String[] fields = request.getParameterValues("field"); 
				Iterator<String> it = conf.keySet().iterator();
				int i = 0;
				while(it.hasNext())
				{
					String key = it.next();
					conf.put(key,  fields[i].trim());
					i++;
				}
				
				String newVal = "";
				String newKey = "";
				newVal = request.getParameter("newVal").trim();
				newKey = request.getParameter("newKey").trim();
				if(newKey.length() > 0)
				{
					conf.put(newKey, newVal);
				}
				Iterator<String> it2 = conf.keySet().iterator();
				while(it2.hasNext())
				{
					String key = it2.next();
					zoo.set(key, conf.get(key));
				}
				msg = "Saved to Zookeper " + new Date();
			}
			else if(cmd.equals("logout"))
			{
				authenticated = false;
				pwd = "";
				username ="";
			}
			else if(cmd.equals("remove"))
			{
				String[] boxes = request.getParameterValues("cbx"); 
				if(boxes==null || boxes.length==0)
				{
					msg = "no items to remove  " + new Date();
				}
				else
				{
					for(String box : boxes)
					{
						conf.remove(box);
						zoo.delete(box);
					}
					msg = "Removed items " + new Date();
				}
			}
			else if(cmd.equals("update"))
			{
				String[] fields = request.getParameterValues("field"); 
				Iterator<String> it = conf.keySet().iterator();
				int i =0;
				while(it.hasNext())
				{
					String key = it.next();
					conf.put(key,  fields[i].trim());
					i++;
				}
				
				String newVal = "";
				String newKey = "";
				newVal = request.getParameter("newVal").trim();
				newKey = request.getParameter("newKey").trim();
				if(newKey.length() > 0)
				{
					conf.put(newKey, newVal);
				}
				msg = "Updated " + new Date();
			}
			else if(cmd.equals("set default"))
			{
				setDefault();
				msg = "Default set " + new Date();
			}
		}
		
		String html = getTemplate(authenticated, username, pwd, msg);
		if(authenticated)
		{
			StringBuffer sb = new StringBuffer();
			Iterator<String> it = conf.keySet().iterator();
			while(it.hasNext())
			{
				String key = it.next();
				sb.append(getLine(key, conf.get(key)));
			}
	
			html = String.format(html, sb.toString());
		}
		else
		{
			html = String.format(html, "<tr><td colspan=3>Please authenticate</td></tr>");
		}
		response.getWriter().println(html);
	}
	
	private void setDefault()
	{
		conf.clear();

		conf.put("/mongodb/host","localhost");
		conf.put("/mongodb/port","27017");
		conf.put("/mongodb/username","guest");  
		conf.put("/mongodb/pwd","guest");
		
		conf.put("/redis/host","localhost");
		conf.put("/redis/port","6379");
		
		conf.put("/apmq/host","localhost");
		conf.put("/apmq/port","5672"); 
		
		conf.put("/broker/count","1");  
		conf.put("/broker/0/queueIN","broker0"); 
		conf.put("/broker/0/active","true");  
		
		conf.put("/api/count","1");
		conf.put("/api/0/url","https://api.mobileapi.org:8181/api"); 
		conf.put("/api/0/active","true");  
		
		conf.put("/callback/count","1");  
		conf.put("/callback/0/queueIN","callback0");  
		conf.put("/callback/0/active","true");
		
		conf.put("/gate/count","1");
		conf.put("/gate/0/queueIN","gate0");  
		conf.put("/gate/0/url","https://gate.mobileapi.org"); 
		conf.put("/gate/0/active","true");
	}
	
	public String getLine(String key, String val)
	{
		return "<tr><td bgcolor=#EEEEEE><input name=field type=text size=50 value='" + val + "'/></td><td bgcolor=#EEEEEE><b>" + key + "</b></td><td><input type=checkbox name=cbx value='" + key + "'/></td></tr>";
	}
	
	public String getTemplate(boolean authenticated, String user, String pwd, String msg)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("<head><title>mobileAPI Admin</title></head><body bgcolor=#DDDDDDD font='Arial'><form method=post><table  bordercolor=#6666FF cellspacing=0 cellpadding=0 border=1>");
		
		sb.append("<tr><td bgcolor=#6666FF colspan=3><h1><font color=white>mobileAPI Administration</font></h1></td></tr><tr><td bgcolor=#6666FF colspan=3><h2><font color=white>Zookeeper Configuration</font></h2></td></tr>");
		sb.append("<tr><td bgcolor #6666FF colspan=3><input placeholder='username' type=text size=40");
		sb.append(" value='" + user +"' ");
		sb.append("name=username /> <input placeholder='password' type=password size=40");
		sb.append(" value='" + pwd + "' name=pwd><input type='submit' name='btn' value=");
		if(authenticated)
		{
			sb.append("'logout'");
			sb.append("/></td></tr>");
			sb.append(" %s ");
			sb.append("<tr><td bgcolor=#EEEEEE><input type=text size=50 name=newVal /></td><td bgcolor=#EEEEEE><input type=text name=newKey /></td><td></td></tr>");
			sb.append("<tr bgcolor=#999999><td bgcolor=#999999><input type=submit style='border-color:#FF0000;border-style:solid;' value='save to Zookeeper' name=btn />&nbsp;&nbsp;<input type=submit value='load from Zookeeper' name=btn />&nbsp;&nbsp;<input type=submit value=update name=btn /></td><td bgcolor=#999999><input style='border-color:#FF0000;border-style:solid;' type=submit name=btn value='set default' /></td><td bgcolor=#999999><input  style='border-color:#FF0000;border-style:solid;' type=submit value=remove name=btn /></td></tr></table>");
						
		}
		else
		{
			sb.append("'logon'");
			sb.append("/></td></tr>");
		}
		sb.append("<div><font size=2 color=blue>" +  msg + "</div></form></body>");
		sb.append("</form></body>");

		return sb.toString();
	}
	
	

}