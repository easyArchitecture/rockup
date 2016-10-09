package org.zk.agent.zookeeper.watcher;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * Created by hadoop on 16-8-19.
 */
public class ExistsWatcher implements Watcher {
    @Override
    public void process(WatchedEvent event) {
        System.out.println(event);
    }
}
