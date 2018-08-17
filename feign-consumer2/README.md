# feign-consumer2 - 多 module 方式

- http://localhost:9001/feign-consumer3

- 多 module 方式 实现
    - 创建 hello-service-api 项目时， 选择 maven，但不使用任何 archetype 进行创建
    - 在 hello-service-api 项目中添加依赖
         `<dependencies>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-web</artifactId>
            </dependency>
        </dependencies>`
        
    - 在 feign-consumers 项目中添加依赖
        `<dependency>
            <groupId>com.rongzi</groupId>
            <artifactId>hello-service-api</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>`

- 此项目使用的 API 是 hello3 项目

## 服务降级配置
- ISSUE: [No fallback instance of type class com.rongzi.feignconsumer.service.RefactorFallback found for feign client hello-service](http://www.cnblogs.com/zuixieyang/p/9211932.html)
	- 缺少注解“@Component”，导致编译时未将 RefactorFallback 类自动实例化。 当服务接口不可用时，进入到熔断器fallback的逻辑处理中，此时检查不到对应的实例

- ISSUE： Incompatible fallback instance. Fallback/fallbackFactory of type class com.rongzi.feignconsumer.service.RefactorFallback is not assignable to interface com.rongzi.feignconsumer.service.RefactorHelloService for feign client hello-service
	- 字面意思， RefactorFallback 要实现 RefactorHelloService 接口
	- https://github.com/OpenFeign/feign/issues/298

- ISSUE： Ambiguous mapping. Cannot map 'com.rongzi.feignconsumer.service.RefactorHelloService' method
	- 问题出现的原因是：@RequestMapping(value = "/refactor") ，由多个类实现了 HelloService 接口导致的： https://blog.csdn.net/carl_jiang/article/details/51787372
	- 解决方法是： RefactorFallback 类重新定义 @RequestMapping("/fallback") 注解： https://segmentfault.com/q/1010000010378179

