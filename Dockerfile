# Use an official OpenJDK image as base
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the jar file into the container
COPY target/order-service.jar order-service.jar

# Expose the port your app runs on
EXPOSE 9191

# Run the jar file
ENTRYPOINT ["java", "-jar", "order-service.jar"]
