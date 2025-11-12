pipeline {
  agent {
    docker {
      image 'maven:3.9.6-eclipse-temurin-17'
      args '-v /var/run/docker.sock:/var/run/docker.sock'
    }
  }

  stages {
    stage('Setup Docker CLI') {
      steps {
        sh '''
          apt-get update
          apt-get install -y docker.io
        '''
      }
    }

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
        sh 'docker build -t jira-mapping:latest .'
      }
    }

    stage('Run Container') {
      steps {
        sh 'docker run -d -p 8082:8080 jira-mapping:latest'
      }
    }
  }
}
