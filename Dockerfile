FROM ubuntu:latest

# Install required dependencies
RUN apt-get update
RUN apt-get install -y wget unzip curl dpkg


# Install Chrome for Selenium
#RUN curl https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb -o /chrome.deb
#RUN dpkg -i /chrome.deb || apt-get install -yf
#RUN rm /chrome.deb

# Install chromedriver for Selenium
#RUN curl https://chromedriver.storage.googleapis.com/2.31/chromedriver_linux64.zip -o /usr/local/bin/chromedriver
#RUN chmod +x /usr/local/bin/chromedriver

# Install OpenJDK-8
RUN apt-get update && \
    apt-get install -y openjdk-11-jdk && \
    apt-get install -y ant && \
    apt-get clean;
    
# Fix certificate issues
RUN apt-get update && \
    apt-get install ca-certificates-java && \
    apt-get clean && \
    update-ca-certificates -f;

# Setup JAVA_HOME -- useful for docker commandline
ENV JAVA_HOME /usr/lib/jvm/java-11-openjdk-amd64/
RUN export JAVA_HOME 

#maven
RUN apt-get install maven -y;

WORKDIR /app

ADD . /app

CMD  mvn -f demo/pom.xml clean test



