package org.mobileapi.client.android.example;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import com.codebutler.android_websockets.WebSocketClient;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

// https://github.com/koush/android-websockets

public class MainActivity extends Activity {
	final String TAG = "MainActivity";
	
	
	//final String wsuri = "ws://etiamo.com:8080/org.mobileapi.server.api/portal";
	
	final String wsuri = "wss://10.214.143.199:8181/mobileapi/portal";
	
	private WebSocketClient client;

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
		// allow all SSL Certs from server
		setSecurityManager()
		
		// start websocket
        start();
        
       // client.send("hello from Android");
        
        /*
            client.send("hello!");
			client.send(new byte[] { 0xDE, 0xAD, 0xBE, 0xEF });
			client.disconnect();
         */
    }

    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
	
		// Create a trust manager that does not validate certificate chains
		TrustManager[] trustAllCerts = new TrustManager[] { 
			new X509TrustManager() {     
				public java.security.cert.X509Certificate[] getAcceptedIssuers() { 
					return null;
				} 
				public void checkClientTrusted( 
					java.security.cert.X509Certificate[] certs, String authType) {
					} 
				public void checkServerTrusted( 
					java.security.cert.X509Certificate[] certs, String authType) {
				}
			} 
		}; 
		
	private void setSecurityManager()
	{
		// Install the all-trusting trust manager
		try {
			SSLContext sc = SSLContext.getInstance("SSL"); 
			sc.init(null, trustAllCerts, new java.security.SecureRandom()); 
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} 
		catch (GeneralSecurityException e) 
		{
			Log.error(TAG, e);
		}
	}
    
    List<BasicNameValuePair> extraHeaders = Arrays.asList(
		    new BasicNameValuePair("Cookie", "session=abcd")
		);
    
    private void start() {
    	
	  client = new WebSocketClient(URI.create(wsuri), new WebSocketClient.Listener() {
		  
	    @Override
	    public void onConnect() {
	        Log.d(TAG, "Connected!");
	    }

	    @Override
	    public void onMessage(String message) {
	        Log.d(TAG, String.format("Got string message! %s", message));
	    }

	    @Override
	    public void onMessage(byte[] data) {
	       //  Log.d(TAG, String.format("Got binary message! %s", toHexString(data)));
	    }

	    @Override
	    public void onDisconnect(int code, String reason) {
	        Log.d(TAG, String.format("Disconnected! Code: %d Reason: %s", code, reason));
	    }

	    @Override
	    public void onError(Exception error) {
	        Log.e(TAG, "Error!", error);
	    }

	}, extraHeaders);

		client.connect();
    }
}
