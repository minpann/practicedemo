package com.mp.monitor;

/**
 * Created by panmin on 16-12-19.
 */
public class DoJvmMonitor implements DoMonitor {

    @Override
    public void doCollectionsJVMMonitor() {
        System.out.println("start collections jvm info...");
    }

    @Override
    public void doCollectionsSystemMonitor() {
        System.out.println("start collections system info...");
    }
}
