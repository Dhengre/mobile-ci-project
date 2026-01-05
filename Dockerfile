FROM appium/appium:latest

WORKDIR /app
COPY . .

RUN mvn clean compile

CMD ["mvn", "test"]
