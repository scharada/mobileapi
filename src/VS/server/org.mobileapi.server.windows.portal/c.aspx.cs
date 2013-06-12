using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using org.mobileapi.server.windows.portal.code;
using System.Web.Script.Serialization;
using org.mobileapi.server.windows.shared;

namespace org.mobileapi.server.windows.portal
{
    public partial class c : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            Dictionary<string, string> rep = new Dictionary<string, string>();
            rep[Key.STATUS] = Key.ERROR;
            try
            {
                string cmd = Request[Key.CMD];

                //  if login
                if (cmd.Equals(Key.LOGIN))
                {
                    rep = new org.mobileapi.server.windows.portal.code.Login().go(Request, Response);
                    Session[Key.SESSION_LOGGEDON] = "false";
                    if (rep[Key.STATUS].Equals(Key.OK))
                    {
                        Session[Key.SESSION_LOGGEDON] = "true";
                    }
                    Response.Write(new JavaScriptSerializer().Serialize(rep));
                    return;
                }

                if (cmd.Equals(Key.REGISTER))
                {
                    rep = new Register().go(Request, Response);
                    string reply = new JavaScriptSerializer().Serialize(rep);
                    Response.Write(reply);
                    return;
                }

                // check if sessi9on exists
                if (!Session[Key.SESSION_LOGGEDON].Equals("true"))
                {
                    rep[Key.MESSAGE] = "No session";
                    Response.Write(new JavaScriptSerializer().Serialize(rep));
                    return;
                }

                // Handle Commands
                switch (cmd)
                {
                    case Key.LOGOUT:
                       rep = new Logout().go(Request, Response);
                       Session[Key.SESSION_LOGGEDON] = "false";
                       return;

                    default:
                        return;
                }
                Response.Clear();
                Response.Write(new JavaScriptSerializer().Serialize(rep));
            }
            catch (Exception err)
            {
                Console.WriteLine(err);
                Response.Clear();
                Response.Write(new JavaScriptSerializer().Serialize(rep));
            }
        }
    }
}