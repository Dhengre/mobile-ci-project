FROM maven:3.9.6-eclipse-temurin-17

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
COPY Jenkinsfile .
COPY README.md .

RUN mvn clean compile

CMD ["mvn", "test"]
