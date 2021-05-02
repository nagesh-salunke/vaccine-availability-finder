FROM amazoncorretto:latest

COPY ./target/vaccine-alert-0.0.1-SNAPSHOT.jar /vaccine-alert.jar

EXPOSE 8080

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar", "/vaccine-alert.jar"]
