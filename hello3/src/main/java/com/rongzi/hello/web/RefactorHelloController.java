package com.rongzi.hello.web;

import com.rongzi.helloserviceapi.model.User;
import com.rongzi.helloserviceapi.service.HelloService;
import org.springframework.web.bind.annotation.*;

/* 通过继承 HelloService 接口实现
 * idea 自动生成的实现，没有带上 @RequestParam，@RequestHeader，@RequestBody，需要手动加上
 * 否则， 没有 @RequestHeader，@RequestBody 标识的参数，是 null */

@RestController
public class RefactorHelloController implements HelloService {

    @Override
    public String hello(@RequestParam("name") String name) {

        return "Hello " + name;
    }

    @Override
    public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {

        return new User(name, age);
    }

    @Override
    public String hello(@RequestBody User user) {

        return "hello " + user.getName() + ", " + user.getAge();
    }
}

/* 直接实现 */
//@RestController
//public class RefactorHelloController {
//    @RequestMapping(value = "hello1", method = RequestMethod.GET)
//    public String hello(@RequestParam("name") String name) {
//
//        return "Hello " + name;
//    }
//
//    @RequestMapping(value = "hello2", method = RequestMethod.GET)
//    public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
//
//        return new User(name, age);
//    }
//
//    @RequestMapping(value = "hello3", method = RequestMethod.POST)
//    public String hello(@RequestBody User user) {
//
//        return "hello " + user.getName() + ", " + user.getAge();
//    }
//}
