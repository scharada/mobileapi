using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MongoDB.Bson;

namespace org.mobileapi.server.windows.shared
{
    public class Audit
    {
        public BsonObjectId _id
        {
            set;
            get;
        }

        public Guid ID
        {
            set;
            get;
        }

        public Guid OrgID
        {
            set;
            get;
        }

        public String Log
        {
            set;
            get;
        }

        public String Desc
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
