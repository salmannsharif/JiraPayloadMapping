pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'master', url: 'https://github.com/salmannsharif/JiraPayloadMapping.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

//         stage('Build Docker Image') {
//             steps {
//                 script {
//                     sh 'docker build -t jira-mapping:latest .'
//                 }
//             }
//         }
//
//         stage('Stop and Remove Old Container') {
//             steps {
//                 script {
//                     sh '''
//                         docker stop jira-mapping-container || true
//                         docker rm jira-mapping-container || true
//                     '''
//                 }
//             }
//         }
//
//         stage('Run Container') {
//             steps {
//                 script {
//                     // Port mapping: host:container
//                     // Your app runs on 8081 inside container
//                     sh 'docker run -d --name jira-mapping-container -p 8082:8081 jira-mapping:latest'
//                 }
//             }
//         }
//
//         stage('Verify Deployment') {
//             steps {
//                 script {
//                     sh 'docker ps | grep jira-mapping-container'
//                     echo 'Application deployed successfully!'
//                     echo 'Access the application at: http://localhost:8082'
//                 }
//             }
//         }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
            echo 'Application is running at http://localhost:8082/jira/callback'
        }
        failure {
            echo 'Pipeline failed. Check logs for details.'
        }
    }
}