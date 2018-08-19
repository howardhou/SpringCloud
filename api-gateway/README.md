# API Gateway


- api-a-url 为路由的名称， 意思是：所有符合 /api/** 规则的都发往 http://localhost:8080/
	- zuul.routes.api-a-url.path=/api/**
	- zuul.routes.api-a-url.url=http://localhost:8080/

	- 测试： www.localhost.com:5555/api/hello

- 面向服务的路由，利用 Eureka
	- zuul.routes.api-a.path=/api-a/**
	- zuul.routes.api-a.service-id=hello-service
	- zuul.routes.api-b.path=/api-b/**
	- zuul.routes.api-b.service-id=feign-consumer
	- eureka.client.service-url.defaultZone=http://localhost:1111/eureka

	- 测试 地址
		- http://localhost:5555/api-a/hello1?name=hou
		- http://localhost:5555/api-b/feign-consumer2
