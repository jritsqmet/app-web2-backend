node {
    agent any

    stages {
        stage('Revisión') {
            steps {
                checkout scm
            }
        }

        stage('Construir y Empaquetar') {
            steps {
                bat 'mvn clean package'
            }
        }

       

        
    }
}
