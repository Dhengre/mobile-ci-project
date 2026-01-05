pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build Image') {
            steps {
                sh 'docker build -t mobile-tests .'
            }
        }

        stage('Run Tests on Real Device') {
            steps {
                sh '''
                docker run --rm --privileged \
                  -v /dev/bus/usb:/dev/bus/usb \
                  -v ~/.android:/root/.android \
                  -p 4723:4723 \
                  mobile-tests
                '''
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
