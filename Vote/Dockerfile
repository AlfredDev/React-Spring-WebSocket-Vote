FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/Vote-1.0.0.jar
COPY ${JAR_FILE} app_vote.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_vote.jar"]