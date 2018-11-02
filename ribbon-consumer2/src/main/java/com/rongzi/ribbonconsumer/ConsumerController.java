package com.rongzi.ribbonconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

import java.util.ArrayList;


@RestController
public class ConsumerController {

    //@Autowired
    //RestTemplate restTemplate;

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/ribbon-consumer")
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


}
