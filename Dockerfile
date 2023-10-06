#
# Build stage
#
FROM maven:3.8.2-jdk-11 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM openjdk:11-jdk-slim
COPY --from=build /target/*.jar website-contact-detail.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","website-contact-detail.jar"]
