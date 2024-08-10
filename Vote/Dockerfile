# Etapa 1: Construye la aplicación Spring Boot
FROM maven:3.8.1-openjdk-17-slim AS build
WORKDIR /server
COPY src /server/src
COPY pom.xml /server
RUN mvn clean package -DskipTests

# Etapa 2: Crea la imagen final de la aplicación
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /server/target/Vote-1.0.0.jar /app/app_vote.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app_vote.jar"]
