using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

// http://docs.mongodb.org/ecosystem/tutorial/getting-started-with-csharp-driver/
// C:\Program Files (x86)\MongoDB\CSharpDriver 1.8.1 o whatever version

using MongoDB.Bson;
using MongoDB.Driver;
using System.Configuration;
using MongoDB.Driver.Builders;
using org.mobileapi.server.windows.shared;

namespace org.mobileapi.server.windows.shared.db
{
    public class DeviceService
{
        private MongoClient _MongoClient;
        private MongoDatabase _DB;
        private bool _IsDBLogon;
        private int _DBLogonCount;
        private MongoServer _server;

        public DeviceService()
        {
            try
            {
                _MongoClient = new MongoClient(ConfigurationSettings.AppSettings[Key.MONGODB_CONNSTRING]);
                _server = _MongoClient.GetServer();
                _DB = _server.GetDatabase(Key.DB);
            }
            catch (Exception err)
            {
                Console.WriteLine(err);
            }
        }

        public Device Read(Guid deviceID)
        {
            MongoCollection<Device> collection = _DB.GetCollection<Device>(Key.DEVICE);
            var query = Query<Device>.EQ(e => e.ID, deviceID);
            return collection.FindOne(query);
        }

        public bool Exists(Guid id)
        {
            if (id==Guid.Empty)
            {
                return false;
            }
            MongoCollection<Device> collection = _DB.GetCollection<Device>(Key.DEVICE);
            var query = Query<Device>.EQ(e => e.ID, id);
            foreach (Device u in collection.Find(query))
            {
                return true;
            }
            return false;
        }

        public void Create(Device device)
        {
            if (Exists(device.ID))
            {
                return;
            }
            MongoCollection<Device> collection = _DB.GetCollection<Device>(Key.DEVICE);
            device.Create = DateTime.Now;
            device.Update = device.Create;
            collection.Insert(device);
        }

        public void Update(Device device)
        {
            MongoCollection<Device> collection = _DB.GetCollection<Device>(Key.DEVICE);
            var query = Query<Conf>.EQ(e => e._id, device._id);
            var deviceDB = collection.FindOne(query);
            deviceDB.ID = deviceDB.ID;
            deviceDB.AppID = deviceDB.AppID;
            deviceDB.Fix = deviceDB.Fix;
            deviceDB.GPSTime = deviceDB.GPSTime;
            deviceDB.Lat = deviceDB.Lat;
            deviceDB.Long = deviceDB.Long;
            deviceDB.Pin = deviceDB.Pin;
            deviceDB.Sat = deviceDB.Sat;
            deviceDB.Status = deviceDB.Status;
            deviceDB.User = deviceDB.User;
            deviceDB.Update = DateTime.Now;
            collection.Save(deviceDB);
        }

        public void Delete(Device device)
        {
            MongoCollection<Device> collection = _DB.GetCollection<Device>(Key.DEVICE);
            var query = Query<Device>.EQ(e => e._id, device._id);
            collection.Remove(query);
        }

        public void Close()
        {
            _server.Disconnect();
        }
    }
}
