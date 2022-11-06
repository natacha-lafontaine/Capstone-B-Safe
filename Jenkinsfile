pipeline {
    environment {
        dockerImage = ''
        imageName = 'nlafontaine/capstone-b-safe'
        registryCred = 'Dockerhub'
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
                    dockerImage = docker.build imageName + ':' + imageTag
                }
            }
        } 
        stage('Publish Image') {
            steps {
                script {
                    docker.withRegistry('', registryCred) {
                        dockerImage.push(imageTag)
                        dockerImage.push('latest')
                    }
                }
            }
        }  
    }
}