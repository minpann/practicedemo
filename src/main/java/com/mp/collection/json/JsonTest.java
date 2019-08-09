package com.mp.collection.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mp.collection.json.vo.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by panmin on 16-12-7.
 */
public class JsonTest {

    @Test
    public void jsonTest(){
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

    @Test
    public void jsonParseTest() {
        String jsonObjectStr = "{\"address\":\"北京\",\"name\":\"王明\"}";
        String jsonArrayStr = "[{\"address\":\"北京\",\"name\":\"王明\"},{\"address\":\"上海\",\"name\":\"李彤\"},{\"address\":\"深圳\",\"name\":\"贾静\"}]";
        //转换为对象
        Person person = JSON.parseObject(jsonObjectStr, Person.class);
        System.out.println(person);

        //转换为jsonObject对象
        JSONObject jsonObject = JSON.parseObject(jsonObjectStr);
        System.out.println(jsonObject);

        //转换对象列表
        List<Person> list = JSON.parseArray(jsonArrayStr, Person.class);
        System.out.println(list);

        //转换为json数组
        JSONArray jsonArray = JSON.parseArray(jsonArrayStr);
        Iterator<Object> iterator = jsonArray.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
