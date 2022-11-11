FROM eclipse-temurin:17-jdk-alpine
RUN addgroup -S jenkins && adduser -S jenkins -G jenkins
USER jenkins:jenkins
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]