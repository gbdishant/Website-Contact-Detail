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
COPY --from=build /target/website-contact-detail-1.0.0.jar website-contact-detail.jar
# ENV PORT=8080
EXPOSE 9090
ENTRYPOINT ["java","-jar","website-contact-detail.jar"]