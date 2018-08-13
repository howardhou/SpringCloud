# Hello2 - eureka client

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