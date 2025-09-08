pipeline {
    agent any

    tools {
        maven 'maven_3_6_3'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/rashuuuuuu/bank.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t rashmitasubedi/bank:latest .'
            }
        }

        stage('Push image to Hub') {
            steps {
                bat 'docker login -u rashmitasubedi -p rashmita@123'
                bat 'docker push rashmitasubedi/bank:latest'
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}
