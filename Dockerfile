FROM openjdk:8
CMD chmod 666 /var/run/docker.sock
EXPOSE 8080
ADD target/devops-integration.jar devops-integration.jar
ENTRYPOINT ["java","-jar","/LoginRegistration.jar"]
