FROM openjdk:10

WORKDIR /
ADD petclinic-web/build/libs/petclinic-web-0.0.1-SNAPSHOT.jar petclinic-web-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","petclinic-web-0.0.1-SNAPSHOT.jar"]