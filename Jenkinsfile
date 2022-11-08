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

         stage("MVN Compile"){
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
                     sh """mvn sonar:sonar -DskipTests""" 
                 }
               
                }
            }
        }

      

         stage("Upload JAR to Nexus"){
            steps{
                script{
                    def mavenPom = readMavenPom file:'pom.xml'
                
        nexusArtifactUploader artifacts: [
             [artifactId: 'tpAchatProject',
                    classifier: '',
                    file: "target/tpAchatProject-${mavenPom.version}.jar",
                     type: 'jar'],
            ],  
                credentialsId: 'nexus3', 
               groupId: 'com.esprit.examen', 
               nexusUrl: '192.168.1.183:8081', 
               nexusVersion: 'nexus3', 
               protocol: 'http', 
               repository: 'tpAchatProjet',
                version: "${mavenPom.version}"
            }
        }
        }

        
    

    
        
        
        
        
        
    }

}
