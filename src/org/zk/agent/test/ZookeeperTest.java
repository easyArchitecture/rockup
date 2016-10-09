package org.zk.agent.test;

import org.zk.agent.conf.Conf;
import org.zk.agent.zookeeper.ZookeeperOper;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.data.Stat;

/**
 * Created by hadoop on 16-8-19.
 */
public class ZookeeperTest {

    public static void main(String[] args) {
        Conf conf = new Conf();
        ZookeeperOper zookeeperOper = new ZookeeperOper();
        try {
            Stat stat=zookeeperOper.exists("/abc");
            System.out.println(stat);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
