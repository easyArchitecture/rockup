package org.zk.util;

import org.zk.zkapi.JavaApiSample;
import org.zk.master.Master;

/**
 * Created by jixu on 16-7-30.
 */
public class InitUtil {
    public static void main(String[] args) {
        JavaApiSample sample = new JavaApiSample();
        sample.createConnection(JavaApiSample.CONNECTION_STRING, JavaApiSample.SESSION_TIMEOUT);
//        sample.createPath(ReadWriteTest.READ_PATH,"");
//        sample.createPath(ReadWriteTest.WRITE_PATH,"");
        sample.createPath(JavaApiSample.ZK_PATH + Master.ZK_PATH1, "server1");
        sample.createPath(JavaApiSample.ZK_PATH + Master.ZK_PATH2, "server1");
        sample.createPath(JavaApiSample.ZK_PATH + Master.ZK_PATH3, "server1");
        sample.releaseConnection();
    }
}
