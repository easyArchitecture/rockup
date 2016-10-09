package org.zk.agent.conf;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Created by hadoop on 16-8-17.
 */
public class Conf {

    static String profilepath="/home/hadoop/agent/conf.properties";
    private static Properties props = new Properties();
    private static String host;
    private static int port;
    private static String redishost;
    private static int redisport;
    private static String zookeeperhost;
    private static int zooSessionTimeout;
    private static String serviceId;


    public static int getZooSessionTimeout() {
        return zooSessionTimeout;
    }



    public static String getHost() {
        return host;
    }

    public static int getPort() {
        return port;
    }

    public static String getRedishost() {
        return redishost;
    }

    public static int getRedisport() {
        return redisport;
    }

    public static String getZookeeperhost() {
        return zookeeperhost;
    }



    public  Conf() {
        try {
            props.load(new FileInputStream(profilepath));
            this.host = props.getProperty("host");
            if(props.getProperty("port")!=null){
                this.port = Integer.valueOf(props.getProperty("port"));
            }
            this.redishost = props.getProperty("redishost");
            if(props.getProperty("redisport")!=null){
                this.redisport = Integer.valueOf(props.getProperty("redisport"));
            }
            this.zookeeperhost = props.getProperty("zookeeperhost");
            if(props.getProperty("zooSessionTimeout")!=null){
                this.zooSessionTimeout = Integer.valueOf(props.getProperty("zooSessionTimeout"));
            }
            this.serviceId = props.getProperty("serviceId");
        } catch (IOException e) {

            e.printStackTrace();
        }
    }


}
