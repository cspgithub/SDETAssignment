FROM openjdk:11
FROM maven:alpine

WORKDIR /app
ADD . /app
RUN  mvn verify clean --fail-never

COPY . /app

CMD  mvn -f demo/pom.xml test


