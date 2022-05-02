FROM openjdk:11
FROM maven:alpine

WORKDIR /app
ADD . /app

RUN  mvn -f demo/pom.xml clean compile

CMD  mvn -f demo/pom.xml test


