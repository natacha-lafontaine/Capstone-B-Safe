pipeline {
    environment {
        dockerImage = ''
        imageName = 'capstone-b-safe'
        dockerRegistry = 'https://hub.docker.com/repository/docker/nlafontaine/capstone-b-safe'
        imageTag = "${env.BUILD_NUMBER}"
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
                    dockerImage = docker.build imageName
                }
            }
        } 
        stage('Publish Image') {
            steps {
                script {
                    docker.withRegistry(dockerRegistry) {
                        dockerImage.push(imageTag)
                        dockerImage.push('latest')
                    }
                }
            }
        }  
    }
}