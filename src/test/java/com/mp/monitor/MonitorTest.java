package com.mp.monitor;

import org.junit.Test;

/**
 * Created by panmin on 16-12-19.
 */
public class MonitorTest {

    @Test
    public void doMonitorTest(){
        DoMonitor doMonitor = new DoJvmMonitor();
        doMonitor.doCollectionsJVMMonitor();
        doMonitor.doCollectionsSystemMonitor();
    }
}
