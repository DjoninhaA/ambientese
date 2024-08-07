# Stage 1: Build stage using Maven
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /home/app
COPY src ./src
COPY pom.xml .
RUN mvn clean package -DskipTests | tee /tmp/maven.log


# Stage 2: Runtime stage
FROM openjdk:17-slim
WORKDIR /usr/local/lib
COPY --from=build /home/app/target/ambientese-0.0.1-SNAPSHOT.jar ./ambientese-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "./ambientese-0.0.1-SNAPSHOT.jar"]