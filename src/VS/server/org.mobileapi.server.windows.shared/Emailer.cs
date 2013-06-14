using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net.Mail;
using System.Configuration;

namespace org.mobileapi.server.windows.shared
{
    public class Emailer
    {
        private static string _host;
        private static int _port;
        public static void Configure(string host, int port)
        {
            _host = host;
            _port = port;
        }

        public bool SendRegistration(string to, string name, string linkParams)
        {
             string link = ConfigurationSettings.AppSettings[Key.EMAILCONFIRMATIONLINK];
             string from = ConfigurationSettings.AppSettings[Key.EMAILCONFIRMATIONSENDER];
             string subject = ConfigurationSettings.AppSettings[Key.EMAILCONFIRMATIONSUBJECT];
             string fileName = ConfigurationSettings.AppSettings[Key.EMAILCONFIRMATIONFILE];

             FileLoader f = new FileLoader();
             string html = f.Load(fileName);

            // replace
             html = string.Format(html, name, link + linkParams);
             return Send(from, to, subject, html);
        }

       public bool Send(string from, string to, string subject, string body)
       {
           try
           {
               MailMessage mail = new MailMessage(from, to);
               SmtpClient client = new SmtpClient();
               client.Port = _port;
               client.DeliveryMethod = SmtpDeliveryMethod.Network;
               client.UseDefaultCredentials = false;
               client.Host = _host;
               mail.Subject = subject;
               mail.Body = body;
               client.Send(mail);
               return true;
           }
           catch (Exception err)
           {
               Console.Write(err);
           }
           return false;
       }
    }
}
