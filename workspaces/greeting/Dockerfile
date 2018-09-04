FROM openjdk:8-jdk-alpine
EXPOSE 8080
VOLUME /tmp
#ARG JAR_FILE
#ADD ${JAR_FILE} app.jar
COPY ./target/gs-rest-service-0.1.0.jar /app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]