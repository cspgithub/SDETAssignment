#FROM ubuntu:latest
FROM alpine:3.14

# Install required dependencies
RUN apk update
RUN apk add -y wget unzip curl dpkg


# Install Chrome for Selenium
#RUN curl https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb -o /chrome.deb
#RUN dpkg -i /chrome.deb || apt-get install -yf
#RUN rm /chrome.deb

# Install chromedriver for Selenium
#RUN curl https://chromedriver.storage.googleapis.com/2.31/chromedriver_linux64.zip -o /usr/local/bin/chromedriver
#RUN chmod +x /usr/local/bin/chromedriver

# Install OpenJDK-8
RUN apk update && \
    apk add -y openjdk-11-jdk && \
    apk add -y ant && \
    apk clean;
    
# Fix certificate issues
RUN apk update && \
    apk add ca-certificates-java && \
    apk clean && \
    update-ca-certificates -f;

# Setup JAVA_HOME -- useful for docker commandline
ENV JAVA_HOME /usr/lib/jvm/java-11-openjdk-amd64/
RUN export JAVA_HOME 

#maven
RUN apk add maven -y;

WORKDIR /app

ADD . /app

CMD  mvn -f demo/pom.xml clean test





