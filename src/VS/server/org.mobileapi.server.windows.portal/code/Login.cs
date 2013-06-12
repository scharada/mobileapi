using org.mobileapi.server.windows.shared;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Mail;
using System.Web;

namespace org.mobileapi.server.windows.portal.code
{
    public class Login
    {
        public Dictionary<string,string> go(HttpRequest req, HttpResponse res)
        {
             Dictionary<string, string> rep = new Dictionary<string, string>();
             rep[Key.STATUS] = Key.ERROR;
             string email = req[Key.EMAIL];
             string pwd = req[Key.PASSWORT];
             try
            {
                MailAddress m = new MailAddress(email);
                if (pwd.Length < 6 || pwd.Length > 50)
                 {
                     return rep;
                 }
                rep[Key.CMD] = Key.LOGIN;
                rep[Key.STATUS] = Key.OK;
                rep[Key.NAME] = "mat";
               
                return rep;
            }
            catch (FormatException)
            {

            }
             return rep;
        }
    }
}