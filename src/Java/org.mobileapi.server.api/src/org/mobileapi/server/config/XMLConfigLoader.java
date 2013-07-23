package org.mobileapi.server.config;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Logger;
import org.mobileapi.server.api.service.Factory;
import org.w3c.dom.Document;

import java.io.File;

/*

<!-- mobileapi configuration file -->

<!-- place as /etc/mobileapi.conf or c:\mobileapi.conf -->

<m:config xmlns:m="http://mobileapi.org/config">
  <m:zookeeper id="0" host="localhost" port="2181" username="" pwd="" />
  <m:api id="api0" enabled="true"/>
  <m:broker id="broker0" enabled="true"/>
  <m:gate id="gate0" enabled="true"/>
  <m:portal id="portal0" enabled="true"/>
  <m:admin enabled="true" username="admin" pwd="secret" />
</m:config>

 */
public class XMLConfigLoader {
	
	private Logger L = Logger.getLogger(XMLConfigLoader.class);
	
	public String zookeeperHost;
	public int zookeeperPort;
	public String zookeeperUsername;
	public String zookeeperPwd;
	
	public String apiID;
	public String portalID;
	public String brokerID;
	public String gateID;
	
	public String adminUsername;
	public String adminPwd;
	
	public boolean apiEnabled;
	public boolean portalEnabled;
	public boolean brokerEnabled;
	public boolean gateEnabled;
	public boolean adminEnabled;

  
  public boolean parse()
  {
    try {
 
		File fXmlFile;
		boolean isWin =  System.getProperty("os.name").startsWith("Windows") ;
		if(isWin)
		{
			fXmlFile = new File("C:\\mobileapi.conf");	
		}
		else
		{
			fXmlFile = new File("/etc/mobileapi.conf");	
		}
			
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		dbFactory.setNamespaceAware(true);
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		
		//optional, but recommended
		//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
		doc.getDocumentElement().normalize();
		
		UniversalNamespaceResolver namespaceContext = new UniversalNamespaceResolver(doc);
		
		XPath xpath = XPathFactory.newInstance().newXPath();
		xpath.setNamespaceContext(namespaceContext);
	
		XPathExpression expr  = xpath.compile("/m:config/m:zookeeper/@host");
		zookeeperHost = (String)expr.evaluate(doc, XPathConstants.STRING);
		
		expr  = xpath.compile("/m:config/m:zookeeper/@port");
		zookeeperPort = Integer.parseInt((String) expr.evaluate(doc, XPathConstants.STRING));
		
		expr  = xpath.compile("/m:config/m:zookeeper/@username");
		zookeeperUsername = (String)expr.evaluate(doc, XPathConstants.STRING);
		
		expr  = xpath.compile("/m:config/m:zookeeper/@pwd");
		zookeeperPwd = (String)expr.evaluate(doc, XPathConstants.STRING);
		
		expr  = xpath.compile("/m:config/m:api/@id");
		apiID = (String)expr.evaluate(doc, XPathConstants.STRING);
		
		expr  = xpath.compile("/m:config/m:portal/@id");
		portalID = (String)expr.evaluate(doc, XPathConstants.STRING);
		
		expr  = xpath.compile("/m:config/m:broker/@id");
		brokerID = (String)expr.evaluate(doc, XPathConstants.STRING);
		
		expr  = xpath.compile("/m:config/m:gate/@id");
		gateID = (String)expr.evaluate(doc, XPathConstants.STRING);
		
		expr  = xpath.compile("/m:config/m:api/@enabled");
		apiEnabled = (boolean)expr.evaluate(doc, XPathConstants.BOOLEAN);
		
		expr  = xpath.compile("/m:config/m:portal/@enabled");
		portalEnabled= (boolean)expr.evaluate(doc, XPathConstants.BOOLEAN);
		
		expr  = xpath.compile("/m:config/m:broker/@enabled");
		brokerEnabled= (boolean)expr.evaluate(doc, XPathConstants.BOOLEAN);
		
		expr  = xpath.compile("/m:config/m:gate/@enabled");
		gateEnabled= (boolean)expr.evaluate(doc, XPathConstants.BOOLEAN);
		
		expr  = xpath.compile("/m:config/m:superadmin/@enabled");
		adminEnabled= (boolean)expr.evaluate(doc, XPathConstants.BOOLEAN);
		
		expr  = xpath.compile("/m:config/m:superadmin/@username");
		adminUsername = (String)expr.evaluate(doc, XPathConstants.STRING);

		expr  = xpath.compile("/m:config/m:superadmin/@pwd");
		adminPwd = (String)expr.evaluate(doc, XPathConstants.STRING);

		
		//Debug
		L.debug("XMLConfigLoader starts");
		L.debug("zookeeperHost:" + zookeeperHost);
		L.debug("zookeeperPort:" + zookeeperPort);
		L.debug("zookeeperUsername:" + zookeeperUsername);
	    L.debug("zookeeperPwd:" + zookeeperPwd);
	    
	    L.debug("apiID:" + apiID);
	    L.debug("portalID:" + portalID);
	    L.debug("brokerID:" + brokerID);
	    L.debug("gateID:" + gateID);
	    
	    L.debug("apiEnabled:" + apiEnabled);
	    L.debug("portalEnabled:" + portalEnabled);
	    L.debug("brokerEnabled:" + brokerEnabled);
	    L.debug("gateEnabled:" + gateEnabled);
	    L.debug("adminEnabled:" + adminEnabled);
	    
	    L.debug("adminUsername:" + adminUsername);
	    L.debug("adminPwd:" + adminPwd);
	    
	    L.debug("XMLConfigLoader done");
	    return true;
    } 
    catch (Exception e) {
    	e.printStackTrace();
    }
    return false;
  }
}


