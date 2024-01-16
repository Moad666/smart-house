FROM openjdk:17
EXPOSE 8080
ADD target/smart-house.jar smart-house.jar
ENTRYPOINT ["java", "-jar", "/smart-house.jar"]
