# Etapa 1: Construye la aplicación Spring Boot
FROM maven:3.8.1-openjdk-17-slim AS build
WORKDIR /Vote
COPY src /Vote/src
COPY pom.xml /Vote
RUN mvn clean package -DskipTests

# Etapa 2: Crea la imagen final de la aplicación
FROM openjdk:17-jdk-alpine
ENV PROFILE=dev
COPY --from=build /Vote/target/*.jar /usr/local/lib/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILE}", "-jar", "/usr/local/lib/app.jar"]
