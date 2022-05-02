FROM openjdk:11
FROM maven:alpine

WORKDIR /app
ADD demo /app
RUN  mvn verify clean

CMD  mvn -f demo/pom.xml test


