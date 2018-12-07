# 基于哪个镜像
FROM java:8
# 作者
MAINTAINER "houdongdong"

# 添加 example 用户组 和 example 用户
RUN groupadd -r -g 2200 example && \
	useradd -rM -g example -u 2200 example

# 环境变量
ENV EUREKA_SERVER_LIST="http://eureka1:1111/eureka,http://eureka2:1111/eureka"
	
# 为镜像设置元数据
LABEL base.name="turbine" \
	  base.versioin="1.0.0"
	  
# 设置默认的工作目录
WORKDIR /app

# 复制文件到容器
ADD target/turbine-0.0.1-SNAPSHOT.jar app.jar

RUN chown example:example /tmp

VOLUME /tmp

# 声明要暴露的端口
EXPOSE 8989
#EXPOSE 8990

# 为接下来的构建步骤指定用户和用户组
USER example:example

# 容器启动后要执行的命令
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -jar app.jar --eureka-server-list=$EUREKA_SERVER_LIST

