package com.rongzi.ribbonconsumer.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.rongzi.ribbonconsumer.model.User;
import org.springframework.web.client.RestTemplate;

// 通过继承 HystrixCommand 实现自定义命令，完成同步或异步执行
public class UserCommand extends HystrixCommand<User> {

    private RestTemplate restTemplate;
    private Integer id;

    public UserCommand(RestTemplate restTemplate, Integer id){
        // Setter 只能通过 groupKey 实例化，commandKey 和 threadPoolKey 是可选参数
        // Hystrix 会让相同的 gourpKey 在同一个线程池内
        // 还可以通过 threadPoolKey 实现更细粒度的线程池划分
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("group_name"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("ThreadPoolKey")));
        this.restTemplate = restTemplate;
        this.id = id;
    }

    @Override
    protected User run() throws Exception {
        return restTemplate.getForObject("http://hello-service/user/{1}", User.class, id);
    }

    // 实现服务降级
    @Override
    protected User getFallback() {
        return new User();
    }
}
