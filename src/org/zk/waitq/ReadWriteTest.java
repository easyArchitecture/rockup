package org.zk.waitq;

import org.zk.zkapi.JavaApiSample;

import java.io.IOException;

/**
 * Created by jixu on 16-7-30.
 */
public class ReadWriteTest {
    public static final String READ_PATH = "/read";
    public static final String WRITE_PATH = "/write";
    static JavaApiSample sample = new JavaApiSample();
    public static void main(String[] args) throws IOException {
        sample.createConnection(JavaApiSample.CONNECTION_STRING, JavaApiSample.SESSION_TIMEOUT);
        sample.createNode(READ_PATH + "/read1", "");
        sample.createNode(WRITE_PATH + "/write1", "");
        write();
        //read();
        System.in.read();
    }
    public static void write(){
        if(sample.readChildList(READ_PATH).size()==0){
            sample.createNode(ReadWriteTest.WRITE_PATH+"/write2","");
            if(sample.writeChildList(WRITE_PATH).size()==1){
                System.out.println("写");
                sample.deleteNode(WRITE_PATH+"/write2");
            }
        }
    }
    public static void read(){
        sample.createNode(ReadWriteTest.READ_PATH+"/read2","");
        if(sample.writeChildList(WRITE_PATH).size()==0){
            System.out.println("读");
            sample.deleteNode(READ_PATH+"/read2");
        }
    }
}
