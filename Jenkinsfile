pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/salmannsharif/JiraPayloadMapping.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build -t jira-mapping:latest .'
                }
            }
        }

        stage('Run Container') {
            steps {
                sh 'docker run -d -p 8082:8080 jira-mapping:latest'
            }
        }
    }
}
