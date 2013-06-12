using org.mobileapi.server.windows.shared;
using org.mobileapi.server.windows.shared.db;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Mail;
using System.Web;

namespace org.mobileapi.server.windows.portal.code
{
    public class Register
    {
        public Dictionary<string, string> go(HttpRequest req, HttpResponse res)
        {
            Dictionary<string, string> rep = new Dictionary<string, string>();
            rep[Key.STATUS] = Key.ERROR;

            string name = req[Key.NAME];
            string email = req[Key.EMAIL];
            string pwd1 = req[Key.PASSWORT];
            string pwd2 = req[Key.PASSWORTNEW];
             UserService service = new UserService();
             try
            {
                MailAddress m = new MailAddress(email);
                if ((!pwd1.Equals(pwd2)) || pwd1.Length < 6 || pwd1.Length > 50)
                 {
                     rep[Key.MESSAGE] = "Passwort or passwort repeat not valid";
                     return rep;
                 }

                 // CHeck if user allreqady exists
                if(service.Exists(email))
                {
                    rep[Key.CMD] = Key.REGISTER;
                    rep[Key.STATUS] = Key.ERROR;
                    rep[Key.MESSAGE] = "User exists";
                     service.Close();
                    return rep;
                }

                User user = new User();
                user.Name = name;
                user.Email = email;
                user.Token = Guid.NewGuid();
                user.Status = EnumUserStatus.NEW;
                service.Create(user);

                 // send email
                user.Status = EnumUserStatus.INVITED;
                service.Update(user);

                 // Reply
                rep[Key.CMD] = Key.REGISTER;
                rep[Key.STATUS] = Key.OK;
                service.Close();
                return rep;
            }
            catch (FormatException)
            {
                rep[Key.MESSAGE] = "email not valid";
            }
             service.Close();
             return rep;
        }
    }
}