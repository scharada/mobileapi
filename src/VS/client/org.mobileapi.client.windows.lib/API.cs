using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using WebSocket4Net;


// http://websocket4net.codeplex.com/downloads/get/454203

namespace org.mobileapi.client.windows.lib
{
    public class API
    {
        private String m_uri;

        private WebSocket websocket;

        public void Configure(String uri)
        {
            m_uri = uri;
        }

        public void start()
        {
            websocket = new WebSocket(m_uri);
            websocket.Opened += new EventHandler(websocket_Opened);
            websocket.Error += websocket_Error;
            websocket.Closed += websocket_Closed;
            websocket.MessageReceived += websocket_MessageReceived;

            websocket.Open();
        }

        void websocket_MessageReceived(object sender, MessageReceivedEventArgs e)
        {
            Console.WriteLine("websocket_MessageReceived");
        }

        void websocket_Closed(object sender, EventArgs e)
        {
            Console.WriteLine("websocket_Closed");
        }

        void websocket_Error(object sender, SuperSocket.ClientEngine.ErrorEventArgs e)
        {
            Console.WriteLine("websocket_Error");
        }

        private void websocket_Opened(object sender, EventArgs e)
        {
            Console.WriteLine("websocket_Opened");

            Send("Hello from windows");
        }

        public void Start()
        {
            Console.WriteLine("Start");
        }

        public void Send(String msg)
        {
            websocket.Send(msg); 
        }

    }
}
