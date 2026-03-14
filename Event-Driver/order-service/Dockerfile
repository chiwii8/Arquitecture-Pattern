FROM maven:3.9.3-eclipse-temurin-17 AS builder
WORKDIR /app/producer
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn package -DskipTests -B

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /app/producer/target/*.jar producer.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","producer.jar"]