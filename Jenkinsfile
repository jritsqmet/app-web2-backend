node {
    stage( 'verificar repositorio' ){
        checkout scm
    }

    stage( 'Instalación de dependencias' ){
        bat 'npm install' 
    }

    stage('Contruir Aplicacion'){
        bat( 'ng build' )
    }
}
