package com.mp.collection;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.*;

/**
 * Created by panmin on 16-12-21.
 */
public class SetTest {

    @Test
    public void setIterator() {
        Map<String, String> map = getMap();
        System.out.println("map iterator begin...");
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if (entry.getKey().equals("name")) {
                iterator.remove();
                continue;
            }
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        System.out.println(JSON.toJSONString(map));
    }

    public Map<String, String> getMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "张玲");
        map.put("career", "软件工程师");
        map.put("address", "朝阳");
        return map;
    }
}
