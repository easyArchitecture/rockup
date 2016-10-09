package org.zk.agent.service;

import org.zk.agent.conf.Conf;

/**
 * Created by hadoop on 16-8-19.
 */
public class Service {
    private String serviceId;

    private void init(){
        Conf conf = new Conf();
        Monitor monitor = new Monitor();
        new Thread(monitor).start();
    }
}
