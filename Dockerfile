FROM openjdk:8-jdk-alpine
COPY ./build/libs/springsecurityinaction.jar ./
ENTRYPOINT ["java"]
CMD ["-jar", "/springsecurityinaction.jar"]
EXPOSE 8080