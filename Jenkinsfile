node {
    stage( 'verificar repositorio' ){
        checkout scm
    }

    stage( 'Instalación de dependencias' ){
        bat "mvn clean"
    }

    stage('Contruir Aplicacion'){
        bat( 'ng build' )
    }
}
