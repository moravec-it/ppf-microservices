FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=*.jar
COPY ../target/ppf-microservices-1.1.jar ./ppf-microservices.jar
ENTRYPOINT ["java", "-jar", "ppf-microservices.jar"]
