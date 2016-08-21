package org.zk.waitq;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.zk.zkapi.JavaApiSample;

/**
 * Created by jixu on 16-7-30.
 */
public class WriteWatcher implements Watcher {
    @Override
    public void process(WatchedEvent watchedEvent) {
        JavaApiSample sample = new JavaApiSample();
        if(sample.writeChildList(ReadWriteTest.WRITE_PATH).size()==1){
            System.out.println("写");
            sample.deleteNode(ReadWriteTest.WRITE_PATH+"/write2");
        }else if(sample.writeChildList(ReadWriteTest.WRITE_PATH).size()==0){
            System.out.println("读");
            sample.deleteNode(ReadWriteTest.READ_PATH+"/read2");
        }
    }
}
