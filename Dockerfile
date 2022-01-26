FROM openjdk:11
ARG JAR_FILE=target/gcp-bigquery-springboot-crud-app-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} gcp-bigquery-springboot-crud-app.jar
ENTRYPOINT ["java","-jar","/gcp-bigquery-springboot-crud-app.jar"]