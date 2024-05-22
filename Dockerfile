# Use the official Maven image to create a build artifact.
# This image will have Maven and Java installed.
FROM maven:3.8.4-openjdk-17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and source code into the container
COPY pom.xml .
COPY src ./src

# Package the application
#RUN mvn clean package
RUN mvn clean package -DskipTests -B -e
# Use the official OpenJDK image to run the application
FROM openjdk:17-jdk-slim
# Use the official OpenJDK image for the amd64 architecture
#FROM openjdk:17-jdk-slim@sha256:1234567890123456789012345678901234567890123456789012345678901234

#FROM adoptopenjdk:11-jdk-hotspot

# Set the working directory in the container
WORKDIR /app

# Copy the jar file from the build stage
COPY --from=build /app/target/todo-ws.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
