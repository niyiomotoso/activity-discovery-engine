# Use the official OpenJDK 17 image as the base image
FROM amazoncorretto:17.0.7-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the entire application directory to the container
COPY . .
# Expose the port that the Spring Boot app listens on
EXPOSE 9595
# Build the Spring Boot app using Gradle
CMD ["./gradlew", "bootRun"]
