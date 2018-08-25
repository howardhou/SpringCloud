# feign-consumer

- http://localhost:9001/feign-consumer
- http://localhost:9001/feign-consumer2

- 此项目调用的 API 是 hello2 项目

- 运行 Feign Consumer
      - mvn install
      - cd ~/Git/SpringCloud/feign-consumer/target/
      - java -jar feign-consumer-0.0.1-SNAPSHOT.jar

- 开启Feign的重试机制：请求接口 http://localhost:9001/feign-consumer 时，先访问的是 Server1 ， 然后再到 Server2， 然后再回到 Server1 才请求成功
	- Server1 上的日志
		2018-08-17 13:46:25.200  INFO 39104 --- [nio-8082-exec-8] c.rongzi.hello.web.HelloController       : sleepTime: 1875
		2018-08-17 13:46:26.710  INFO 39104 --- [nio-8082-exec-9] c.rongzi.hello.web.HelloController       : sleepTime: 1774
		2018-08-17 13:46:27.082  INFO 39104 --- [nio-8082-exec-8] c.rongzi.hello.web.HelloController       : index(), host:192.168.1.126, service_id:HELLO-SERVICE
		2018-08-17 13:46:28.489  INFO 39104 --- [nio-8082-exec-9] c.rongzi.hello.web.HelloController       : index(), host:192.168.1.126, service_id:HELLO-SERVICE
		2018-08-17 13:46:31.235  INFO 39104 --- [io-8082-exec-10] c.rongzi.hello.web.HelloController       : sleepTime: 412
		2018-08-17 13:46:31.652  INFO 39104 --- [io-8082-exec-10] c.rongzi.hello.web.HelloController       : index(), host:192.168.1.126, service_id:HELLO-SERVICE

	- Server2 上的日志
		2018-08-17 13:46:28.240  INFO 39103 --- [nio-8081-exec-2] c.rongzi.hello.web.HelloController       : sleepTime: 2570
		2018-08-17 13:46:29.738  INFO 39103 --- [nio-8081-exec-3] c.rongzi.hello.web.HelloController       : sleepTime: 2611
		2018-08-17 13:46:30.816  INFO 39103 --- [nio-8081-exec-2] c.rongzi.hello.web.HelloController       : index(), host:192.168.1.126, service_id:HELLO-SERVICE
		2018-08-17 13:46:32.353  INFO 39103 --- [nio-8081-exec-3] c.rongzi.hello.web.HelloController       : index(), host:192.168.1.126, service_id:HELLO-SERVICE

- 启用 hystrix 断路器功能
	- 启动 hystrix, 默认为 false: `feign.hystrix.enabled=true`
	- 熔断时间要 大于 Ribbon 的超时时间， 否则 请求直接熔断， 重试机制就没任何意义了: `hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=5000`
    		
- 开启压缩功能 ？？
- 配置日志等级

- 服务降级配置， 请看 feign-consumer2 项目