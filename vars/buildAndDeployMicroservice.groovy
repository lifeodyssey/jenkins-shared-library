def call(Map config = [:]) {
    String language = config.language
    String buildTool = config.buildTool
    String imageName = config.imageName
    String svcName = config.svcName
    pipeline {
        agent any
        stages {
            stage('Test and Build Jar') {
                steps {
                    script {
                        buildArtifact(language, buildTool)
                    }
                }
            }
            stage('Build Image') {
                steps {
                    script {
                        buildDockerImage(imageName,svcName)
                    }
                }
            }
            stage('Dev') {
                steps {
                    script {
                        deployApp('DEV')
                    }
                }
            }
            stage('Deploy to QA approval') {
                steps {
                    input "Deploy to QA?"
                }
            }
            stage('QA') {
                steps {
                    script {
                        deployApp('QA')
                    }
                }
            }
        }
    }
}
