FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=*.jar
COPY ppf-microservices.jar ppf-microservices.jar
ENTRYPOINT ["java", "-jar", "ppf-microservices.jar"]
