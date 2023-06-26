FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/Connection2Connection-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} connection2connection.jar
ENTRYPOINT ["java","-jar","/connection2connection.jar"]