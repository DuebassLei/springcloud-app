FROM java:8

#持久化到指定目录
VOLUME /tmp

# 将工程jar包（eureka-service-1.0-SNAPSHOT.jar）拷贝到 app.jar中
COPY target/eureka-server-1.0-SNAPSHOT.jar  app.jar

RUN bash  -c "touch /app.jar"

EXPOSE  8761
# 执行jar包  "-Djava.security.egd=file:/dev/./urandom"加快随机数产生过程

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]