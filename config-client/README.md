# Config Client

- 测试URL
    - API接口： http://localhost:7002/from
    - 强制刷新： http://localhost:7002/actuator/refresh
    
- 客户端配置, 注意要配置在  bootstrap.properties 文件中

- 基本配置
	- 配置应用名称（对应配置文件名称中的 application 部分）：`spring.application.name=rongzi` 
	- 配置profile（对应配置文件名称中的  profile 部分） ： `spring.cloud.config.profile=dev` 
	- 配置分支（对应配置文件名称中的  label 部分）：`spring.cloud.config.label=master`
	
- 通过URL地址访问 config-server: `spring.cloud.config.uri=http://localhost:7001/`

- 通过服务注册中心访问 config-server
	- 服务注册中心: `eureka.client.service-url.defaultZone=http://localhost:1111/eureka`
	- 开启通过服务来访问 Config Server 功能， 默认是 false : `spring.cloud.config.discovery.enabled=true`
	- 指定注册服务的名称 : `spring.cloud.config.discovery.service-id=config-server`

- 开启失败快速响应，默认是 false（客户端优先判断 config server 获取是否正常）： spring.cloud.config.fail-fast=true

- 失败重试机制
	- 需要依赖 retry 包 和 aop 包
		- spring-retry
		- spring-boot-starter-aop
	- 下一间隔的乘数， 默认是 1.1 : spring.cloud.config.retry.multiplier=1.1
	- 初始间隔时间， 默认是1000 : spring.cloud.config.retry.initial-interval=1000
	- 最大间隔时间， 默认是2000 : spring.cloud.config.retry.max-interval=2000
	- 最大重试次数， 默认是 6 次 :  spring.cloud.config.retry.max-attempts=6

- 动态刷新机制 
	- 需要使用 actuator 的 refresh 接口 完成动态刷新
	
	- 测试URL： POST http://localhost:7002/actuator/refresh
	
- 第九章：消息总线
    - 在pom文件中添加依赖：
        - spring-cloud-bus
        - spring-cloud-stream-binder-rabbit
    - 添加rabbit 配置
    
    - 启动两个 config 客户端
        - java -jar config-client-0.0.1-SNAPSHOT.jar --server.port=7002
        - java -jar config-client-0.0.1-SNAPSHOT.jar --server.port=7003
    
    - 测试URL: 
        - 触发全部刷新：POST http://localhost:7002/actuator/bus-refresh
        - 指定范围刷新：POST http://localhost:7002/actuator/bus-refresh?destination=ds:port