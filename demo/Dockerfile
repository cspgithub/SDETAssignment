FROM    maven:3.8.1-jdk-8

RUN     mkdir /docker

WORKDIR /app

COPY    . /app
RUN     mvn dependency:resolve


RUN     mvn clean compile
CMD     mvn clean verify