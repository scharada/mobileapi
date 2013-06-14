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
    public class ChannelService
    {
        private MongoClient _MongoClient;
        private MongoDatabase _DB;
        private bool _IsDBLogon;
        private int _DBLogonCount;
        private MongoServer _server;

        public ChannelService()
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

        public Channel Read(Guid channelID)
        {
            MongoCollection<Channel> collection = _DB.GetCollection<Channel>(Key.CHANNEL);
            var query = Query<App>.EQ(e => e.ID, channelID);
            return collection.FindOne(query);
        }

        public bool Exists(Guid channelID)
        {
            MongoCollection<Channel> collection = _DB.GetCollection<Channel>(Key.CHANNEL);
            var query = Query<Conf>.EQ(e => e.ID, channelID);
            foreach (Channel u in collection.Find(query))
            {
                return true;
            }
            return false;
        }

        public void Create(Channel channel)
        {
            if (Exists(channel.ID))
            {
                return;
            }
            MongoCollection<Channel> collection = _DB.GetCollection<Channel>(Key.CHANNEL);
            channel.Create = DateTime.Now;
            channel.Update = channel.Create;
            collection.Insert(channel);
        }

        public void Update(Channel channel)
        {
            MongoCollection<Channel> collection = _DB.GetCollection<Channel>(Key.CHANNEL);
            var query = Query<Conf>.EQ(e => e._id, channel._id);
            var channelDB = collection.FindOne(query);
            channelDB.ID = channel.ID;
            channelDB.AddressMap = channel.AddressMap;
            channelDB.AddressPath = channel.AddressPath;
            channelDB.AddressPermission = channel.AddressPermission;
            channelDB.AddressType = channel.AddressType;
            channelDB.AppID = channel.AppID;
            channelDB.CallBackPwd = channel.CallBackPwd;
            channelDB.CallBackURL = channel.CallBackURL;
            channelDB.CallBackUser = channel.CallBackUser;
            channelDB.MapIn = channel.MapIn;
            channelDB.MapInType = channel.MapInType;
            channelDB.MapOut = channel.MapOut;
            channelDB.MapOutType = channel.MapOutType;
            channelDB.Name = channel.Name;
            channelDB.Priority = channel.Priority;
            channelDB.Retries = channel.Retries;
            channelDB.TTL = channel.TTL;

            channelDB.Update = DateTime.Now;
            collection.Save(channelDB);
        }

        public void Delete(Channel channel)
        {
            MongoCollection<Channel> collection = _DB.GetCollection<Channel>(Key.CHANNEL);
            var query = Query<Channel>.EQ(e => e._id, channel._id);
            collection.Remove(query);
        }

        public void Close()
        {
            _server.Disconnect();
        }
    }
}
