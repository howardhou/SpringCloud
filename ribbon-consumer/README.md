# ribbon consumer 

- http://localhost:9000/ribbon-consumer

- 此项目使用的API是 hello2 项目

- RestTemplate 详解

- 服务发现与消费：Ribbon (客户端负载均衡)
	- @Bean : Spring的@Bean注解用于告诉方法，产生一个Bean对象，然后这个Bean对象交给Spring管理。产生这个Bean对象的方法Spring只会调用一次，随后这个Spring将会将这个Bean对象放在自己的IOC容器中。:https://blog.csdn.net/genius_ge/article/details/76151516
    - @LoadBalanced : 启用负载均衡
	- http://HELLO-SERVICE/hello : HELLO-SERVICE 是微服务的应用名称

- 测试负载均衡功能：启动两个后端程序 hello2
    - 启动 Server1： java -jar hello-0.0.1-SNAPSHOT.jar --server.port=8080
    - 启动 Server2： java -jar hello-0.0.1-SNAPSHOT.jar --server.port=8090

- Ribbon 重试机制
    - Retrying Failed Requests:  http://cloud.spring.io/spring-cloud-netflix/single/spring-cloud-netflix.html#retrying-failed-requests
    - ISSUE: 重试机制不工作； 相同的配置在 feign-consumer 项目里，可以工作。 具体原因未找到。
    