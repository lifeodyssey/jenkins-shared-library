import org.example.microservice.ci.build.buildStep
import org.example.microservice.ci.containerization.containerizationStep
def call(Map config = [:]) {
    def language = config.language
    def buildTool = config.buildTool
    def imageName = config.imageName
    def svcName = config.svcName
    pipeline {
        agent any
        stages {
            stage('Test and Build Jar') {
                steps {
                    script {
                    buildStep.buildArtifact(language, buildTool)
                    }
                }
            }
            stage('Build Image') {
                steps {
                    script {
                        containerizationStep.buildImage(imageName, svcName)
                    }
                }
            }
            stage('Dev') {
                steps {
                    script {
                        deployApp(APP_ENV: 'DEV')
                    }
                }
            }
            stage('Deploy to QA approval') {
                steps {
                    input "Deploy to QA?"
                    script {
                        deployApp(APP_ENV: 'QA')
                    }
                }
            }
        }
    }
}
