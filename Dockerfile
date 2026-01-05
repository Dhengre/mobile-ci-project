FROM maven:3.9.9-eclipse-temurin-8

WORKDIR /app

COPY pom.xml .
RUN mvn -B -e -U dependency:resolve

COPY . .
RUN mvn clean test

CMD ["mvn", "test"]
