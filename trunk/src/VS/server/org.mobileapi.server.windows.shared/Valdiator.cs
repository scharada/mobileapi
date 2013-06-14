using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Mail;
using System.Text;
using System.Threading.Tasks;

namespace org.mobileapi.server.windows.shared
{
    public class Valdiator
    {
        public bool IsEmail(string email)
        {
            if (email == null || email.Length < 5 || email.Length > 70)
            {
                return false;
            }
            if (email.IndexOf('@') < 0)
            {
                return false;
            }
            if (email.IndexOf('.') < 0)
            {
                return false;
            }
            try
            {
                MailAddress m = new MailAddress(email);
            }
            catch
            {
                return false;
            }
            return true;
        }

        public bool IsPin(string pin)
        {
            if (pin==null || pin.Length < 6 || pin.Length > 12)
            {
                return false;
            }
            return true;
        }

        // TODO define passwort policy
        public bool IsPasswort(string pwd)
        {
            if (pwd == null || pwd.Length < 8 || pwd.Length > 30)
            {
                return false;
            }
            return true;
        }

        public bool IsNewPasswort(string pwd, string repeat)
        {
            if (!IsPasswort(pwd))
            {
                return false;
            }
            if (!pwd.Equals(repeat))
            {
                return false;
            }
            return true;
        }

        public bool IsUpdatePasswort(string oldPwd, string pwd, string repeat)
        {
            if (!IsPasswort(pwd))
            {
                return false;
            }
            if (!pwd.Equals(repeat))
            {
                return false;
            }
            if (oldPwd.Equals(pwd)) // is passwort new
            {
                return false;
            }
            return true;
        }

        public bool IsAppName(string name)
        {
            if (name == null || name.Length < 3 || name.Length > 50)
            {
                return false;
            }
            return true;
        }

        public bool IsAddressField(string field)
        {
            if (field == null || field.Length > 50)
            {
                return false;
            }
            return true;
        }

        public bool IsDesc(string desc)
        {
            if (desc == null || desc.Length > 4096)
            {
                return false;
            }
            return true;
        }
    }
}
