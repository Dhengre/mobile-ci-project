pipeline {
    agent any

    environment {
        ANDROID_HOME = "/Users/akshay/Library/Android/sdk"
        PATH = "${ANDROID_HOME}/platform-tools:${ANDROID_HOME}/tools:${env.PATH}"
    }

    stages {
        stage('Verify Device') {
            steps {
                sh '''
                adb version
                adb devices
                '''
            }
        }

        stage('Start Appium') {
            steps {
                sh '''
                appium --version
                appium driver list --installed
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
            sh 'pkill -f appium || true'
        }
    }
}
