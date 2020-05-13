FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/configmap.jar configmap.jar
ENTRYPOINT ["java","-jar","configmap.jar"]