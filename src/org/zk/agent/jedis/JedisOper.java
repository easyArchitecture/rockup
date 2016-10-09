package org.zk.agent.jedis;

import org.zk.agent.conf.Conf;
import redis.clients.jedis.Jedis;

/**
 * Created by hadoop on 16-8-16.
 */
public class JedisOper   {

    private String host;
    private int port;
    private Jedis jedis;

    public JedisOper() {
        this.host = Conf.getRedishost();
        this.port = Conf.getRedisport();
        createJedisConn();
    }

    public Jedis createJedisConn() {
        jedis = new Jedis(host, port);
        return jedis;
    }


    public void set(String key,String value) {
        String s = jedis.set(key,value);
    }


}
