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
    public class ConfService
    {
        private MongoClient _MongoClient;
        private MongoDatabase _DB;
        private bool _IsDBLogon;
        private int _DBLogonCount;
        private MongoServer _server;

        public ConfService()
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

        public Conf Read(Guid appID, string key)
        {
            MongoCollection<Conf> collection = _DB.GetCollection<Conf>(Key.CONF);
            var query = Query.And(Query<Conf>.EQ(e => e.AppID, appID),Query<Conf>.EQ(e => e.Key,  key)) ;
            return collection.FindOne(query);
        }

        public bool Exists(Guid appID, string key)
        {
            MongoCollection<Conf> collection = _DB.GetCollection<Conf>(Key.CONF);
            var query = Query.And(Query<Conf>.EQ(e => e.AppID, appID), Query<Conf>.EQ(e => e.Key, key));
            foreach (Conf u in collection.Find(query))
            {
                return true;
            }
            return false;
        }

        public void Create(Conf conf)
        {
            if (Exists(conf.AppID, conf.Key))
            {
                return;
            }
            MongoCollection<Conf> collection = _DB.GetCollection<Conf>(Key.CONF);
            collection.Insert(conf);
        }

        public void Update(Conf conf)
        {
            MongoCollection<Conf> collection = _DB.GetCollection<Conf>(Key.CONF);
            var query = Query<Conf>.EQ(e => e._id, conf._id);
            var keyDB  = collection.FindOne(query);
            keyDB.ID = conf.ID;
            keyDB.Key = conf.Key;
            keyDB.Value = conf.Value;
            keyDB.Update = DateTime.Now;
            collection.Save(keyDB);
        }

        public void Delete(Conf conf)
        {
            MongoCollection<Conf> collection = _DB.GetCollection<Conf>(Key.CONF);
            var query = Query<Conf>.EQ(e => e._id, conf._id);
            collection.Remove(query);
        }

        public void Close()
        {
            _server.Disconnect();
        }
    }
}
