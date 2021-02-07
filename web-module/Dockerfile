FROM bellsoft/liberica-openjdk-alpine:11.0.10
RUN addgroup -S spring && adduser -S pinchPenny -G spring
USER pinchPenny:spring
EXPOSE 8080
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} pinchpennyApp.jar
ENTRYPOINT ["java", "-jar", "pinchpennyApp.jar"]