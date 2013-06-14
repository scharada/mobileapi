using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using org.mobileapi.server.windows.shared;
using org.mobileapi.server.windows.shared.db;
using System.Collections.Generic;


namespace org.mobileapi.server.windows.portal.test
{
    [TestClass]
    public class UnitTestDevice
    {
        Guid _confAppID;
        Guid _deviceID;
        DeviceService _service;
        private string NAME = "TESTAPP";
        private string DESC = "TESTAPP is a TESTAPP TESTAPP is a TESTAPP TESTAPP is a TESTAPP TESTAPP is a TESTAPP TESTAPP is a TESTAPP TESTAPP is a TESTAPP";

        [TestMethod]
        public void Test_DeviceService()
        {
            _service = new DeviceService();
            _confAppID = Guid.NewGuid();
            _deviceID = Guid.NewGuid();

            TestCreate();
            TestExists();
            TestRead();
            TestUpdate();
            TestDelete();
            _service.Close();
        }

        public void TestCreate()
        {
            Device device = new Device();
            device.ID = _deviceID;
            device.AppID = _confAppID;
            device.Fix = 3;
            device.GPSTime = DateTime.Now;
            device.Lat = 51.321;
            device.Long = 0.49875;
            device.Pin = "12345";
            device.Sat = 3;
            device.Status = EnumDeviceStatus.ACTIVE;
            device.Token = Guid.NewGuid();
            device.User = "setByCustomer";
            _service.Create(device);
        }

        public void TestExists()
        {
            Assert.IsTrue(_service.Exists(_deviceID));

        }

        public void TestRead()
        {
            Device device = _service.Read(_deviceID);
            Assert.IsNotNull(device);
        }

        public void TestUpdate()
        {
            Device device = _service.Read(_deviceID);
            Assert.IsNotNull(device);
            device.Status = EnumDeviceStatus.BLOCKED;
            _service.Update(device);
        }

        public void TestDelete()
        {
            Device device = _service.Read(_deviceID);
            //_service.Delete(device);
        }
    }
}
