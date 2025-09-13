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

        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-cred', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    // Use password via --password-stdin (more secure)
                    bat "echo %DOCKER_PASS% | docker login -u %DOCKER_USER% --password-stdin"
                    bat 'docker push rashmitasubedi/bank:latest'
                }
            }
        }

    stage('Deploy to Kubernetes') {
            steps {
                script {
                    kubernetesDeploy(
                        configs: 'k8s/deployment.yaml,k8s/service.yaml'
                        kubeconfigId: 'k8sconfigpwd'
                    )
                }
            }
        }
    post {
        always {
            cleanWs()
        }
    }
}