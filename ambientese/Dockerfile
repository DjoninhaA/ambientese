FROM openjdk:17-slim

RUN apt-get update && apt-get install -y maven

WORKDIR /app

COPY . .
RUN mvn package && mvn --no-transfer-progress package -DskipTests=true -DexcludeCompile=org.projectlombok:lombok

COPY target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
