// declarative pipeline
pipeline{
    agent any
    stages{
        stage("clone the code from git hub"){
            steps{
                println("here clonining the code from github")
            }
        }
        stage("buid the code"){
            steps{
                println("here building the code using maven tool")
                sh "mvn clean package"
                sh "ls -l"
                sh "ls -l target/"
            }
        }
        stage("upload the artifacts"){
            steps{
                println("here uploading the artifacts to s3")
            }
        }
        stage("download artifacts"){
            steps{
                println("downloading artifacts from s3")
            }
        }
        stage("copy to other servers"){
            steps{
                println("coping artifacts to other server")
            }
        }
    }
}