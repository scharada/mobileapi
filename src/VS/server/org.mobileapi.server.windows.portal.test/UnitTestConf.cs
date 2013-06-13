using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using org.mobileapi.server.windows.shared;
using org.mobileapi.server.windows.shared.db;


namespace org.mobileapi.server.windows.portal.test
{
     [TestClass]
    public class UnitTestConf
    {
        Guid _confAppID;
        ConfService _service;
        private string TESTKEY = "TESTKEY";
        private string TESTVALUE = "TESTVALUE";

        [TestMethod]
        public void Test_ConfService()
        {
            _service = new ConfService();
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
            Conf conf = new Conf();
            conf.AppID = _confAppID;
            conf.Key = TESTKEY;
            conf.Value = TESTVALUE;
            conf.Create = DateTime.Now;
            conf.Update = conf.Create;
            _service.Create(conf);
        }

        public void TestExists()
        {
            Assert.IsTrue(_service.Exists(_confAppID, TESTKEY));

        }

        public void TestRead()
        {
            Conf conf = _service.Read(_confAppID, TESTKEY);
            Assert.IsNotNull(conf);
        }

        public void TestUpdate()
        {
            Conf conf = _service.Read(_confAppID, TESTKEY);
            Assert.IsNotNull(conf);
            conf.Value = "NEWVAL";
            _service.Update(conf);
        }

        public void TestDelete()
        {
            Conf conf = _service.Read(_confAppID, TESTKEY);
           _service.Delete(conf);
        }
    }
}
