using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using MongoDB.Bson;

namespace org.mobileapi.server.windows.shared
{
    public class MsgLog
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

        public Guid MsgID
        {
            set;
            get;
        }

        public EnumOpcode Opcode
        {
            set;
            get;
        }

        public Guid Sender
        {
            set;
            get;
        }

        public Guid Receiver
        {
            set;
            get;
        }

        public EnumMsgStatus EnumMsgStatus
        {
            set;
            get;
        }

        public byte[] Bin
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
