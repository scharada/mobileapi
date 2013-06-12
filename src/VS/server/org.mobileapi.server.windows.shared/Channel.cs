using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace org.mobileapi.server.windows.shared
{
    public class Channel
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

        public int Retries
        {
            set;
            get;
        }

        public int TTL
        {
            set;
            get;
        }

         public int Priority
        {
            set;
            get;
        }

        public EnumOpcode Opcode
        {
            set;
            get;
        }

        public String MapOut
        {
            set;
            get;
        }

        public EnumMapType MapOutType
        {
            set;
            get;
        }

         public String MapIn
        {
            set;
            get;
        }

        public EnumMapType MapInType
        {
            set;
            get;
        }

        public EnumAddressType AddressType
        {
            set;
            get;
        }

        public string AddressPath
        {
            set;
            get;
        }

        public string AddressMap
        {
            set;
            get;
        }

        public EnumAddressPermission AddressPermission
        {
            set;
            get;
        }

        public string CallBackURL
        {
            set;
            get;
        }

        public string CallBackUser
        {
            set;
            get;
        }

        public string CallBackPwd
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

