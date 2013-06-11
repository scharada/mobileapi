using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace org.mobileapi.server.windows.shared
{
    public class Device
    {
        public Guid ID
        {
            set;
            get;
        }

        public Guid DeviceID
        {
            set;
            get;
        }

        public Guid AppID
        {
            set;
            get;
        }

        public String User
        {
            set;
            get;
        }

        public String Pin
        {
            set;
            get;
        }

        public double Lat
        {
            set;
            get;
        }

        public double Long
        {
            set;
            get;
        }

        public int Fix
        {
            set;
            get;
        }

        public int Sat
        {
            set;
            get;
        }

        public DateTime GPSTime
        {
            set;
            get;
        }

        public EnumDeviceStatus Status
        {
            set;
            get;
        }


        public Guid Token
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
