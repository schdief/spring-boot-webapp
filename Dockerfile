# Use eclipse-temurin:21-jdk as the base image
FROM eclipse-temurin:21-jdk

# Copy the application JAR file to the container
COPY target/demo-0.0.1-SNAPSHOT.jar /app/demo.jar

# Set the entry point to run the JAR file
ENTRYPOINT ["java", "-jar", "/app/demo.jar"]
