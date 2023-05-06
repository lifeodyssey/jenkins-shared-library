def call(Map config = [:]) {
    String language = config.language
    String buildTool = config.buildTool
    String imageName = config.imageName
    String svcName = config.svcName


    node {
        stage('Test and Build Jar') {
            buildArtifact(language, buildTool, svcName)
        }
        stage('Build Image') {
            buildDockerImage(imageName, svcName)
        }
        stage('Dev') {
            deployApp('DEV')
        }
        stage('Deploy to QA approval') {
            input "Deploy to QA?"
        }
        stage('QA') {
            deployApp('QA')
        }
    }

}