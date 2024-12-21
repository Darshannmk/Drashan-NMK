FROM maven:3.8.4-openjdk-17 AS build
COPY . /app
WORKDIR /app
RUN ./mvnw clean install
FROM openjdk:17-jdk-slim
COPY --from=build /app/target/backend-1.0-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
