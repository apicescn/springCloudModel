# 基于那个镜像--这里特别要注意，这里的FROM采用国内的docker镜像，如果连国外的docker镜像下载，基本是不太可能下载下来的，原因大家都知道。
FROM java:8
# 将本地文件夹挂载到当前容器（tomcat使用）
VOLUME /tmp
# 拷贝文件到容器
ADD web-service-1.0.0.jar webService.jar
RUN bash -c 'touch /webService.jar'
 #健康检查
#HEALTHCHECK  --interval=5s --timeout=3s
# 打开服务端口
EXPOSE 9000


# 配置容器启动后执行的命令
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/webService.jar"]
