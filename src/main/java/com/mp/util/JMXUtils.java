package com.mp.util;

import com.sun.management.OperatingSystemMXBean;
import lombok.extern.slf4j.Slf4j;

import javax.management.MBeanServerConnection;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import javax.management.openmbean.CompositeDataSupport;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by panmin on 16-12-7.
 */
@Slf4j
public class JMXUtils {
    private static final String JMX_DEFAULT_HOST = "localhost";
    private static final String JMX_DEFAULT_PORT = "1099";
    private static MBeanServerConnection mbsc = null;

    static {
        initConnection(JMX_DEFAULT_HOST,JMX_DEFAULT_PORT);
    }

    public static void initConnection(String hostName, String port) {
        String jmxURL = "service:jmx:rmi:///jndi/rmi://" + hostName + ":" + port + "/jmxrmi";
        try {
            JMXServiceURL serviceURL = new JMXServiceURL(jmxURL);
            Map map = new HashMap();
            String[] credentials = new String[]{"monitorRole", "QED"};
            map.put("jmx.remote.credentials", credentials);
            JMXConnector connector = JMXConnectorFactory.connect(serviceURL, map);
            mbsc = connector.getMBeanServerConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Heap MBean List
     */
    public static void getMBeanList() {
        //heap
        try {
            for (int i = 0; i < mbsc.getDomains().length; i++) {
                System.out.println(mbsc.getDomains()[i]);
            }

            Set MBeanset = mbsc.queryMBeans(null, null);
            System.out.println("MBeanset.size() : " + MBeanset.size());
            Iterator MBeansetIterator = MBeanset.iterator();
            while (MBeansetIterator.hasNext()) {
                ObjectInstance objectInstance = (ObjectInstance) MBeansetIterator.next();
                ObjectName objectName = objectInstance.getObjectName();
                String canonicalName = objectName.getCanonicalName();
                System.out.println("canonicalName : " + canonicalName);
                if (canonicalName.equals("Catalina:host=localhost,type=Cluster")) {
                    // Get details of cluster MBeans
                    System.out.println("Cluster MBeans Details:");
                    System.out.println("=========================================");
                    //getMBeansDetails(canonicalName);
                    String canonicalKeyPropList = objectName.getCanonicalKeyPropertyListString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * system information
     */
    public static Map<String, Object> getSystemInfo() {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            ObjectName runtimeObjName = new ObjectName("java.lang:type=Runtime");
            String vmVendor = (String) mbsc.getAttribute(runtimeObjName, "VmVendor");
            String vmName = (String) mbsc.getAttribute(runtimeObjName, "VmName");
            String vmVersion = (String) mbsc.getAttribute(runtimeObjName, "VmVersion");
            Date startTime = new Date((Long) mbsc.getAttribute(runtimeObjName, "StartTime"));
            Long timeSpan = (Long) mbsc.getAttribute(runtimeObjName, "Uptime");
            result.put("vmVendor", vmVendor);
            result.put("vmName", vmName);
            result.put("vmVersion", vmVersion);
            result.put("startTime", startTime);
            result.put("timeSpan", timeSpan);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * JVM heap information
     */
    public static Map<String, Double> getJVMMemoryInfo() {
        Map<String, Double> result = new HashMap<String, Double>();
        try {
            result = new HashMap<String, Double>();
            //堆使用率
            ObjectName heapObjName = new ObjectName("java.lang:type=Memory");
            MemoryUsage heapMemoryUsage = MemoryUsage.from((CompositeDataSupport) mbsc.getAttribute(heapObjName, "HeapMemoryUsage"));
            long commitMemory = heapMemoryUsage.getCommitted();
            long usedMemory = heapMemoryUsage.getUsed();
            double heapUsage = (double) usedMemory * 100 / commitMemory;
            result.put("heapUsage", heapUsage);

            //非堆使用率
            MemoryUsage nonHeapMemoryUsage = MemoryUsage.from((CompositeDataSupport) mbsc.getAttribute(heapObjName, "NonHeapMemoryUsage"));
            long nonCommitMemory = nonHeapMemoryUsage.getCommitted();
            long nonUsedMemory = nonHeapMemoryUsage.getUsed();
            double nonHeapUsage = (double) nonUsedMemory * 100 / nonCommitMemory;
            result.put("nonHeapUsage", nonHeapUsage);

            //Survivor使用率
            ObjectName survivorObjName = new ObjectName("java.lang:type=MemoryPool,name=PS Survivor Space");
            MemoryUsage survivorGenUsage = MemoryUsage.from((CompositeDataSupport) mbsc.getAttribute(survivorObjName, "Usage"));
            long survivorCommitted = survivorGenUsage.getCommitted();//Survivor堆大小
            long survivorUsed = survivorGenUsage.getUsed();
            double survivorUsage = (double) survivorUsed * 100 / survivorCommitted;
            result.put("survivorUsage", survivorUsage);

            //Eden区使用率
            ObjectName edenObjName = new ObjectName("java.lang:type=MemoryPool,name=PS Eden Space");
            MemoryUsage edenGenUsage = MemoryUsage.from((CompositeDataSupport) mbsc.getAttribute(edenObjName, "Usage"));
            long edenCommitted = edenGenUsage.getCommitted();//Survivor堆大小
            long edenUsed = edenGenUsage.getUsed();
            double edenUsage = (double) edenUsed * 100 / edenCommitted;
            result.put("edenUsage", edenUsage);

            //Old堆使用率
            ObjectName oldObjName = new ObjectName("java.lang:type=MemoryPool,name=PS Old Gen");
            MemoryUsage oldGenUsage = MemoryUsage.from((CompositeDataSupport) mbsc.getAttribute(oldObjName, "Usage"));
            long oldCommitted = oldGenUsage.getCommitted();//老年堆大小
            long oldUsed = oldGenUsage.getUsed();
            double oldUsage = (double) oldUsed * 100 / oldCommitted;
            result.put("oldUsage", oldUsage);

            //Perm堆使用率
            ObjectName permObjName = new ObjectName("java.lang:type=MemoryPool,name=PS Perm Gen");
            MemoryUsage permGenUsage = MemoryUsage.from((CompositeDataSupport) mbsc.getAttribute(permObjName, "Usage"));
            long committed = permGenUsage.getCommitted();//持久堆大小
            long used = permGenUsage.getUsed();
            double permUsage = (double) used * 100 / committed;
            result.put("permUsage", permUsage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Session information
     */
    public static List<Map<String, String>> getSessionInfo() {
        List<Map<String, String>> result = new ArrayList<Map<String, String>>();
        try {
            //------------------ Session ---------------
            ObjectName managerObjName = new ObjectName("Catalina:type=Manager,*");
            Set<ObjectName> set = mbsc.queryNames(managerObjName, null);
            Map<String, String> map = null;
            for (ObjectName obj : set) {
                map = new HashMap<String, String>();
                ObjectName objectName = new ObjectName(obj.getCanonicalName());
                map.put("path", obj.getKeyProperty("path"));
                map.put("activeSessions", (String) mbsc.getAttribute(objectName, "maxActiveSessions"));
                map.put("maxActiveSessions", (String) mbsc.getAttribute(objectName, "activeSessions"));
                map.put("sessionCounter", (String) mbsc.getAttribute(objectName, "sessionCounter"));
                result.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * get thread information
     *
     * @return
     */
    public static List<Map<String, Object>> getThreadInfo() {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        try {
            ObjectName threadPoolObjName = new ObjectName("Catalina:type=ThreadPool,*");
            Set<ObjectName> set = mbsc.queryNames(threadPoolObjName, null);
            Map<String, Object> map = null;
            for (ObjectName obj : set) {
                map = new HashMap<String, Object>();
                ObjectName objectName = new ObjectName(obj.getCanonicalName());
                map.put("name", obj.getKeyProperty("name"));
                map.put("maxThreads", mbsc.getAttribute(objectName, "maxThreads"));
                map.put("currentThreadCount", mbsc.getAttribute(objectName, "currentThreadCount"));
                map.put("currentThreadsBusy", mbsc.getAttribute(objectName, "currentThreadsBusy"));
                result.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * get cpu information
     *
     * @return
     */
    public static double getCpuUsage() {
        double cpuUsage = 0L;
        try {
            OperatingSystemMXBean opMXbean =
                    ManagementFactory.newPlatformMXBeanProxy(mbsc,
                            ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME, OperatingSystemMXBean.class);
            long start = System.currentTimeMillis();
            long startT = opMXbean.getProcessCpuTime();
            // Collect data every 1 seconds
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                log.error("Interrupted Exception occurred while Cpu collector sleeping...");
            }
            long end = System.currentTimeMillis();
            long endT = opMXbean.getProcessCpuTime();
            cpuUsage = (endT - startT) / 1000000.0 / (end - start) / opMXbean.getAvailableProcessors();
//            System.out.println(ratio);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cpuUsage;
    }

    /**
     * format time span
     *
     * @param span
     * @return
     */
    public static String formatTimeSpan(long span) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date(span));
    }


    public static void main(String[] args) {
        initConnection("localhost", "1099");
        getMBeanList();
        getSystemInfo();
        getSessionInfo();
        getThreadInfo();
        getCpuUsage();
        getJVMMemoryInfo();
    }
}
