pipeline {
    agent any

    stages {
        stage('Revisión') {
            steps {
                checkout scm
            }
        }

        stage('Construir y Empaquetar') {
            steps {
                sh 'mvn clean package'
            }
        }

       

        
    }
}
