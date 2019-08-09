package com.mp.lambda.LambdaTest6;

/**
 * Created by minpan on 2019-08-08
 *
 * @author minpan
 */
public class LambdaTest6 {
    public static void main(String[] args) {

        Model m = new Model();

        //方法有一个参数，然后没返回类型,这里参数类型会自动识别
        Action<Model> a1 = (s)->System.out.println("hello");
        a1.run(m);

        //注意:如果这里泛型类型不是Model 那么就不能引用Model中的方法
        //可以引用Model类中任意方法 只要满足一点:该方法没有参数
        //将来run方法中就会调用Model类型对象m的此处引用的方法
        Action<Model> a2 = Model::test3;
        a2.run(m);

        //引用对象m中的test2方法
        //因为test2方法的参数和返回类型和Action接口的方法完全一致
        Action<Model> a3 = m::test2;
        a3.run(m);
    }

    interface Action<T>{
        void run(T t);
    }

    public static class Model{

        public void test1(){
            System.out.println("test1");
        }
        public void test2(Model a){
            System.out.println("test2");
        }
        public int test3(){
            System.out.println("test3");
            return 1;
        }
    }
}
