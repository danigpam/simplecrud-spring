FROM docker.io/centos:8

LABEL maintainer="Danielle Martin <danigpam@br.ibm.com>" \
    io.openshift.tags="java,spring,h2" \
    io.k8s.description="A simple Java CRUD for testing OpenShift" \
    io.openshift.expose-services="8080:http" \
    openshift.io/display-name="Simple Java CRUD"

ENV APP_PROFILE="default" \
    JAVA_HOME="/opt/jdk-11.0.2" \
    MAVEN_HOME="/opt/apache-maven-3.6.3" \
    PATH="$PATH:$MAVEN_HOME/bin:$JAVA_HOME/bin"

WORKDIR "/opt"

COPY [ "scripts/entrypoint.sh", "/opt/entrypoint.sh" ]

RUN yum update -y && \
    yum upgrade -y && \
    yum install -y wget tar git && \
    git clone https://github.com/thaalesalves/simplecrud-spring.git && \
    wget https://downloads.apache.org/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz && \
    wget https://download.java.net/java/GA/jdk11/9/GPL/openjdk-11.0.2_linux-x64_bin.tar.gz && \
    tar xvzf apache-maven-3.6.3-bin.tar.gz && \
    tar xvzf openjdk-11.0.2_linux-x64_bin.tar.gz && \
    chmod -R +x $MAVEN_HOME/bin && \
    chmod -R +x $JAVA_HOME/bin && \
    mkdir /.m2 && \
    $MAVEN_HOME/bin/mvn clean install -f /opt/simplecrud-spring/pom.xml && \
    chown 1001:0 -R /opt /.m2 && \
    chmod g=u -R /opt /.m2

EXPOSE 8080

USER 1001
ENTRYPOINT [ "sh", "/opt/entrypoint.sh" ]