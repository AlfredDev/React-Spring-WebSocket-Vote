FROM maven:3-eclipse-temurin-17-alpine AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests

FROM openjdk:17-alpine
COPY --from=builder /app/target/Vote-1.0.0.jar app.jar
CMD ["java","-jar","app.jar"]