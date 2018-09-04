FROM openjdk:8-jdk-alpine
ENV SPRING_DATA_MONGODB_URI=mongodb://mongo/demodb
EXPOSE 8080
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
