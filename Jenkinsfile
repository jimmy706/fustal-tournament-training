pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {
        stage ('Initialize') {
            steps {
                step {
                    sh 'java --version'
                }
            }
        }

        stage ('Build') {
            steps {
                step {
                    sh 'mvn -Dmaven.test.failure.ignore=true install'
                }
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml'
                }
            }
        }
    }
}
