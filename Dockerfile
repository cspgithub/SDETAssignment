FROM openjdk:11
FROM maven:alpine

WORKDIR /app
ADD pom.xml /app
RUN  mvn -f demo/pom.xml clean compile

COPY . /app

CMD  mvn -f demo/pom.xml test


