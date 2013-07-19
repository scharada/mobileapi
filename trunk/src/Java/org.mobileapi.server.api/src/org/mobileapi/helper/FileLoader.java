package org.mobileapi.helper;

public class FileLoader {

    public static String ServerPath;

    public String Load(String filename)
    {
        String path = ServerPath + filename;
        
        /*
        StreamReader reader = File.OpenText(path);
        string responseFromServer = reader.ReadToEnd();
        Console.WriteLine(responseFromServer);
        reader.Close();
        return responseFromServer;
        */
        
        return "";
    }
}
