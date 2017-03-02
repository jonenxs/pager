package com.nxs.model;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by jonenxs on 2017/3/2.
 */
public class Student implements Serializable {


    private static final long serialVersionUID = -4077024502138796538L;

    private int id;

    private String stuName;

    private int age;

    private int gender;

    private String address;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student(int id, String stuName, int age, int gender, String address) {
        this.id = id;
        this.stuName = stuName;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public Student() {
    }

    public Student(Map<String,Object> map){
        this.id = (int)map.get("id");
        this.stuName = (String) map.get("stu_name");
        this.age = (int) map.get("age");
        this.gender = (int) map.get("gender");
        this.address = (String) map.get("address");
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stuName='" + stuName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                '}';
    }
}
