pipeline {
    agent { label 'java17'}

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
                echo 'add deployment step later'
            }
        }   
    }
}