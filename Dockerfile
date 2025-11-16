# Use a small JDK image
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

# copy maven wrapper and pom first for caching dependencies
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# download dependencies (cached)
RUN chmod +x ./mvnw && ./mvnw -B -DskipTests dependency:go-offline

# copy source
COPY src ./src

# package the app
RUN ./mvnw -B -DskipTests package

# adjust jar name if different
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]

