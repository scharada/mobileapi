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
    // http://docs.mongodb.org/ecosystem/tutorial/use-csharp-driver/
    public class UserService
    {

        private MongoClient _MongoClient;
        private MongoDatabase _DB;
        private bool _IsDBLogon;
        private int _DBLogonCount;
        private MongoServer _server;

        public UserService()
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

        public User Read(string email)
        {
            MongoCollection<User> collection = _DB.GetCollection<User>(Key.USER);
            var query = Query<User>.EQ(e => e.Email, email);
            return collection.FindOne(query);
        }

        public bool Exists(string email)
        {
            MongoCollection<User> collection  = _DB.GetCollection<User>(Key.USER);
            var query = Query<User>.EQ(e => e.Email, email);
            foreach (User u in collection.Find(query))
            {
                return true;
            }
            return false;
        }

        public void Create(User user)
        {
            if (Exists(user.Email))
            {
                return;
            }
            MongoCollection<User> collection  = _DB.GetCollection<User>(Key.USER);
            collection.Insert(user);
        }

        public void Update(User user)
        {
            MongoCollection<User> collection = _DB.GetCollection<User>(Key.USER);
            var query = Query<User>.EQ(e => e.Email, user.Email);
            var userDB  = collection.FindOne(query);
            userDB.Addr0 = user.Addr0;
            userDB.Addr1 = user.Addr1;
            userDB.appIDS = user.appIDS;
            userDB.City = user.City;
            userDB.Country = user.Country;
            userDB.County = user.County;
            userDB.Email = user.Email;
            userDB.Givenname = user.Givenname;
            userDB.ID = user.ID;
            userDB.Language = user.Language;
            userDB.MSISDN = user.MSISDN;
            userDB.Name = user.Name;
            userDB.Postcode = user.Postcode;
            userDB.Pwd = user.Pwd;
            userDB.Status = user.Status;
            userDB.Update = DateTime.Now;
            collection.Save(userDB);
        }

        public void Delete(User user )
        {
            MongoCollection<User> collection = _DB.GetCollection<User>(Key.USER);
            var query = Query<User>.EQ(e => e.ID, user.ID);
            collection.Remove(query);
        }

        public void Close()
        {
            _server.Disconnect();
        }
    }
}
