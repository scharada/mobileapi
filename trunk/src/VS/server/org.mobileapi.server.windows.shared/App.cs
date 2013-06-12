using MongoDB.Bson;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace org.mobileapi.server.windows.shared
{
    public class App
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

        public Guid AppID
        {
            set;
            get;
        }

        public List<Guid>UserIDS
        {
            set;
            get;
        }

        public String Name
        {
            set;
            get;
        }

        public String Desc
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
