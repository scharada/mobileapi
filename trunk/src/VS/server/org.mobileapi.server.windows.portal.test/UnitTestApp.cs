using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using org.mobileapi.server.windows.shared;
using org.mobileapi.server.windows.shared.db;
using System.Collections.Generic;

namespace org.mobileapi.server.windows.portal.test
{
     [TestClass]
    public class UnitTestApp
    {
        Guid _confAppID;
        AppService _service;
        private string NAME = "TESTAPP";
        private string DESC = "TESTAPP is a TESTAPP TESTAPP is a TESTAPP TESTAPP is a TESTAPP TESTAPP is a TESTAPP TESTAPP is a TESTAPP TESTAPP is a TESTAPP";

        [TestMethod]
        public void Test_AppService()
        {
            _service = new AppService();
            _confAppID = Guid.NewGuid();
            TestCreate();
            TestExists();
            TestRead();
            TestUpdate();
            TestDelete();
            _service.Close();
        }

        public void TestCreate()
        {
            App app = new App();
            app.ID = _confAppID;
            app.AppID = _confAppID;
            app.Name = NAME;
            app.Desc = DESC;
            app.UserIDS = new List<Guid> { Guid.NewGuid(), Guid.NewGuid(), Guid.NewGuid() };
            _service.Create(app);
        }

        public void TestExists()
        {
            Assert.IsTrue(_service.Exists(_confAppID));

        }

        public void TestRead()
        {
            App app = _service.Read(_confAppID);
            Assert.IsNotNull(app);
        }

        public void TestUpdate()
        {
            App app = _service.Read(_confAppID);
            Assert.IsNotNull(app);
            app.Name = "NEWVAL";
            _service.Update(app);
        }

        public void TestDelete()
        {
            App app = _service.Read(_confAppID);
            _service.Delete(app);
        }
    }
}
