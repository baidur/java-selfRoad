package com.example.demo.reflect.entity;

import com.example.demo.reflect.annotation.Column;
import com.example.demo.reflect.annotation.Table;


@Table(value = "User")
public class User {

    @Column(value = "age")
    private int age;
    @Column(value = "name")
    private String name;
    @Column(value = "address")
    private String address;

    public User() {
    }

    public User(int age, String name, String address) {
        this.age = age;
        this.name = name;
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println(age);
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println(name);
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        System.out.println(address);
        this.address = address;
    }
}
