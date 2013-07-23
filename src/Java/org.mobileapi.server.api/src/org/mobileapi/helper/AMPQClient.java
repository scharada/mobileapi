package org.mobileapi.helper;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.inject.Named;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

// http://www.rabbitmq.com/api-guide.html

public class AMPQClient  extends Thread {

	private Connection _conn;
	private Channel _channel;
	private Channel _channelReceive;
	
	private String host = "localhost";
	private int port = 5672;
	private String vhost = "/";
	private String username ="guest";
	private String pwd = "guest";

	public void configure( String host, int port, String vhost, String username, String pwd)
	{
		this.host = host;
		this.port = port;
		this.vhost = vhost;
		this.username = username;
		this.pwd = pwd;
	}
	
	public void startup()
	{
		ConnectionFactory factory = new ConnectionFactory();
		try {
			factory.setUsername(username);
			factory.setPassword(pwd);
			factory.setVirtualHost(vhost);
			factory.setHost(host);
			factory.setPort(port);
		
			_conn = factory.newConnection();
			_channel = _conn.createChannel();
			System.out.println("_conn "  + _conn);
			
			// send test message
			send("broker0","Test Message1");		
			send("broker0","Test Message2");		
			send("broker0","Test Message3");		
			System.out.println("Test Message send to broker0");
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	   start();
	}
	
	public void send(String queue, String msg)
	{
		try {
			
			 System.out.println("_channel to send "  + _channel);
			if( _channel.isOpen())
			{
				System.out.println("_channel is open");
				byte[] messageBodyBytes = msg.getBytes();
				//_channel.basicPublish("amq.default", queue, null, messageBodyBytes);
				
				_channel.basicPublish("", queue, null, messageBodyBytes);

				
				System.out.println("bytew send " + messageBodyBytes.length);
			}
			else
			{
				System.out.println("_channel is closed");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run()
	{
		System.out.println("listener thread starting...");
		boolean autoAck = false;
		try {
			_channelReceive = _conn.createChannel();
			_channelReceive.basicConsume("broker0", autoAck, "",
			     new DefaultConsumer(_channelReceive) {
			         @Override
			         public void handleDelivery(String consumerTag,
			                                    Envelope envelope,
			                                    AMQP.BasicProperties properties,
			                                    byte[] body)
			             throws IOException
			         {
			             String routingKey = envelope.getRoutingKey();
			             String contentType = properties.getContentType();
			             long deliveryTag = envelope.getDeliveryTag();
			             
			             String str = new String(body, "UTF-8");
			             
			             System.out.println("Queue test found in queue broker0" + str);
			             // (process the message components here ...)
			             _channelReceive.basicAck(deliveryTag, false);
			         }
			     });
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close()
	{
		try {
			if(_channel!= null && _channel.isOpen())
			{
				_channel.close();
			}
			if(_channelReceive!= null && _channelReceive.isOpen())
			{
				_channelReceive.close();
			}
			if(_conn!= null && _conn.isOpen())
			{
				_conn.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void shutdown() {
		System.out.println("AMPQ Client shutdown : " );
		try {
			close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
