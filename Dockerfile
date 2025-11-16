# Use Java 17
FROM openjdk:17-jdk-slim

# Copy project files
WORKDIR /app
COPY . .

# Build the project
RUN ./mvnw -DskipTests package

# Run the jar
CMD ["java", "-jar", "target/moodtracker-0.0.1-SNAPSHOT.jar"]
