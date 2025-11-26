FROM eclipse-temurin:21-jre
ARG JAR_FILE=target/video-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENV SPRING_PROFILES_ACTIVE=mysql
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "/app.jar"]
