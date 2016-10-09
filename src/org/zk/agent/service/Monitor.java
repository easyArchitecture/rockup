package org.zk.agent.service;

import org.zk.agent.jedis.JedisOper;
import org.hyperic.sigar.Cpu;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

/**
 * Created by hadoop on 16-8-18.
 */
public class Monitor implements Runnable {
    public Monitor() {
        sigar = new Sigar();
        jedisOper = new JedisOper();
    }

    private Sigar sigar ;
    private JedisOper jedisOper;


    @Override
    public void run() {
        try {
            while (true){
                Cpu cpu = sigar.getCpu();
                Mem mem = sigar.getMem();

                 jedisOper.set("内存总量",String.valueOf(mem.getTotal() / 1024L));

            }

        } catch (SigarException e) {
            e.printStackTrace();
        }

    }


}
