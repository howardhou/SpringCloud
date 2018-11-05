package com.rongzi.hello.web;

import com.rongzi.hello.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") Integer userId){
        System.out.println("getUserById： " + userId);
        return new User("张三 " + userId, 32);
    }
}
