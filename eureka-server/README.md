# Eureka Server

- 服务治理是微服务架构中最为核心的模块，主要用来实现各个微服务的自动化注册和发现， Eureka 分为 服务端和客户端
	- 服务端：也称为注册中心
	- 客户端：处理服务的注册和发现 （Discovery）

- 搭建服务注册中心

- 高可用注册中心
	- eureka.client.service-url.defaultZone=http://peer2:1112/eureka

- [Spring Cloud 官网](https://projects.spring.io/spring-cloud/)
	- Finchley builds and works with Spring Boot 2.0.x, and is not expected to work with Spring Boot 1.5.x.
	- The Dalston and Edgware release trains build on Spring Boot 1.5.x, and are not expected to work with Spring Boot 2.0.x.
	- The Dalston release train will reach end-of-life in December 2018.
	- The Camden release train was marked end-of-life.
	- The Brixton and Angel release trains were marked end-of-life (EOL) in July 2017.


- [Spring Cloud 版本](https://blog.csdn.net/54powerman/article/details/79163440)
	- 大版本： Angel，Brixton，Camden、Dalston、Edgware，Finchley版本
	- 小版本： 
		- SNAPSHOT： 快照版本，随时可能修改
		- M： MileStone，M1表示第1个里程碑版本，一般同时标注PRE，表示预览版版。
		- SR： Service Release，SR1表示第1个正式版本，一般同时标注GA：(GenerallyAvailable),表示稳定版本。


- [Spring Cloud 2 Finchley.M9 概览](https://www.jianshu.com/p/c52b1089ea92)
	- spring-cloud-starter-netflix-eureka-server
	- spring-cloud-starter-netflix-eureka-client
	- spring-cloud-starter-netflix-hystrix
	- spring-cloud-starter-netflix-hystrix-dashboard
	- spring-cloud-starter-openfeign


- ISSUE:
	- EMERGENCY! EUREKA MAY BE INCORRECTLY CLAIMING INSTANCES ARE UP WHEN THEY'RE NOT. RENEWALS ARE LESSER THAN THRESHOLD AND HENCE THE INSTANCES ARE NOT BEING EXPIRED JUST TO BE SAFE. : [说明Eureka已经进入了自我保护模式](https://blog.csdn.net/cvntopuyef/article/details/78477681) 
		- 解决方法是：[剔除过期等不健康实例](https://blog.csdn.net/cvntopuyef/article/details/78465798), 生产环境不建议使用

	- [Idea里并没有提示 eureka.client.healthcheck.enabled 这个属性，并且还显示黄色](https://www.cnblogs.com/woshimrf/p/springclout-eureka.html)