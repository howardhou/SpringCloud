# Config Server

- 分为服务端和客户端
	- 服务端，又叫分布式配置中心： 连接配置仓库（Git）, 为客户端提供配置信息、加密/解密信息等接口
	- 客户端，在启动的时候从配置中心获取配置信息
	
- 配置文件Git仓库： https://github.com/howardhou/config-repo
    - 配置文件命名规则： {application}-{profile}.properties , 例如： rongzi-prod.properties

-  Git 相关配置
	- 配置Git仓库路径：spring.cloud.config.server.git.uri=https://github.com/howardhou/config-repo.git
	- 配置子目录: spring.cloud.config.server.git.search-paths=""
	- 配置Git访问权限
		- spring.cloud.config.server.git.username=howardhou
		- spring.cloud.config.server.git.password=****
	- 配置本地存储： spring.cloud.config.server.git.basedir=/Users/dongdong/.config-repo
	
    - 测试URL
        - http://localhost:7001/rongzi/prod/config-label-test
        - http://localhost:7001/rongzi/dev
	
- 配置健康监测: http://localhost:7001/actuator/health

- 属性覆盖:  覆盖Git里面的配置信息，使用这里的配置数据
    - spring.cloud.config.server.overrides.form=shanghai
    
- 安全保护
	- 服务端配置
		- pom文件中添加依赖： spring-boot-starter-security
		- spring.security.user.name=user
		- spring.security.user.password=b7690c11-ca0a-4d64-b121-3c22013ccc54
	- Config 客户端配置
		- spring.cloud.config.username=user
		- spring.cloud.config.password=b7690c11-ca0a-4d64-b121-3c22013ccc54
	
- 加密解密	
	- 测试URL： 
		- GET http://localhost:7001/encrypt/status
		- POST http://localhost:7001/encrypt
		- POST http://localhost:7001/decrypt
        - GET http://localhost:7001/rongzi/prod ： 返回解密后的文案
        
        
- 第九章：消息总线
