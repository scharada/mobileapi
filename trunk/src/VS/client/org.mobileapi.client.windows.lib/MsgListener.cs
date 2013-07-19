using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace org.mobileapi.client.windows.lib
{
    public interface MsgListener
    {
        void OnMessage(String msg);
    }
}
