using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using org.mobileapi.server.windows.shared;
using org.mobileapi.server.windows.shared.db;

namespace org.mobileapi.server.windows.portal.test
{
    [TestClass]
    public class UnitTestUser
    {
        Guid _userGuid;
        UserService _service ;

        [TestMethod]
        public void Tests()
        {
            _service = new UserService();
            TestCreate();
            TestExists();
            TestRead();
            TestUpdate();
            TestDelete();
            _service.Close();
        }

        public void TestCreate()
        {
            _userGuid = Guid.NewGuid();

            UserService service = new UserService();

            User user = new User();
            user.ID = _userGuid;
            user.Name = "name";
            user.Addr0 = "Addr0";
            user.Addr1 = "Addr1";
            user.appIDS = new System.Collections.Generic.List<Guid>() { Guid.NewGuid(), Guid.NewGuid(), Guid.NewGuid() };
            user.City = "City";
            user.Country = "Country";
            user.County = "County";
            user.Create = DateTime.Now;
            user.Email = "test@test.com";
            user.Givenname = "Givenname";
            user.Language = "en";
            user.MSISDN = "41792864631";
            user.Postcode = "8004";
            user.Pwd = "secret";
            user.Status = EnumUserStatus.NEW;
            user.Token = Guid.NewGuid();
            user.Update = DateTime.Now;
            service.Create(user);
        }


        public void TestExists()
        {
            
            Assert.IsTrue(_service.Exists("test@test.com"));
        }


        public void TestRead()
        {
             User user = _service.Read("test@test.com");

             Assert.IsNotNull(user);
             _userGuid = user.ID;
        }

        public void TestUpdate()
        {

            User user = _service.Read("test@test.com");
            user.Status = EnumUserStatus.ACTIVE;
            _service.Update(user);
        }

        public void TestDelete()
        {

            User user = _service.Read("test@test.com");
            user.Status = EnumUserStatus.ACTIVE;
            _service.Delete(user);
        }

    }
}
