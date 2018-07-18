package com.mp.designpattern.builder;

/**
 * Created by panmin on 16-12-22.
 */
public class Person {
    private int code ;
    private String name;
    private int age;
    private String address;
    private String career;
    private String hobby;
    private String politics;

    public static class Builder{
        private int code ;
        private String name;
        private int age;
        private String address;
        private String career;
        private String hobby;
        private String politics;

        public Builder code(int val){
            this.code = val;
            return this;
        }

        public Builder name(String val){
            this.name = val;
            return this;
        }

        public Builder age(int val){
            this.age = val;
            return this;
        }

        public Builder address(String val){
            this.address = val;
            return this;
        }

        public Builder career(String val){
            this.career = val;
            return this;
        }

        public Builder hobby(String val){
            this.hobby = val;
            return this;
        }

        public Builder politics(String val){
            this.politics = val;
            return this;
        }

        public Person build(){
            return new Person(this);
        }

    }

    private Person(Builder builder) {
        this.code = builder.code;
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
        this.career = builder.career;
        this.hobby = builder.hobby;
        this.politics = builder.politics;
    }

    @Override
    public String toString() {
        return "Person{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", career='" + career + '\'' +
                ", hobby='" + hobby + '\'' +
                ", politics='" + politics + '\'' +
                '}';
    }
}
