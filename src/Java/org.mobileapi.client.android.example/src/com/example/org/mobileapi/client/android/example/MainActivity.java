package com.example.org.mobileapi.client.android.example;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;

import com.codebutler.android_websockets.WebSocketClient;
import com.codebutler.android_websockets.WebSocketClient.Listener;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity implements Listener {
	
	List<BasicNameValuePair> header = new ArrayList<BasicNameValuePair>();
	
	String TAG = "MainActivity";
	WebSocketClient client ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		URI uri = null;
		try {
			uri = new URI("ws://etiamo.com:8080/org.mobileapi.server.api/portal");
		} catch (URISyntaxException e) {

			Log.e(TAG, e.getMessage());
		}
		 client = new WebSocketClient(uri, this, header);
		 
		 Log.d(TAG, client.toString());
		 
		client.connect();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

    public void onConnect()
    {
    	Log.d(TAG, "onConnect");
    	client.send("Hello from Android");
    }
    
    public void onMessage(String message)
    {
    	Log.d(TAG, "onMessage");
    }
    
    public void onMessage(byte[] data)
    {
    	Log.d(TAG, "onMessage");
    }
    
    public void onDisconnect(int code, String reason)
    {
    	Log.d(TAG, "onDisconnect");
    }
    
    public void onError(Exception error)
    {
    	Log.d(TAG, "onError " + error.getMessage());
    }
}
