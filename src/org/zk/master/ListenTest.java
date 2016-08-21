package org.zk.master;

import org.zk.zkapi.JavaApiSample;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by jixu on 16-7-30.
 */
public class ListenTest {
    public static ArrayList<String> nodelist;
    public static void main(String[] args) throws IOException {
        JavaApiSample sample = new JavaApiSample();
        sample.createConnection(JavaApiSample.CONNECTION_STRING, JavaApiSample.SESSION_TIMEOUT);
        nodelist = (ArrayList<String>)sample.getChildList(JavaApiSample.ZK_PATH);
        sample.createNode(JavaApiSample.ZK_PATH + "/server1", "server1");
        System.in.read();
    }
}
