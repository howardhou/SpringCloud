package com.rongzi.ribbonconsumer.command;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import com.rongzi.ribbonconsumer.model.User;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Subscriber;

// 通过继承 HystrixObservableCommand 实现 Observable的定义， 响应式编程
public class UserObservableCommand extends HystrixObservableCommand<User> {

    private RestTemplate restTemplate;
    private Integer id;

    public UserObservableCommand(RestTemplate restTemplate, Integer id){
        // Setter 只能通过 groupKey 实例化，commandKey 是可选参数, 没有 threadPoolKey 参数
        super(HystrixObservableCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("group_name2")));
        this.restTemplate = restTemplate;
        this.id = id;
    }

    @Override
    protected Observable<User> construct() {

        Observable<User> observable = Observable.unsafeCreate(new Observable.OnSubscribe<User>() {
            @Override
            public void call(Subscriber<? super User> subscriber) {

                try {
                    if (!subscriber.isUnsubscribed()){
                        User user = restTemplate.getForObject("http://hello-service/user/{1}", User.class, id);
                        subscriber.onNext(user);
                        subscriber.onCompleted();
                    }
                }
                catch (Exception e){
                    subscriber.onError(e);
                }
            }
        });

        return observable;
    }

    //实现服务降级
    @Override
    protected Observable<User> resumeWithFallback() {
        return super.resumeWithFallback();
    }

    // 开启请求缓存
    // 返回请求缓存Key
    @Override
    protected String getCacheKey() {
        System.out.println("UserObservableCommand： 调用getCacheKey");//打印一下什么时候会触发
        return String.valueOf(id);
    }
}
