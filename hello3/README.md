# Hello3 - 多 module 方式

- http://localhost:8080/refactor/hello1?name=howard

- 打开 hello3 项目, 选择 新增 Module from Existing Source... 菜单， 选择 hello-service-api 项目
  	- 新建 RefactorHelloController 类，实现 HelloService 接口
  	- ISSUE: hello2 和 hello3 接口 的入参是空
  		- 原因是 idea 自动生成的代码，没有在参数前面带上 @RequestParam，@RequestHeader，@RequestBody 注解
  		
- 使用 此项目的客户端是 feign-consumer2

- 运行两个 Hello Service
    `mvn install
    cd ~/Git/SpringCloud/hello3/target/
    java -jar hello-0.0.1-SNAPSHOT.jar --server.port=8081
    java -jar hello-0.0.1-SNAPSHOT.jar --server.port=8082` 