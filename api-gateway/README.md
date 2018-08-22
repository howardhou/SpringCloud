# API Gateway

## 请求路由
- api-a-url 为路由的名称， 意思是：所有符合 /api/** 规则的都发往 http://localhost:8080/
	- zuul.routes.api-a-url.path=/api/**
	- zuul.routes.api-a-url.url=http://localhost:8080/

- 面向服务的路由，利用 Eureka
	- zuul.routes.api-a.path=/api-a/**
	- zuul.routes.api-a.service-id=hello-service
	- zuul.routes.api-b.path=/api-b/**
	- zuul.routes.api-b.service-id=feign-consumer

    - 另一种配置方式
        - zuul.routes.hello-service=/hello-service/**

- 默认配置， 在默认情况下，所有的Eureka 上的服务都会被 Zuul 自动地创建路由， 类似 zuul.routes.hello-service=/hello-service/** 这样
    
- 忽略默认配置方法：`zuul.ignored-services=hello-service`

- 自定义路由映射规则： 实现 /v1/hello-service

- 路径匹配

- 忽略表达式： `zuul.ignored-services=hello-service`

- 路由前缀： zuul.prefix=/api

- 本地跳转： forward:\local

- Coockie 头信息 
    - 默认情况， Zuul 会过滤掉敏感信息， 包括Coockie, Set-Coockie等
    - 重定向问题
    
- Hystrix 和 Ribbon 支持
    - 这种 path, url 方式不会使用 zuul 自带的 ribbon 和 hystrix 功能
    - 尽量使用 path, service-id 的方式， 这样就会使用 ribbon 和 hystrix 功能
        
- 重试机制
    - ISSUE：当 调用的API超时时，出现 SocketTimeoutException: Read timed out 异常， 解决办法
        1. 需要添加依赖包： `org.springframework.retry:spring-retry` 
        2. 配置 zuul.retryable=true ， 因为默认是false
        3. 参考：https://stackoverflow.com/questions/44642136/zuul-retry-configuration-is-not-working-with-eureka
    
    - 关闭ribbon重试机制
        - zuul.retryable=false ， 默认就是 false
        - zuul.routes.hello-service.retryable=false
        
- 测试 地址
	- http://localhost:5555/api/hello1?name=dongdong
	- http://localhost:5555/api-a/hello1?name=hou
	- http://localhost:5555/api-b/feign-consumer2
    - http://localhost:5555/hello-service/hello1?name=howard
	- http://localhost:5555/feign-consumer/feign-consumer2
    - http://localhost:5555/api-c/hello
    
## 请求过滤器
- 过滤器 demo
	- GET http://localhost:5555/api-b/feign-consumer2 返回 401 
	- GET http://localhost:5555/api-b/feign-consumer2?accessToken=token 返回成功

- 过滤器的4种类型
	- pre
	- routing
	- post
	- error

- 过滤器的异常处理??
	- Finchley 版，[与书上的例子不一样](https://zhuanlan.zhihu.com/p/26910991?refer=dreawer)， 应该是有所变化了
	
- 禁用过滤器： 
	- zuul.AccessFilter.pre.disable=true