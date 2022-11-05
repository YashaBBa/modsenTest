FROM openjdk:17
COPY target/modsen-0.0.1-SNAPSHOT.jar modsen.jar
ENTRYPOINT ["java","-jar","/modsen.jar"]


All