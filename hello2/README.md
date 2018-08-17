# Hello2 - eureka client

- http://localhost:8080/hello

- 使用此服务的客户端是 feign-consumer, ribbon-consumer, ribbon-consumer2

- 本例是服务治理的客户端， 发现注册中心，并注册到注册中心： @EnableDiscoveryClient

- 服务治理是微服务架构中最为核心的模块，主要用来实现各个微服务的自动化注册和发现， Eureka 分为 服务端和客户端
	- 服务端：也称为注册中心
	- 客户端：处理服务的注册和发现（Discovery）

- 例子：
	- https://www.jianshu.com/p/d32ae141f680
	- https://windmt.com/2018/04/14/spring-cloud-1-services-governance/

- 注册 服务提供者
	- @Autowired : 通过byType形式，用来给指定的字段或方法注入所需的外部资源: https://blog.csdn.net/u013257679/article/details/52295106
		
	- discoveryclient.getLocalServiceInstance 方法被取消了， 替代方法是： https://stackoverflow.com/questions/45085790/spring-cloud-discoveryclient-getlocalserviceinstance-deprecated-how-to-use-r

- [Spring Cloud 2 Finchley.M9 概览](https://www.jianshu.com/p/c52b1089ea92)
	- spring-cloud-starter-netflix-eureka-server
	- spring-cloud-starter-netflix-eureka-client
	- spring-cloud-starter-netflix-hystrix
	- spring-cloud-starter-netflix-hystrix-dashboard
	- spring-cloud-starter-openfeign

- ISSUE:
	- discoveryclient.getLocalServiceInstance 方法被取消了， 替代方法是： https://stackoverflow.com/questions/45085790/spring-cloud-discoveryclient-getlocalserviceinstance-deprecated-how-to-use-r
	
- 运行两个 Hello Service
    - mvn install
    - cd ~/Git/SpringCloud/hello2/target/
    - java -jar hello-0.0.1-SNAPSHOT.jar --server.port=8081
    - java -jar hello-0.0.1-SNAPSHOT.jar --server.port=8082
    
### 第6章使用， Feign 的 服务端

- 改造Hello-Service项目，新增3个接口
	
- http://localhost:8080/hello1?name=howard

    