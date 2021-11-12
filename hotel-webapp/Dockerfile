FROM openjdk:11
WORKDIR /app

ARG JAR_FILE

COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]