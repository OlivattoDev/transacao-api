FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/transacao-api-0.0.1-SNAPSHOT.jar /app/transacao-api.jar

EXPOSE 8083

CMD [ "java", "-jar", "/app/transacao-api.jar" ]