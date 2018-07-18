package com.mp.collection.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by min on 3/6/2017.
 */
public class FindSameElement {

    @Test
    public void findSameElementTest() {
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list1.add(i + "");
            list2.add(i * 2 + "");
        }
        System.out.print("list1：");
        printAll(list1);
        System.out.print("list2：");
        printAll(list2);

        List resultList = findSameElement(list1, list2);
        System.out.print("the same element:");
        printAll(resultList);
    }

    public List findSameElement(List<String> list1, List<String> list2) {
        List<String> resultList = new ArrayList<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String str : list1) {
            map.put(str, new Integer(1));
        }

        for (String str : list2) {
            if (null != map.get(str)) {
                map.put(str, (Integer) map.get(str) + 1);
            } else {
                map.put(str, new Integer(1));
            }
        }

        /*
         * Iterator iterator = map.keySet().iterator(); while (iterator.hasNext()) { String str =
         * (String) iterator.next(); if (map.get(str) > 1) { resultList.add(str); } }
         */
        System.out.println("element:count");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                resultList.add(entry.getKey());
            }
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        return resultList;
    }

    public void printAll(List<String> list) {
        StringBuilder sb = new StringBuilder("");
        for (String str : list) {
            sb.append(str + ",");
            // System.out.println(str);
        }

        System.out.println(sb.toString().substring(0, sb.length() - 1));
    }
}
