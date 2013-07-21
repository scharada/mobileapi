package com.example.org.mobileapi.client.android.example;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import com.codebutler.android_websockets.WebSocketClient;
import com.codebutler.android_websockets.WebSocketClient.Listener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements Listener {
	
	//public static final String GATEWAY = "ws://gate.mobileapi.org:8080/org.mobileapi.server.api/portal";
	
	public static final String GATEWAY = "ws://gate.mobileapi.org";
	
	private String TAG = "MainActivity";
	private static Handler mHandler;
	 
	private WebSocketClient client ;
	private List<BasicNameValuePair> header = new ArrayList<BasicNameValuePair>();
	
	private String messages = "";
	private EditText tbxMessage;
	private TextView tbxMessages;
	private TextView btnSend;
	private TextView btnClear;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		tbxMessage = (EditText)findViewById(R.id.tbxMsg);
		tbxMessages = (TextView)findViewById(R.id.tbxMessages);
		btnSend = (TextView)findViewById(R.id.btnSend);
		btnClear = (TextView)findViewById(R.id.btnClear);
		
		 mHandler = new Handler(Looper.getMainLooper()) {
			 @Override
	            public void handleMessage(Message inputMessage) {
				 tbxMessages.setText(messages);
				 
				 super.handleMessage(inputMessage);
			 }
		 };
				
		URI uri = null;
		try {
			uri = new URI(GATEWAY);
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
    	addText("Connected");
    	client.send("Hello from Android");
    }
    
    public void onMessage(String message)
    {
    	Log.d(TAG, "onMessage " + message);
    	 addText(message);
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
    
    public void onClear(View v)
    {
    	messages = "";
    	mHandler.sendEmptyMessage(0);
    }
    
    public void onSend(View v)
    {
    	String msg = tbxMessage.getText().toString();
    	client.send(msg);
    }
    
    public void addText(String msg)
    {
    	messages = msg + "\r\n"  + messages;
    	mHandler.sendEmptyMessage(0);
    }
}
