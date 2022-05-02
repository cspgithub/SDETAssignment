FROM java:latest
FROM maven:alpine

WORKDIR /app
ADD . /app

RUN mvn clean compile

CMD mvn test


