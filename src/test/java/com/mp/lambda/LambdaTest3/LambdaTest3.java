package com.mp.lambda.LambdaTest3;

/**
 * Created by minpan on 2019-08-08
 *
 * @author minpan
 */
public class LambdaTest3 {
    public static void main(String[] args) {

        LambdaTest3 t = new LambdaTest3();
        //使用Lambda引用类的静态方法
        //能引用Integer类中的静态方法toBinaryString的原因是:
        //Action3接口中只有一个方法且方法的参数类型和返回值类型
        //与Integer类中的静态方法toBinaryString的参数类型、返回类型是一致的
        Action3 a3 = Integer::toBinaryString;
        System.out.println(a3.run(4));

        //使用Lambda引用对象的非静态方法
        //能引用对象t中的非静态方法test的原因是和上面的描述是一致的
        Action3 aa3 = t::test;
        System.out.println(aa3.run(4));
    }

    public String test(int i){
        return "i="+i;
    }

    @FunctionalInterface
    interface Action3{
        public String run(int Integer);
    }
}
