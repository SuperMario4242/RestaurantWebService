#FROM openjdk:21-jdk as builder
#
#WORKDIR /app
#
#COPY pom.xml .
#
#COPY . .
#
#RUN ./mvnw clean package -DskipTests
#
#
#FROM openjdk:21-jdk
#
## Set the working directory in the container
#WORKDIR /app
#
#COPY --from=builder /target/*.jar /app/restaurant.jar
#
#EXPOSE 80
#ENTRYPOINT ["java", "-jar","restaurant.jar"]


# Use an appropriate base image for Java
FROM openjdk:21-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven Wrapper and project POM file

COPY pom.xml .

# Download dependencies and create a layered Docker cache to speed up builds
RUN ./mvnw dependency:go-offline

# Copy the project source code
COPY src src

# Build the project with Maven
RUN ./mvnw clean package -DskipTests

# Specify the JAR file name here
ARG JAR_FILE=target/restaurant.jar

# Copy the JAR file to a desired location
RUN cp ${JAR_FILE} restaurant.jar

# Expose the port your Spring Boot application runs on
EXPOSE 80

# Define the command to run your application
CMD ["java", "-jar", "restaurant.jar"]