FROM openjdk:8-jdk-alpine

## will mount project to /app
WORKDIR /app

EXPOSE 8088

copy .mvn/ .mvn/
COPY mvnw mvnw
COPY src/ src/
copy pom.xml pom.xml 

## enable mvnw executable and build with maven 
RUN chmod u+x ./mvnw && \
mkdir -p /opt/log && \
./mvnw clean package -Dmaven.test.skip=true

CMD ["java" ,"-jar", "-Dspring.profiles.active=local","-DAppLogDir=/opt/log", "./target/tempForm-0.0.1-SNAPSHOT.jar"]
#CMD ["./mvnw"  ,"spring-boot:run", "-Dspring.profiles.active=local", "-DAppLogDir=/opt/log/"]
