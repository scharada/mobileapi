using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Shapes;
using Microsoft.Phone.Controls;

using org.mobileapi.client.windows.lib;
using System.IO.IsolatedStorage;
using Microsoft.Phone.Shell;

namespace org.mobileapi.client.windows.example
{
    public partial class MainPage : PhoneApplicationPage, MsgListener
    {

        //public const String GATEWAY = "ws://gate.mobileapi.org:8080/org.mobileapi.server.api/portal";

        public const String GATEWAY = "ws://gate.mobileapi.org";

        API api;
        String messages =  "";

        // Constructor
        public MainPage()
        {

            InitializeComponent();

            var settings = IsolatedStorageSettings.ApplicationSettings;
            api = new API(this);
            api.Configure(GATEWAY);
            api.start();
        }

        public void addMessage(String msg)
        {
            messages = msg + Environment.NewLine +  messages;
            
        }

        void Refresh()
        {
            tbxBlock.Text = messages;
        }



        private void btnClear_Click_1(object sender, RoutedEventArgs e)
        {
            messages = "";
            Refresh();
        }

        private void btnSend_Click(object sender, RoutedEventArgs e)
        {
            api.Send(tbxMsg.Text);
        }



        public void OnMessage(string msg)
        {
            addMessage(msg);
            Dispatcher.BeginInvoke(() =>
            {
                Refresh();
            });
        }
    }
}