# Use a base image with Java installed
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy the application's JAR file into the container
COPY target/bank-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your application listens on
EXPOSE 8080

# Define the command to run your application when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]
