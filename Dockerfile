FROM openjdk:8-jdk-alpine

## will mount project to /app
WORKDIR /app

## enable mvnw executable and build with maven 
RUN chmod u+x ./mvnw && \
./mvnw clean package -Dmaven.test.skip=true
CMD ["./mvnw", "spring-boot:run", "-Dspring.profiles.active=local", "-DAppLogDir=/opt/log/"]