using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net.Mail;

namespace org.mobileapi.server.windows.shared
{
    public class Emailer
    {
        private string host;
        private int port;
        public void Configure(string host, int port)
        {
            this.host = host;
            this.port = port;
        }

       public bool Send(string from, string to, string subject, string body)
       {
           try
           {
               MailMessage mail = new MailMessage(from, to);
               SmtpClient client = new SmtpClient();
               client.Port = 25;
               client.DeliveryMethod = SmtpDeliveryMethod.Network;
               client.UseDefaultCredentials = false;
               client.Host = host;
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
