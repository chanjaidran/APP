FROM openjdk:8
CMD chmod 666 /var/run/docker.sock
EXPOSE 8080
ADD target/logout-0.0.1-SNAPSHOT.jar logout-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/logout-0.0.1-SNAPSHOT.jar"]
