pipeline {
  agent any
  options {
    disableConcurrentBuilds()
    timeout(time: 10, unit: 'MINUTES')
  }
  tools {
    maven 'maven 3.6.0'
  }
  stages {
    stage('Verify Tools') {
      steps {
        parallel (
          java: {
            sh 'java -version'
            sh 'which java'
          },
          maven: {
            sh 'mvn -version'
            sh 'which mvn'
          },
          docker: {
            sh 'docker --version'
            sh 'which docker'
          }
        )
      }
    }
    stage('Build') {
      steps {
          sh 'mvn package -DskipTests -f .'
          archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
      }
    }

    stage('Test') {
      steps {
        sh 'mvn test -f .'
      }
      //post {
      //  always {
      //    junit '** /target/surefire-reports/*.xml'
      //  }
      //}
    }

    stage('Create Image') {
       steps {
         sh 'chmod -R 777 .'
         sh 'docker rm -f java_api || true'
         sh 'docker build -t java_api .'
         sh 'docker image prune -f'
       }
     }
  }
}