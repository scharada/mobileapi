using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace org.mobileapi.server.windows.shared
{
    public class Conf
    {
        public Guid ID
        {
            set;
            get;
        }

        public Guid AppID
        {
            set;
            get;
        }

        public String Key
        {
            set;
            get;
        }

        public String Value
        {
            set;
            get;
        }

        public DateTime Update
        {
            set;
            get;
        }

        public DateTime Create
        {
            set;
            get;
        }
    }
}
