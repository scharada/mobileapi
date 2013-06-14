using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using org.mobileapi.server.windows.shared;
using org.mobileapi.server.windows.shared.db;
using System.Collections.Generic;
using System.Configuration;


namespace org.mobileapi.server.windows.portal.test
{

     [TestClass]
    public class UnitTestEmailer
    {
         [TestMethod]
         public void Test_EmailService()
         {
             org.mobileapi.server.windows.shared.Emailer emailer = new Emailer();
             emailer.Configure(ConfigurationSettings.AppSettings[Key.MAILSERVER_HOST], Convert.ToInt32(ConfigurationSettings.AppSettings[Key.MAILSERVER_PORT]));
            
             Assert.IsTrue(emailer.Send("info@mobileapi.com" , "mathias.dietrich@gmail.com" , "test from mobileAPI" , "<font color=green><h1>Test Body</h1>"));
         }
    }
}
