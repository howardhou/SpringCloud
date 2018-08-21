# API Gateway

## 请求路由
- api-a-url 为路由的名称， 意思是：所有符合 /api/** 规则的都发往 http://localhost:8080/
	- zuul.routes.api-a-url.path=/api/**
	- zuul.routes.api-a-url.url=http://localhost:8080/

	- 测试： www.localhost.com:5555/api/hello1?name=dongdong

    - 这种 path, url 方式不会使用 zuul 自带的 ribbon 和 hystrix 功能

- 面向服务的路由，利用 Eureka
	- zuul.routes.api-a.path=/api-a/**
	- zuul.routes.api-a.service-id=hello-service
	- zuul.routes.api-b.path=/api-b/**
	- zuul.routes.api-b.service-id=feign-consumer
	- eureka.client.service-url.defaultZone=http://localhost:1111/eureka

    - 尽量使用 path, service-id 的方式， 这样就会使用 ribbon 和 hystrix 功能

	- 测试 地址
		- http://localhost:5555/api-a/hello1?name=hou
		- http://localhost:5555/api-b/feign-consumer2

    - 另一种配置方式
        - zuul.routes.hello-service=/hello-service/**
        
        - URL: http://localhost:5555/hello-service/hello1?name=howard

- 服务路由的默认规则
    - 在默认情况下，所有的Eureka 上的服务都会被 Zuul 自动地创建路由， 类似 zuul.routes.hello-service=/hello-service/** 这样
   
    - http://localhost:5555/hello-servcie/hello1?name=howard
    - http://localhost:5555/feign-consumer/feign-consumer2
    
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

    - 关闭ribbon重试机制
        - zuul.retryable=false
        - zuul.routes.hello-service.retryable=false

## 请求过滤器
- GET http://localhost:5555/api-b/feign-consumer2 返回 401 
- GET http://localhost:5555/api-b/feign-consumer2?accessToken=token 返回成功


