package org.zk.master;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.zk.zkapi.JavaApiSample;

import java.util.ArrayList;

/**
 * Created by jixu on 16-7-29.
 */
public class GetChildWatcher implements Watcher {
    @Override
    public void process(WatchedEvent watchedEvent) {
        switch (watchedEvent.getPath()) {
            case JavaApiSample.ZK_PATH + Master.ZK_PATH1: {
                ArrayList<String> list = (ArrayList<String>) Master.sample.getChildList(JavaApiSample.ZK_PATH + Master.ZK_PATH1);
                ArrayList<String> temp = Master.nodelist1;
                Master.nodelist1 = (ArrayList<String>)list.clone();
                if (list.size() > temp.size()) {
                    list.removeAll(temp);
                    System.out.println("增加节点： " + watchedEvent.getPath() + "/" + list.get(0));
                } else if (list.size() < temp.size()) {
                    Master.nodelist1 = list;
                    System.out.println("丢失节点： " + watchedEvent.getPath() + "/" + temp.get(0));
                }
            }
            break;
            case JavaApiSample.ZK_PATH + Master.ZK_PATH2: {
                ArrayList<String> list = (ArrayList<String>) Master.sample.getChildList(JavaApiSample.ZK_PATH + Master.ZK_PATH2);
                ArrayList<String> temp = Master.nodelist2;
                Master.nodelist2 = (ArrayList<String>)list.clone();
                if (list.size() > temp.size()) {
                    list.removeAll(temp);
                    System.out.println("需要更新： " + watchedEvent.getPath() + "/" + list.get(0));
                } else if (list.size() < temp.size()) {
                    temp.removeAll(list);
                    System.out.println("更新完成： " + watchedEvent.getPath() + "/" + temp.get(0));
                    Master.sample.writeData(JavaApiSample.ZK_PATH + "/update",Master.nodelist2.get(0));
                }
            }
            break;
            case JavaApiSample.ZK_PATH + Master.ZK_PATH3: {
                ArrayList<String> list = (ArrayList<String>) Master.sample.getChildList(JavaApiSample.ZK_PATH + Master.ZK_PATH3);
                ArrayList<String> temp = Master.nodelist3;
                Master.nodelist3 = (ArrayList<String>)list.clone();
                if (list.size() < temp.size()) {
                    list.removeAll(temp);
                    System.out.println(watchedEvent.getPath() + "/" + list.get(0) + "更新完成！");
                    Master.sample.createPath(JavaApiSample.ZK_PATH + Master.ZK_PATH2 + "/" + list.get(0),list.get(0));
                }
            }
            break;
        }

    }
}
