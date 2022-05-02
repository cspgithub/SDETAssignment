FROM openjdk:11
FROM maven:alpine

WORKDIR /app
ADD demo/pom.xml /app
RUN  mvn verify clean --fail-never

CMD  mvn -f demo/pom.xml test


