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
    public class AppService
    {
        private MongoClient _MongoClient;
        private MongoDatabase _DB;
        private bool _IsDBLogon;
        private int _DBLogonCount;
        private MongoServer _server;

        public AppService()
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

        public App Read(Guid appID)
        {
            MongoCollection<App> collection = _DB.GetCollection<App>(Key.APP);
            var query = Query<App>.EQ(e => e.AppID, appID);
            return collection.FindOne(query);
        }

        public bool Exists(Guid appID)
        {
            MongoCollection<App> collection = _DB.GetCollection<App>(Key.APP);
            var query = Query<Conf>.EQ(e => e.AppID, appID);
            foreach (App u in collection.Find(query))
            {
                return true;
            }
            return false;
        }

        public void Create(App app)
        {
            if (Exists(app.AppID))
            {
                return;
            }
            MongoCollection<App> collection = _DB.GetCollection<App>(Key.APP);
            app.Create = DateTime.Now;
            app.Update = app.Create;
            collection.Insert(app);
        }

        public void Update(App app)
        {
            MongoCollection<App> collection = _DB.GetCollection<App>(Key.APP);
            var query = Query<Conf>.EQ(e => e._id, app._id);
            var appDB = collection.FindOne(query);
            appDB.ID = app.ID;
            appDB.Name = app.Name;
            appDB.Desc = app.Desc;
            appDB.Update = DateTime.Now;
            collection.Save(appDB);
        }

        public void Delete(App app)
        {
            MongoCollection<App> collection = _DB.GetCollection<App>(Key.APP);
            var query = Query<App>.EQ(e => e._id, app._id);
            collection.Remove(query);
        }

        public void Close()
        {
            _server.Disconnect();
        }
    }
}
