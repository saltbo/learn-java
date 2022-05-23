FROM openjdk:11.0-jre-slim

WORKDIR /srv
COPY target/*.jar .

CMD ["/bin/bash", "-c", "java -jar *.jar"]