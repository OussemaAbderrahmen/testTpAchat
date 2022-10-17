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
                sh """mvn package -e """
            }
        }
        
        stage("MVN Clean"){
            steps {
                sh """mvn clean -e """
                
            }
        }

         stage("MVN build"){
            steps {
                sh """mvn compile -e """
                
            }
        }

        stage("MVN Install"){
            steps {
                sh """mvn install """
                
            }
        }

        stage('sonar'){
            steps {
                script{ withSonarQubeEnv('SonarQube') {
                     sh "mvn sonar:sonar -DskipTests" 
                 }
               
                }
            }
        }
        
    

    
        
        
        
        
        
    }

}
