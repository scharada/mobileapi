using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace org.mobileapi.server.windows.shared
{
    public class Valdiator
    {
        public bool IsEmail(string email)
        {
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

        public bool IsPasswort(string pwd)
        {
            if (pwd == null || pwd.Length < 8 || pwd.Length > 30)
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

        public bool IsDesc(string desc)
        {
            return true;
        }
    }
}
