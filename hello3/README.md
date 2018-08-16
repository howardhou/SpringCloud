# Hello3 - 多 module 方式

- http://localhost:8080/refactor/hello1?name=howard

- 打开 hello3 项目, 选择 新增 Module from Existing Source... 菜单， 选择 hello-service-api 项目
  	- 新建 RefactorHelloController 类，实现 HelloService 接口
  	- ISSUE: hello2 和 hello3 接口 的入参是空
  		- 原因是 idea 自动生成的代码，没有在参数前面带上 @RequestParam，@RequestHeader，@RequestBody 注解