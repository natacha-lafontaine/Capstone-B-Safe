pipeline {
    environment {
        dockerImage = ''
        imagename = 'capstone-b-safe'
        dockerRegistry = 'https://hub.docker.com/repository/docker/nlafontaine/capstone-b-safe'
    }
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
        stage('Build Image') {
            steps {
                script {
                    dockerImage = docker.build imagename
                }
            }
        } 
        stage('Publish Image') {
            steps {
                script {
                    docker.withRegistry(dockerRegistry) {
                        dockerImage.push("$env:BUILD_NUMBER")
                        dockerImage.push('latest')
                    }
                }
            }
        }  
    }
}