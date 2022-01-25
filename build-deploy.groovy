// declarative pipeline
pipeline{
    agent any
    parameters {
        string(name: 'BUILD_NUMBER', defaultValue: '', description: 'build number')
    }
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
                sh "aws s3 cp target/hello-${BUILD_NUMBER}.war s3://chaituart/master/${BUILD_NUMBER}"
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