FROM maven:3-openjdk-17 as build-image 
WORKDIR /to-build-app
COPY . .
RUN ./mvnw clean package 

FROM eclipse-temurin:17-jre-jammy
WORKDIR /app 
COPY --from=build-image /app/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
