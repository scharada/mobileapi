using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using org.mobileapi.server.windows.shared;
using org.mobileapi.server.windows.shared.db;
using System.Collections.Generic;


namespace org.mobileapi.server.windows.portal.test
{
     [TestClass]
    public class UnitTestChannel
    {
         Guid _channelID;
         Guid _confAppID;
       ChannelService _service;
        private string NAME = "TESTAPP";
        private string DESC = "TESTAPP is a TESTAPP TESTAPP is a TESTAPP TESTAPP is a TESTAPP TESTAPP is a TESTAPP TESTAPP is a TESTAPP TESTAPP is a TESTAPP";

        [TestMethod]
        public void Test_ChannelService()
        {
            _service = new ChannelService();
            _channelID = Guid.NewGuid();
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
            Channel channel = new Channel();
            channel.ID = _channelID;
            channel.Name = "MyChannel";
            channel.AppID = _confAppID;
            channel.AddressMap = "myMapfile";
            channel.AddressPath = "//*some/xpath/to/find/msisdnorso";
            channel.AddressPermission = EnumAddressPermission.BACKEND;
            channel.AddressType = EnumAddressType.XPATH;
            channel.CallBackPwd = "secret";
            channel.CallBackURL = "http://mybackendserver.com/callback.svc";
            channel.CallBackUser = "mobileapiUser";
            channel.MapIn = "MyXSLTTransformRequest.xslt";
            channel.MapInType = EnumMapType.XSLT;
            channel.MapOut = "MyXSLTTransformResponse.xslt";
            channel.MapOutType = EnumMapType.XSLT;
            channel.Priority = EnumPriority.NORMAL;
            channel.Retries = 3;
            channel.TTL = 50000;
            _service.Create(channel);
        }

        public void TestExists()
        {
            Assert.IsTrue(_service.Exists(_channelID));

        }

        public void TestRead()
        {
            Channel channel = _service.Read(_channelID);
            Assert.IsNotNull(channel);
        }

        public void TestUpdate()
        {
            Channel channel = _service.Read(_channelID);
            Assert.IsNotNull(channel);
            channel.Name = "NewName";
            _service.Update(channel);
        }

        public void TestDelete()
        {
            Channel channel = _service.Read(_channelID);
            _service.Delete(channel);
        }
    }
}
