pipeline {
    agent any

    environment {
        ANDROID_HOME = "/Users/akshay/Library/Android/sdk"
        NODE_HOME    = "/Users/akshay/.nvm/versions/node/v18.20.8"
        MAVEN_HOME   = "/usr/local/Cellar/maven/3.9.11/libexec"

        PATH = "${NODE_HOME}/bin:${MAVEN_HOME}/bin:${ANDROID_HOME}/platform-tools:${env.PATH}"
    }

    stages {

        stage('Verify Device') {
    steps {
        sh '''
            adb kill-server
            adb start-server

            echo "Waiting for Android device..."
            adb wait-for-device

            DEVICE_COUNT=$(adb devices | grep -w "device" | wc -l)
            if [ "$DEVICE_COUNT" -eq 0 ]; then
              echo "❌ No Android device connected to Jenkins"
              adb devices
              exit 1
            fi

            adb devices
            adb shell getprop ro.build.version.release
        '''
    }
}


        stage('Verify Appium') {
            steps {
                sh '''
                    node -v
                    npm -v
                    appium --version
                '''
            }
        }

       stage('Start Appium') {
    steps {
        sh '''
            pkill -f appium || true
            sleep 3

            appium driver list --installed
            nohup appium --port 4723 --base-path /wd/hub > appium.log 2>&1 &
            sleep 10
        '''
    }
}


        stage('Build & Test') {
            steps {
                sh '''
                    mvn -version
                    mvn clean test
                '''
            }
        }
    }

    post {
        always {
            sh 'pkill -f appium || true'
        }
    }
}
