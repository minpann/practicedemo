package com.mp.collection.json;

import com.alibaba.fastjson.JSON;
import com.mp.collection.json.vo.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by panmin on 16-12-7.
 */
public class JsonTest {
    public static void main(String[] args){
        jsonTest();
    }

    public static void jsonTest(){
        List<Person> list = new ArrayList<Person>();
        list.add(new Person("王明","北京"));
        list.add(new Person("李彤","上海"));
        list.add(new Person("贾静","深圳"));

        String doubleTransferJson = JSON.toJSONString(JSON.toJSONString(list));
        System.out.println(doubleTransferJson);

        String json = (String) JSON.parse(doubleTransferJson);
        System.out.println(json);

        list = JSON.parseArray(json,Person.class);
        System.out.println(list);
    }
}
