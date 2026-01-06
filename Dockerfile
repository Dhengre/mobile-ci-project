FROM maven:3.9.11-eclipse-temurin-17

RUN apt-get update && apt-get install -y \
    android-tools-adb \
    nodejs npm \
    && npm install -g appium@2.19.0 \
    && appium driver install uiautomator2

WORKDIR /tests
COPY . .

CMD ["mvn", "clean", "test"]
