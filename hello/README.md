# Hello - Spring Boot

- 通过官方的 [Spring Initializr](http://start.spring.io) 工具来产生基础项目 

- ISSUE: 
	- spring boot中不能识别RestController的原因： 原因是相关 spring boot jar 包，没有被下载完成， 如果没有自动开始下载，可以打开 pom.xml文件， 点击 Import Changes, 触发下载。

	- [idea中maven项目一直卡在Resolving Maven dependencies](https://blog.csdn.net/gnail_oug/article/details/79850886) ： 可能是正在下载，也可能是已经下载完了，需要重新启动 IDE， Spring Boot 相关依赖jar包有点多，需要等待一些时间。

	- 如何运行 Spring Boot， 需要先安装 Maven

## Maven
- [安装maven](http://wlb.wlb.blog.163.com/blog/static/46741320154215621382/)
	- [下载maven](http://maven.apache.org/download.cgi)
	- 解压至/usr/local/maven
	- 配置.bash_profile : `export MAVEN_HOME="/usr/local/maven"  export PATH="$PATH:$MAVEN_HOME/bin"`
	- 执行如下命令使生效：`source .bash_profile`
	- 测试： mvn -version

	- For Mac: brew install maven

- [Maven详解](http://www.cnblogs.com/hongwz/p/5456578.html)
	- Maven的作用
		- 统一开发规范与工具
		- 统一管理jar包

	- pom.xml，这是Maven的核心配置文件，
		- pom称为Project Object Model（项目对象模型），它用于描述整个Maven项目，所以也称为Maven描述文件
		- modelVersion: 当前Maven模型的版本号
		- groupId(公司名或是组织名) , artifactId(项目名) , version 3个确定一个项目
		- packing： 项目打包的类型，可以使jar、war、rar、ear、pom，默认是jar
		- dependencies和dependency: 依赖包
		- properties: 配置属性
		- build

- 启动项目， mvn spring-boot:run

## 配置详解

- [配置文件 application.yml](https://www.jianshu.com/p/fb6731ee53d2)

- application.properties 多环境配置 ： https://blog.csdn.net/fycghy0803/article/details/80235122
	- 在application.properties中配置: spring.profiles.active=dev，来表示使用 application-dev.properties 文件中的配置
	- 如果在application.properties 和 application-dev.properties中都配置了相同的参数，则使用application-dev.properties中的参数

## 监控与管理
- [spring-boot-starter-actuator 监控接口详解](https://www.jianshu.com/p/481134c3fab7) : 已不是新版

- 新版接口：[Spring Boot Actuator in Spring Boot 2.0](https://dzone.com/articles/spring-boot-actuator-in-spring-boot-20)
	- only 3 Actuator endpoints are exposed by default. 这和 spring boot 1.0 不同
	- In order to expose all endpoints, we add the following configuration to the application.properties file: `management.endpoints.web.exposure.include=*`

- 访问地址： http://localhost:8080/actuator