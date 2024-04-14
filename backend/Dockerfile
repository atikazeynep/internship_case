FROM openjdk:11-jdk

WORKDIR /app

# Copy only the necessary files for building the application
COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .

# Download Maven dependencies
RUN ./mvnw dependency:go-offline

# Copy the rest of the application source code
COPY src src

# Build the application
RUN ./mvnw package -DskipTests

# Define the command to run the application
CMD ["java", "-jar", "target/backend-0.0.1-SNAPSHOT.jar"]
