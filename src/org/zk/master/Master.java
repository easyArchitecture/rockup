package org.zk.master;

import org.zk.zkapi.JavaApiSample;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by jixu on 16-8-21.
 */
public class Master {
    public static final String ZK_PATH1 = "/server1";//节点上下线
    public static final String ZK_PATH2 = "/server2";//进行更新
    public static final String ZK_PATH3 = "/server3";//更新完成
    public static ArrayList<String> nodelist1;//上下线
    public static ArrayList<String> nodelist2;//更新中
    public static ArrayList<String> nodelist3;//更新完成
    public static JavaApiSample sample = new JavaApiSample();
    public static void main(String[] args) throws IOException {
        sample.createConnection(JavaApiSample.CONNECTION_STRING, JavaApiSample.SESSION_TIMEOUT);
        nodelist1 = (ArrayList<String>)sample.getChildList(JavaApiSample.ZK_PATH + ZK_PATH1);
        for(String a : nodelist1){
            sample.createPath(JavaApiSample.ZK_PATH + ZK_PATH2 + "/" + a,a);
        }
        nodelist2 = (ArrayList<String>)sample.getChildList(JavaApiSample.ZK_PATH + ZK_PATH2);
        nodelist3 = (ArrayList<String>)sample.getChildList(JavaApiSample.ZK_PATH + ZK_PATH3);
        System.out.println(nodelist2.size());
        sample.createNode(JavaApiSample.ZK_PATH + "/update", nodelist2.get(0));
        System.in.read();
    }
}
