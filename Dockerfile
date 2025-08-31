# Stage 1: Build the application using Maven and JDK 17
FROM maven:3.9.4-eclipse-temurin-17 AS build

# Set working directory inside the container
WORKDIR /order-service

# Copy Maven wrapper and pom.xml
COPY order-service/pom.xml .
COPY order-service/.mvn .mvn
COPY order-service/mvnw .

# Fix permission issue for mvnw
RUN chmod +x mvnw

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy the source code
COPY order-service/src ./src

# Build the application
RUN ./mvnw clean package -DskipTests

# Stage 2: Run the application using a lightweight JDK 17 image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /order-service

# Copy the built jar file
COPY --from=build /order-service/target/order-service.jar order-service.jar

# Expose the application port
EXPOSE 9191

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "order-service.jar"]
