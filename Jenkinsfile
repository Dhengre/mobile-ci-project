pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/Dhengre/mobile-ci-project.git',
                    branch: 'main'
            }
        }

        stage('Build & Test') {
            steps {
                echo 'Running build and tests'
                sh 'mvn clean test'
            }
        }
    }

    post {
        success {
            echo 'Build successful'
        }
        failure {
            echo 'Build failed'
        }
    }
}
