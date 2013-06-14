using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;

namespace org.mobileapi.server.windows.shared
{
    public class FileLoader
    {
        public static string ServerPath;

        public string Load(String filename)
        {
            string path = ServerPath + filename;
            StreamReader reader = File.OpenText(path);
            string responseFromServer = reader.ReadToEnd();
            Console.WriteLine(responseFromServer);
            reader.Close();
            return responseFromServer;
        }
    }
}
