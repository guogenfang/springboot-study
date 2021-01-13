package org.ggf.aop;

/**
 *[简要描述]: 
 * @Author ggf
 * @Date 2021/1/10 18:25
 **/
public class User {
    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }
}
