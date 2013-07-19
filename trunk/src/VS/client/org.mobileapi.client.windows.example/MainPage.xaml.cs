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
    public partial class MainPage : PhoneApplicationPage
    {
        API api;
        // Constructor
        public MainPage()
        {
            this.
            InitializeComponent();

            var settings = IsolatedStorageSettings.ApplicationSettings;
            api = new API();
            api.Configure("ws://etiamo.com:8080/org.mobileapi.server.api/portal");
            api.start();
        }


    }
}