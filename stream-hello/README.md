# Spring Cloud Stream

- [Spring为什么Autowired注入的是接口](https://blog.csdn.net/luman1991/article/details/54844969)
	- 接口只有一个实现的话，那么spring框架可以自动将interface于实现组装起来
	- 一个接口有多个实现，那么就需要每个特殊化识别并且在自动装载过程中使用@Qualifier和@Autowired一起使用来标明

- 书上的例子报错： spring cloud stream @Input(Sink.INPUT) and @Output(Sink.INPUT) have Bean already exists
	- 原因：同一个项目中不能存在同名的Binding，可能是因为一个项目中没必要使用 MQ 
	- 解决方法是： 创建一个 stream-productor 项目， Binding到 input 通道，用来发送消息

	