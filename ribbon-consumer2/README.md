# ribbon consumer 2 - hystrix

- 项目信息
	- http://localhost:9000/actuator/hystrix.stream
	- 此项目使用的 API 是 hello2 项目
	- Hystrix 配置，都测试过，都可以工作， 只是在 IDE 中没有提示

- 官方文档： http://cloud.spring.io/spring-cloud-netflix/single/spring-cloud-netflix.html

- Hystrix 原理分析： https://www.cnblogs.com/gaoyanqing/p/7470085.html
	- HystrixCommand : 用在返回单个操作结果
		- execute() ： 同步执行
		- queue() : 异步执行
	- HystrixObservableCommand : 用在返回多个操作结果
		- observe() : 返回 Hot Observable
		- toObservable() : 返回 Cold Observable

- 服务容错保护： Hystrix
    - 5. 断路器原理（熔断机制）：isOpen() 方法，是否打开断路器的条件
    	- 设置滚动时间窗的长度: hystrix.command.default.metrics.rollingStats.timeInMilliseseconds=10000
    	- 配置（在滚动时间窗内）请求数量的阈值，在阈值内不熔断: hystrix.command.default.circuitBreaker.requestVolumeThreshold=2
		- 配置（在滚动时间窗内）错误请求百分比的阈值，在阈值内不熔断: hystrix.command.default.circuitBreaker.errorThresholdPercentage=50
		- 配置断路器打开之后的休眠时间（当休眠时间到达后，将再次尝试访问，如果能访问成功则关闭断路器）: hystrix.command.default.circuitBreaker.sleepWindowInMilliseseconds=5000
		- 断路器强制打开: hystrix.command.default.circuitBreaker.forceOpen=false
		- 断路器强制关闭: hystrix.command.default.circuitBreaker.forceClosed=false
    - 3. 依赖隔离（故障隔离）：
    	- 设置依赖隔离策略，是线程池还是信号量: hystrix.command.default.execution.isolation.strategy=THREAD
    	- 线程池的隔离会为每一个依赖的服务创建一个独立的线程池，这样就算某个依赖的服务出现故障，也不会对其他依赖的服务产生影响
    - 4. 请求超时功能
    	- 配置超时时间：hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=5000
		- 配置是否启用超时时间：hystrix.command.default.execution.timeout.enabled=true
		- 执行超时的时候是否将它中断：hystrix.command.default.execution.isolation.thread.interruptOnTimeout=true
    - 1. 服务降级 - Hystrix Commond 执行失败后，调用的后备方法(callbackMethod)
    	- 配置服务降级是否开启，hystrix.command.default.fallback.enabled=true
    - 2. 异常处理 - 在callback方法中能够获得触发服务降级的异常
	- 请求缓存
	- 请求合并

- 基础知识
	- UML类图关系：https://www.cnblogs.com/alex-blog/articles/2704214.html
		- 关联关系（association）： https://www.cnblogs.com/shindo/p/5579191.html
			- 单向关联
			- 单向关联
			- 自关联
		- 聚合关系：属性，  关联关系和聚合关系在语法上是没办法区分的， 聚合关系是“has-a”关系，
		- 组合关系：私有变量， 合成关系也是关联关系的一种，是比聚合关系更强的关系。组合关系是“contains-a”关系。
		- 依赖关系（Dependency）： 与关联关系不同的是，依赖关系是以参数变量的形式传入到依赖类中的

	- [命令模式](https://www.cnblogs.com/f-zhao/p/6203208.html)
	
	- [观察者模式](https://blog.csdn.net/u011531613/article/details/64919263): Hystrix 大量的使用了 [RxJava](https://github.com/ReactiveX/RxJava/wiki)(响应式编程) 的 观察者-订阅者模式

	- [RxJava](https://github.com/ReactiveX/RxJava) ：Rx 是 Observables + LINQ + Schedulers ; [ReactiveX](http://reactivex.io/)结合了观察者模式、迭代器模式和函数式编程的精华
		- 参见[中文版文档](https://github.com/mcxiaoke/RxDocs) or  [English Document](https://github.com/ReactiveX/RxJava/wiki)
		- [Observable](https://github.com/mcxiaoke/RxDocs/blob/master/Observables.md) ： Rx扩展了观察者模式用于支持数据和事件序列，可以发射一系列的值，还添加了一些操作符
		- [Subject](https://github.com/mcxiaoke/RxDocs/blob/master/Subject.md) : 与观察者模式中的Subject不是一个含义
		- [操作符 Operators](https://github.com/mcxiaoke/RxDocs/blob/master/Operators.md)
			- [Create](https://github.com/mcxiaoke/RxDocs/blob/master/operators/Create.md)

		- [RxJava快速入门](https://www.jianshu.com/p/6a6f7a4be38d) : 一个请求接口的例子
		- [RxJava使用场景小结](https://blog.csdn.net/theone10211024/article/details/50435325)

	- [Java 并发编程](https://www.cnblogs.com/dolphin0520/category/602384.html)
		- [Callable、Future和FutureTask](http://www.cnblogs.com/dolphin0520/p/3949310.html)
		- [如何创建线程 - 继承Thread类；or 实现Runnable接口](https://www.cnblogs.com/dolphin0520/p/3913517.html)

	- [Java迭代: Iterator和Iterable接口](https://www.cnblogs.com/keyi/p/5821285.html)

	- 函数式编程

