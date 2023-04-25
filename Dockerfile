FROM amazoncorretto:11-alpine-jdk as builder

WORKDIR /app/msvc-entities

COPY ./pom.xml /app
COPY ./msvc-entities/.mvn ./.mvn
COPY ./msvc-entities/mvnw .
COPY ./msvc-entities/pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
# RUN ./mvnw dependency:go-offline
COPY ./msvc-entities/src ./src
RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/msvc-entities/target/msvc-entities.jar .
EXPOSE 8003
ENTRYPOINT ["java","-jar","msvc-entities.jar"]


# docker build -t msvc-entities . -f ./msvc-entities/Dockerfile-v3
# docker run -d -p 8003:8003 --rm --name msvc-entities --network spring msvc-entities