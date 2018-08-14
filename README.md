# SpringCloud

- eureka-server : 服务治理的 注册中心

- hello : Spring Boot 项目， 包括 actutor 服务监控功能
- hello2 : 服务治理的客户端， 想注册中心注册本服务

- ribbon-consumer : 客户端负载均衡 和 重试机制
- ribbon-consumer2 ： 增加 hystrix 功能 - 增加服务容错保护

- hystrix-dashboard ： hystrix 的 监控面版

- turbine ： 集群监控时使用， 收集集群的监控信息后，将信息传给  hystrix 的 监控面版



## ISSUE
- warning: push.default is unset; its implicit value is changing in Git 2.0 from 'matching' to 'simple'
	- Git2.0以后: git config --global push.default simple   , [设置默认行为为simple](https://blog.csdn.net/u010828718/article/details/51161802)
    - Git2.0以前: git config --global push.default matching  

- [让git push命令不再每次都输入密码](https://blog.csdn.net/itmyhome1990/article/details/42557817)
	- Github获取远程库时，有ssh方式和https方式
	- 使用ssh 方式
		- git remote rm origin
		- git remote add origin git@github.com:howardhou/SpringCloud.git

	- 使用https 方式 ： 参见： http://www.cnblogs.com/zhonghuasong/p/5975952.html
	 	- cd ~
		- touch .git-credentials
		- vim .git-credentials
		- https://{username}:{password}@github.com
		- git config --global credential.helper store
		- 修改 ~/.gitconfig 文件 

- [Connecting to GitHub with SSH](https://help.github.com/articles/connecting-to-github-with-ssh/)
	- [Generating a new SSH key](https://help.github.com/articles/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent/)
		- ssh-keygen -t rsa -b 4096 -C "21689620@qq.com"
	- A[dding a new SSH key to your GitHub account](https://help.github.com/articles/adding-a-new-ssh-key-to-your-github-account/)
		- 复制ssh public key : pbcopy < ~/.ssh/id_rsa.pub
	- [Testing your SSH connection](https://help.github.com/articles/testing-your-ssh-connection/)
		- ssh -T git@github.com


## IDE IntelliJ IDEA
- [Download IntelliJ IDEA](https://www.jetbrains.com/idea/download/#section=mac)
	- 应该下载 Ultimate 版， Community版功能不全, 没有Java， Spring项目

- [2018 IntelliJ IDEA 最新激活码](https://www.jianshu.com/p/48f637869456)
	- 注意： 要修改 hosts 文件： `0.0.0.0 account.jetbrains.com`

- Spring Framework 下载地址
	- http://repo.spring.io/libs-release-local/org/springframework/spring/
	- http://central.maven.org/maven2/org/springframework/spring-test/5.0.8.RELEASE/
