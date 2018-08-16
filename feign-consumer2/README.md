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
