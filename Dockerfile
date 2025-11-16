# ====== BUILD STAGE ======
FROM eclipse-temurin:17-jdk AS build

WORKDIR /app

# Copy everything
COPY . .

# Give execute permissions
RUN chmod +x mvnw

# Build the jar
RUN ./mvnw -B -DskipTests package


# ====== RUN STAGE ======
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
