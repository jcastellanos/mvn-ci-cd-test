FROM maven:3.6.3-jdk-11-slim as BUILD
WORKDIR /usr/src/app
COPY checkstyle.xml .
COPY checkstyle-supressions.xml .
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src src
RUN mvn -B -e -C -T 1C package

# Start with a base image containing Java runtime
FROM openjdk:11.0.6-buster

# Add Maintainer Info
LABEL maintainer="jcastellanos"
RUN sed -i 's/main/main contrib/g' /etc/apt/sources.list && apt-get update && apt-get install -y msttcorefonts && apt-get install -y ttf-mscorefonts-installer && fc-cache
# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

ENV DATABASE_HOST localhost
ENV DATABASE_PORT 3306
ENV DATABASE_NAME kaizen
ENV DATABASE_USER kaizen
ENV DATABASE_PASSWORD kaizen
ENV DATABASE_POOL 64


# The application's jar file
COPY --from=BUILD /usr/src/app/target/*jar  api.jar

# Run the jar file 
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=prod", "-jar","/api.jar"]
