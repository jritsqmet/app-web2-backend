def mavenHome = "C:\\Users\\TW\\Downloads\\borrar\\apache-maven-3.9.8-bin\\apache-maven-3.9.8\\bin"

node {
    stage( 'verificar repositorio' ){
        checkout scm
    }

    stage( 'Instalación de dependencias' ){
        bat "${mavenHome}\\mvn.cmd clean"
    }

    stage('Contruir Aplicacion'){
        bat( 'C:\\Users\\TW\\Downloads\\borrar\\apache-maven-3.9.8-bin\\apache-maven-3.9.8\\bin\\mvn.cmd package' )
    }
}
