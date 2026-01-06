pipeline {
    agent any

    environment {
        ANDROID_HOME = "/Users/akshay/Library/Android/sdk"
        NODE_HOME    = "/Users/akshay/.nvm/versions/node/v18.20.8"

        PATH = "${NODE_HOME}/bin:${ANDROID_HOME}/platform-tools:${env.PATH}"
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
                appium driver list --installed
                appium &
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
            sh 'pkill -f appium || true'
        }
    }
}
