FROM openjdk:17-alpine
WORKDIR /app

ADD target/akvelon-1.0-SNAPSHOT.jar app.jar

ENV JAVA_OPTS ""
ENTRYPOINT ["java", "-jar", "app.jar"]
