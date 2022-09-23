package com.pojo;

public class SelectPersonById {
    private long id;
    private String name;
    private long age;
    private String code;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "SelectPersonById{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", code='" + code + '\'' +
                '}';
    }
}
