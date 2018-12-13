# Get latest java image
FROM java:8
EXPOSE 8090
COPY ./MovieDatabaseBackend/target/*.jar ./app.jar
CMD ["/usr/bin/java", "-jar", "app.jar"]