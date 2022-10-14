pipeline {
    agent any

   

    stages {
        stage('Git') {
            steps {
            
                git branch: 'main', url: 'https://github.com/OussemaAbderrahmen/testTpAchat.git',
                credentialsId : '	d77f4079-5103-428c-9e06-38a6e8a1178a'
                
            }

           
        }
        stage('MVN Package'){
            steps {
                sh """mvn -version  """
                sh """java -version """
            }
        }
        
        stage("MVN Clean"){
            steps {
                sh """mvn clean """
                
            }
        }

        stage("MVN Install"){
            steps {
                sh """mvn install """
                
            }
        }
        
        stage("Maven Build"){
            steps{
                sh """ mvn package-DskipTests """
            }
        }

    
        
        
        
        
        
    }

}
