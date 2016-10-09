package org.zk.agent.zookeeper;

import org.zk.agent.conf.Conf;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by hadoop on 16-8-17.
 */
public class ZookeeperBasic implements Watcher {
    private String hosts;
    private CountDownLatch countDownLatch=new CountDownLatch(1);
    ZooKeeper zooKeeper ;

    public void setHosts(String hosts) {
        this.hosts = hosts;
    }

    public ZookeeperBasic() {
        this.hosts= Conf.getZookeeperhost();
    }

    public ZooKeeper createZoo() {
        try {
            zooKeeper = new ZooKeeper(hosts,Conf.getZooSessionTimeout(),this);
            countDownLatch.await();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return zooKeeper;
    }

    @Override
    public void process(WatchedEvent event) {
        if(event.getState()== Event.KeeperState.SyncConnected){
            countDownLatch.countDown();
        }
    }




}
