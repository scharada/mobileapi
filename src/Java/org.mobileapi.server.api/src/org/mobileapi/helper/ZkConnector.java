package org.mobileapi.helper;

import java.io.IOException;

import org.apache.zookeeper.*;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper.States;

public class ZkConnector {

	// ZooKeeper Object
    ZooKeeper zooKeeper;
 
    // To block any operation until ZooKeeper is connected. It's initialized
    // with count 1, that is, ZooKeeper connect state.
    java.util.concurrent.CountDownLatch connectedSignal = new java.util.concurrent.CountDownLatch(1);
 
    /**
     * Connects to ZooKeeper servers specified by hosts.
     *
     * @param hosts
     * @throws IOException
     * @throws InterruptedException
     */
    public void connect(String hosts) throws IOException, InterruptedException {
    zooKeeper = new ZooKeeper(
                hosts, // ZooKeeper service hosts
                5000,  // Session timeout in milliseconds
        // Anonymous Watcher Object
        new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                // release lock if ZooKeeper is connected.
                if (event.getState() == KeeperState.SyncConnected) {
                    connectedSignal.countDown();
                }
                }
            }
    );
    connectedSignal.await();
    }
 
    /**
     * Closes connection with ZooKeeper
     *
     * @throws InterruptedException
     */
    public void close() throws InterruptedException {
    zooKeeper.close();
    }
 
    /**
     * @return the zooKeeper
     */
    public ZooKeeper getZooKeeper() {
        // Verify ZooKeeper's validity
        if (null == zooKeeper || !zooKeeper.getState().equals(States.CONNECTED)){
        throw new IllegalStateException ("ZooKeeper is not connected.");
        }
        return zooKeeper;
    }
}
