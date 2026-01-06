pipeline {
    agent any

    environment {
        ANDROID_HOME = "$HOME/Library/Android/sdk"
        PATH = "$ANDROID_HOME/platform-tools:$PATH"
    }

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/Dhengre/mobile-ci-project.git'
            }
        }

        stage('Verify Device') {
            steps {
                sh 'adb devices'
            }
        }

        stage('Start Appium') {
            steps {
                sh 'appium --log-level error &'
                sleep 10
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean test'
            }
        }
    }

    post {
        always {
            sh 'pkill -f appium || true'
        }
    }
}
