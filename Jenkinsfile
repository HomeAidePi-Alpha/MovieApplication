pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                git 'https://github.com/clh7090/MovieApplication.git'
                sh './springboot-backend/mvnw/mvnw clean compile'
            }
        }
        stage('Test') {
            steps {
                sh './springboot-backend/mvnw test'
            }

            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
    }
}