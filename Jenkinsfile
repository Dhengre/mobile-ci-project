pipeline {
    agent any

    stages {
        stage('Checkout SCM') {
            steps {
                checkout scm
            }
        }

        stage('Verify Device') {
            steps {
                sh 'adb devices'
            }
        }

        stage('Start Appium') {
            steps {
                sh '''
                appium --base-path /wd/hub --log-level info &
                sleep 10
                '''
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
