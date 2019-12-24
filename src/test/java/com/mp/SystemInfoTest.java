package com.mp;

import com.mp.system.SystemInfoUtil;
import org.junit.Test;

/**
 * Created by panmin on 16-12-20.
 */
public class SystemInfoTest {
    @Test
    public void systemInfoTest(){
        System.out.println("cpuUsage: " + SystemInfoUtil.cpuUsage());
        System.out.println("memoryUsage: " + SystemInfoUtil.memoryUsage());
        System.out.println("partition: " + SystemInfoUtil.getPartitionUsage("/data"));
        System.out.println("HardDisk: " + SystemInfoUtil.getHardDiskIOPercent());
        System.out.println("NetWorking" + SystemInfoUtil.getNetworkSpeed());
    }
}
