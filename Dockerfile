FROM openjdk:21-jdk
WORKDIR /app
COPY ./target/*.war /app
EXPOSE 9695
CMD ["java", "-jar", "Docker-MySql.war"]