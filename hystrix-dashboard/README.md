# Hystrix Dashboard

- http://localhost:2001/hystrix
    - Delay: 服务器上轮询监控信息的延迟时间
    - Title: 对应Hystrix Stream 的名字    
	- 输入监控 URL 
    
- 支持3种不同的监控信息
	- 默认的集群监控： 实现对默认集群的监控
		- 运行 turbine 项目
		- http://localhost:8989/turbine.stream
	
	- 指定的集群监控： 实现对特定集群的监控

	- 单体应用的监控： 实现对具体某个服务实例的监控
		- 运行 ribbon-consumer2 项目
		- http://localhost:9000/actuator/hystrix.stream

    