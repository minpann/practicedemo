package com.mp.collection;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by panmin on 17-1-5.
 */
public class MapTest {
    @Test
    public void mapTest(){
        Map<String,String> map = new HashMap<String, String>();
        map.put("m1", "111");
        map.put(null, "129");
        map.put("m2", null);   //加入map中,无效

        System.out.println(JSON.toJSONString(map));

        Map<String,String> hashTable = new Hashtable<String, String>();
        hashTable.put("hm1", "111");
//        hashTable.put(null, "129");
//        hashTable.put("hm2", null);

        System.out.println(JSON.toJSONString(hashTable));

    }
}
