From openjdk:8-alpine

workdir /app 

copy .mvn ./.mvn
copy mvnw pom.xml ./ 
copy src ./src
expose 8088
CMD ["./mvnw", "spring-boot:run", "-Dmaven.test.skip=true -DAppLogDir=/opt/ -Dspring.profiles.active=local"]

