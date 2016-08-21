package org.zk.waitq;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.zk.zkapi.JavaApiSample;

/**
 * Created by jixu on 16-7-30.
 */
public class ReadWatcher implements Watcher {
    @Override
    public void process(WatchedEvent watchedEvent) {
        JavaApiSample sample = new JavaApiSample();
        if(sample.readChildList(ReadWriteTest.READ_PATH).size()==0){
            sample.createNode(ReadWriteTest.WRITE_PATH+"/write2","");
            if(sample.writeChildList(ReadWriteTest.WRITE_PATH).size()==1){
                System.out.println("写");
                sample.deleteNode(ReadWriteTest.WRITE_PATH+"/write2");
            }
        }
    }
}
