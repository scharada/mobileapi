using org.mobileapi.server.windows.shared;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace org.mobileapi.server.windows.portal.code
{
    public class Logout
    {
        public Dictionary<string, string> go(HttpRequest req, HttpResponse res)
        {
            Dictionary<string, string> rep = new Dictionary<string, string>();
            rep[Key.STATUS] = Key.ERROR;
            try
            {
                rep[Key.CMD] = Key.LOGOUT;
                rep[Key.STATUS] = Key.OK;
                return rep;
            }
            catch (FormatException)
            {

            }
            return rep;
        }
    }
}