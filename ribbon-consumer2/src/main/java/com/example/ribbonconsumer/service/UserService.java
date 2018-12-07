package com.example.ribbonconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import com.example.ribbonconsumer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

@Service
public class UserService {
    @Autowired
    private RestTemplate restTemplate;

    // 通过 HystrixCommand 注解 实现 同步执行 命令的定义
    @HystrixCommand(commandKey = "m-getUserById")
    public User getUserById(Integer id){
        return restTemplate.getForObject("http://hello-service/user/{1}", User.class, id);
    }

    // 通过 HystrixCommand 注解 实现 异步执行 命令的定义
    @HystrixCommand(commandKey = "m-getUserByIdAsync")
    public Future<User> getUserByIdAsync(final Integer id){

        AsyncResult<User> asyncResult = new AsyncResult<User>() {
            @Override
            public User invoke() {
                return restTemplate.getForObject("http://hello-service/user/{1}", User.class, id);
            }
        };

        return asyncResult;
    }

    // 通过 HystrixCommand 注解 实现 Observable 的定义
//    @HystrixCommand
//    public Observable<User> getUserObservable(final Integer id){

//        Observable<User> observable = Observable.unsafeCreate(new Observable.OnSubscribe<User>() {
//            @Override
//            public void call(Subscriber<? super User> subscriber) {
//
//                try {
//                    if (!subscriber.isUnsubscribed()){
//                        User user = restTemplate.getForObject("http://hello-service/user/{1}", User.class, id);
//                        subscriber.onNext(user);
//                        subscriber.onCompleted();
//                    }
//                }
//                catch (Exception e){
//                    subscriber.onError(e);
//                }
//            }
//        });
//
//        return observable;
//    }
}
