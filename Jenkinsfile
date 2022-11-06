pipeline {
    agent { label 'Java17'}

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/natacha-lafontaine/Capstone-B-Safe.git'
            }
        }
        stage('Compile') {
            steps {
                sh 'mvn -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                docker.withRegistry('https://hub.docker.com/repository/docker/nlafontaine/capstone-b-safe')
                docker.build("b-safe:${env.BUILD_ID}").push('latest')
            }
        }   
    }
}