# Hystrix Dashboard
    
- 支持3种不同的监控信息
    - 默认的集群监控
    - 指定的集群监控
    - 单体应用的监控： 实现对具体某个服务实例的监控

- 使用方法
    - 运行 ribbon-consumer2 项目和本项目
    - 打开网页： http://localhost:2001/hystrix
        - Delay: 服务器上轮询监控信息的延迟时间
        - Title: 对应Hystrix Stream 的名字    
    - 输入URL： http://localhost:9000/actuator/hystrix.stream
    - 点击 Monitor Stream 按钮， 进入监控页面