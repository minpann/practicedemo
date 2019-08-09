package com.mp.lambda.LambdaTest4;

/**
 * Created by minpan on 2019-08-08
 *
 * @author minpan
 */
public class LambdaTest4 {
    public static void main(String[] args) {

        //Lambda表达式引用构造函数
        //根据构造器的参数来自动匹配使用哪一个构造器
        Action4Creater creater = Action4::new;
        Action4 a4 = creater.create("zhangsan");
        a4.say();


    }

    public static class Action4{
        private String name;
        public Action4() {

        }
        public Action4(String name) {
            this.name = name;
        }
        public void say(){
            System.out.println("name = "+name);
        }
    }

    interface Action4Creater{
        public Action4 create(String name);
    }
}
