package org.mobileapi.helper;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Named;

import org.apache.zookeeper.*;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.data.*;

/*
 * Wrapper for  Zookeeper
 * http://zookeeper.apache.org/
 */

@Named
@Singleton
public class Zoo {
	
	public static final String BROKER0QUEUE = "/broker0/queue";
	public static final String GATE0QUEUE = "/gate0/queue";
	public static final String GATE1QUEUE = "/gate0/queue";
	

	private ZkConnector _ZkConnector;
	private ZooKeeper _ZooKeeper;
	
	private  String broker0Queue;
	
	public String get(final String path)
	{
		return broker0Queue;
	}
	
	public void set(String key, String val)
	{
		
	}
	
	public void startup() { 
		System.out.println("Zoo startup : " );
		
		// Connect to Zookeeper
		try 
		{
			_ZkConnector  = new ZkConnector();
			_ZkConnector.connect("localhost");
			_ZooKeeper = _ZkConnector.getZooKeeper();
			System.out.println("_ZooKeeper startup : "  + _ZooKeeper);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			try {
			
			_ZooKeeper.exists(BROKER0QUEUE, new Watcher() {       // Anonymous Watcher
				
			    @Override
			    public void process(WatchedEvent event) {
			       // check for event type NodeCreated
			       boolean isNodeCreated = event.getType().equals(EventType.NodeCreated);
			       // verify if this is the defined znode
			       boolean isMyPath = event.getPath().equals(BROKER0QUEUE);
			 
			       if (isNodeCreated && isMyPath) {
			    	   List<String> items = null;
					try {
						items = _ZooKeeper.getChildren(BROKER0QUEUE, null);
						 broker0Queue = items.get(0); //<strong>TODO</strong>: send an email or whatever
						 
						 
					} catch (KeeperException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    	  
			       }
			    }
			});
			

		} catch (KeeperException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("_ZooKeeper Test : "  + get(BROKER0QUEUE) );
	}

	private void shutdown() {
		System.out.println("Zoo shutdown : " );
		try {
			_ZooKeeper.close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
