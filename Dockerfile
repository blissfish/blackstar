FROM openjdk:8
MAINTAINER blissfish <mark.evertz@gmx.de>

# Keep consistent with build.gradle 
ENV APP_JAR_NAME blackstar
ENV APP_JAR_VERSION 3.0.0-SNAPSHOT

COPY target/${APP_JAR_NAME}-${APP_JAR_VERSION}.jar /app.jar

EXPOSE 8080/tcp
ENTRYPOINT ["java", "-jar", "/app.jar"]