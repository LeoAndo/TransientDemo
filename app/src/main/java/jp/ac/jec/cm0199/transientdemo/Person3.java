package jp.ac.jec.cm0199.transientdemo;

import java.io.Serializable;

class Person3 implements Serializable {
    private String name;
    private transient int age; // シリアライズの対象外にする
    private transient String address; // シリアライズの対象外にする
    private String phone;

    public Person3(String name, int age, String address, String phone) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person3{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}