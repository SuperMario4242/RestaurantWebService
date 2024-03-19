FROM openjdk:21

# Set the working directory in the container
WORKDIR /app

# Copy the packaged jar file from the builder stage
COPY target/restaurant-0.0.1-SNAPSHOT.jar restaurant-0.0.1-SNAPSHOT.jar

# Expose the port
EXPOSE 80

# Command to run the application
CMD ["java", "-jar", "restaurant-0.0.1-SNAPSHOT.jar"]
