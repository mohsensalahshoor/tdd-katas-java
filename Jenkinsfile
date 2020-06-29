pipeline {
    agent { docker { image 'maven:3.0.5' } }
    stages {
        stage('build') {
            steps {
                sh 'mvn package'
            }
        }
    }
}
