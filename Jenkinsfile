pipeline {
    agent any

    environment {
        ANDROID_HOME = "${HOME}/Library/Android/sdk"
        PATH = "${ANDROID_HOME}/platform-tools:${env.PATH}"
    }

    stages {

        stage('Checkout SCM') {
            steps {
                checkout scm
            }
        }

        stage('Verify Device') {
            steps {
                sh '''
                    echo "Cleaning old ADB processes..."
                    pkill adb || true
                    sleep 2

                    echo "Starting ADB server..."
                    adb start-server

                    echo "Waiting for Android device..."
                    adb wait-for-device

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
                    appium driver list --installed
                '''
            }
        }

        stage('Start Appium') {
            steps {
                sh '''
                    pkill -f appium || true
                    sleep 3
                    nohup appium --port 4723 > appium.log 2>&1 &
                    sleep 10
                '''
            }
        }

        stage('Build & Test') {
            steps {
                sh '''
                    mvn clean test
                '''
            }
        }
    }

    post {
        always {
            sh '''
                echo "Stopping Appium..."
                pkill -f appium || true
            '''
        }
    }
}
