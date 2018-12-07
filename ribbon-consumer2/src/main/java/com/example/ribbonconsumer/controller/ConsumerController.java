package com.example.ribbonconsumer.controller;

import com.example.ribbonconsumer.command.UserCommand;
import com.example.ribbonconsumer.model.User;
import com.example.ribbonconsumer.service.HelloService;
import com.example.ribbonconsumer.service.UserService;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.example.ribbonconsumer.command.UserObservableCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Subscriber;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;

    @ApiOperation(value="测试方法", notes="调用 Hello Service 的 hello 接口")
    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer(){

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
//        Observable.from(list).subscribe(new Subscriber<Integer>() {
//            @Override
//            public void onCompleted() {
//                System.out.println("onCompleted");
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//                System.out.println("onError");
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//                System.out.println("onNext: Hello " + integer);
//            }
//        });
//
//        Observable.from(list).subscribe(new Action1<Integer>() {
//            @Override
//            public void call(Integer integer) {
//                System.out.println("call: Hello " + integer);
//            }
//        });


        return helloService.helloServcie();
        //return restTemplate.getForEntity("http://hello-service/hello", String.class).getBody();
    }


    @Autowired
    UserService userService;
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/getUser/{id}")
    public User getUser(@PathVariable("id") Integer id){

        // 通过注解实现同步执行命令
        User user = userService.getUserById(id);

        // 初始化请求上下文, 解决请求缓存异常
        HystrixRequestContext.initializeContext();

        // 通过继承 HystrixCommand 实现同步执行命令
        //User user = new UserCommand(restTemplate,id).execute();

        System.out.println("同步执行Command： " + user.toString());

        return user;
    }

    @RequestMapping(value = "/getUserAsync/{id}")
    public User getUserAsync(@PathVariable("id") Integer id) throws ExecutionException, InterruptedException {

        // 通过注解实现异步执行命令
        // User user = userService.getUserById(id);

        // 初始化请求上下文, 解决请求缓存异常
        HystrixRequestContext.initializeContext();

        //通过继承 HystrixCommand 实现异步执行命令
        Future<User> future = new UserCommand(restTemplate, id).queue();
        User user = future.get();
        System.out.println("异步执行Command： " + user.toString());

        // 测试请求缓存， 多次调用，实际上只有第一次真正调用接口
        future = new UserCommand(restTemplate, id).queue();
        user = future.get();

        return user;
    }

    @RequestMapping(value = "/getUserObservable/{id}")
    public User getUserObservable(@PathVariable("id") Integer id){

        User _user = new User("王二小", 0);

        // 通过 HystrixCommand 注解 实现 Observable 的定义
        // Observable<User> observable = userService.getUserObservable(id);

        // 通过继承 HystrixObservableCommand 实现 Observable的定义， 响应式编程
        // 热 Hot Observable
        //Observable<User> observable = new UserObservableCommand(restTemplate, id).observe();
        // 冷 Cold Observable
        Observable<User> observable = new UserObservableCommand(restTemplate, id).toObservable();
        observable.subscribe(new Subscriber<User>() {
            @Override
            public void onCompleted() {
                System.out.println("Observable onCompleted： ");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Observable Command： " + throwable);
            }

            @Override
            public void onNext(User user) {
                System.out.println("Observable Command： " + user.toString());
            }
        });

        return _user;
    }
}
