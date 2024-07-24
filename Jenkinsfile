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
                // Utilizar Maven para compilar y empaquetar el proyecto
                bat 'mvn clean package'
            }
        }

        

        stage('Desplegar') {
            steps {
                // Ejemplo de comando para ejecutar el jar generado por Maven
                sh 'java -jar target/nombre-del-archivo.jar'
            }
        }
    }
}
