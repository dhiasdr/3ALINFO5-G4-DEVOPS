FROM openjdk:8-jdk-alpine
EXPOSE 8082
ADD target/timesheet-devopsG4-1.0.jar timesheet-devopsG4-1.0.jar
ENTRYPOINT ["java","-jar","/timesheet-devopsG4-1.0.jar"]
