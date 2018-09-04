FROM openjdk:8-jdk-alpine
ENV SPRING_DATA_MONGODB_URI=mongodb://mongo/demodb
EXPOSE 8080
VOLUME /tmp
ADD ./target/product-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
