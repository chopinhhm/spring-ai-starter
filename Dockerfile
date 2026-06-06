FROM eclipse-temurin:17-jre-alpine
LABEL maintainer="chopinhhm"
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java -jar app.jar"]
