package com.mp.kalman;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author minpan
 * @date 2021/12/11 22:08
 */
public class KalmanFilter {

    private static final Logger LOG = LoggerFactory.getLogger(com.mp.kalman.KalmanFilter.class);
    private static final Integer RSSI = 68;

    @Test
    public void KalmanTest() {
//        String row = "20010.76:63,20010.76:63,20010.76:61,20010.76:64,  20010.85:73,20010.85:71,20010.85:71,20010.85:76,20010.85:76,  20010.92:80,20010.92:82,20010.92:87,  20010.97:64,20010.97:67,20010.97:77";
        String row = "20010.76:77,20010.76:78,20010.76:70,  20010.85:71,20010.85:70,20010.85:72,20010.85:72,  20010.92:75,20010.92:76,20010.92:71,20010.92:72,20010.92:77,20010.92:81,  20010.97:84,20010.97:87,20010.97:94,20010.97:78";
        insideKalman(row);
    }



    public boolean insideKalman(String row) {
        Map<String, List<Float>> preprocessedData3 = preprocess(row);
        Map<String, Float> finalData3;
        finalData3 = stdFilterBeforeKalmanFilter(preprocessedData3);
        boolean isIn = resultKalman(finalData3);
        LOG.info("rspike {} {}", finalData3, isIn);
        return isIn;
    }

    public boolean resultKalman(Map<String, Float> ibeacon) {
        for (Map.Entry<String, Float> idRssi : ibeacon.entrySet()) {
            Integer rssi = getRssiBySpikeId(idRssi.getKey());
            if (rssi != null) {
                if (idRssi.getValue() <= rssi) {
                    return true;
                }
            }
        }
        return false;
    }

    public Map<String, List<Float>> preprocess(String row) {
        row=row.trim();
        String[] str = row.split(",");

        Map<String, List<Float>> ibeacon = new HashMap<String, List<Float>>();

        for (int i = 0; i < str.length; i++) {
            String[] beacon_rssi = str[i].split(":");
            String beaconID = beacon_rssi[0];
            float rssi = Integer.parseInt(beacon_rssi[1]);
            if (ibeacon.containsKey(beaconID)) {
                ibeacon.get(beaconID).add(rssi);
            } else {
                List<Float> rssi_value = new ArrayList<Float>(1);
                rssi_value.add(rssi);
                ibeacon.put(beaconID, rssi_value);
            }
        }

        return ibeacon;
    }

    public Map<String, Float>stdFilterBeforeKalmanFilter(Map<String, List<Float>> data){

        Map<String, List<Float>> ibeacon = new HashMap<String, List<Float>>();

        Map<String, Float> ibeacon_final = new HashMap<String, Float>();

        Map<String, List<Float>> filterData = new HashMap<String, List<Float>>();

        Map<String, Float> avgData0 = new HashMap<String, Float>();
        avgData0 = avgRSSI(data);

        for (String key : data.keySet()){
            List<Float> ibeaconValue = data.get(key);

            float mean = avgData0.get(key);

            double sum = 0.0;

            for (int i = 0; i < ibeaconValue.size(); i++){
                sum += Math.pow((ibeaconValue.get(i) - mean), 2);
            }

            double std_value = Math.sqrt(sum/(ibeaconValue.size() - 1));

            for (int i = 0; i < ibeaconValue.size(); i++){
                if (Math.abs(ibeaconValue.get(i) - mean) > std_value){
                    ibeaconValue.remove(i);
                }
            }

            ibeacon.put(key, ibeaconValue);
        }


        for (String key : ibeacon.keySet()){
            List<Float> ibeaconValue = ibeacon.get(key);
            KalmanFilterAlgorithm kalmanFilter = new KalmanFilterAlgorithm(20, 0.01);

            List<Float> filteredData = new ArrayList<>();

            for (int i = 0; i < ibeaconValue.size(); i++){
                double tmpData = kalmanFilter.filter(ibeaconValue.get(i));
                float filtered_data = (float) tmpData;
                filteredData.add(filtered_data);
            }
            List<Float> v = new ArrayList<>();
            filterData.put(key, filteredData);
        }

        ibeacon_final = avgRSSI(filterData);


        return ibeacon_final;
    }

    public static Map<String, Float> avgRSSI(Map<String, List<Float>> data){

        Map<String, Float> ibeacon = new HashMap<String, Float>();

        for (String key : data.keySet()){

            List<Float> ibeaconValue = data.get(key);

            int final_total = 0;
            for (Float final_value: ibeaconValue){
                final_total += final_value;
            }

            float final_mean = final_total/(float)ibeaconValue.size();

            ibeacon.put(key, final_mean);
        }

        return ibeacon;
    }

    private Integer getRssiBySpikeId(String spikeId) {
//        if(StringUtils.isEmpty(spikeId)){
//            return null;
//        }
//        Integer rssi = Selflearn.idRssiMap.get(spikeId);
//        if (rssi == null) {
//            String rssiStr = iRedisTemplateForMpl.getRedisClientByKey(spikeId).getFromHash("spike_rssi_hashkey",
//                    spikeId);
//            if (rssiStr != null) {
//                rssi = Integer.parseInt(rssiStr);
//            } else {
//                rssi = 68;
//            }
//        }
//
//        return rssi;
        return RSSI;
    }
}





