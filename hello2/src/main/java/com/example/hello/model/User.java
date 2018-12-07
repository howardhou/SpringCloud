package com.example.hello.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "User 模型")
public class User {
    @ApiModelProperty("用户名")
    private String name;
    @ApiModelProperty("年龄")
    private Integer age;

    public User(){

    }

    public User(String name, Integer age){
        this.name = name;
        this.age = age;

    }


    @Override
    public String toString() {
        return "name = " + name + ", age = " + age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
