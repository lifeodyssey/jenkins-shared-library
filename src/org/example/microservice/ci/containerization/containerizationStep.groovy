package org.example.microservice.ci.containerization

// containerizationStep.groovy
class containerizationStep {

    def buildImage(String imageName, String svcName) {
        buildDockerImage(imageName: imageName, svcName: svcName)
    }

    private static def buildDockerImage(Map config = [:]) {
        // Call the buildDockerImage method defined in vars/buildDockerImage.groovy
        sh "docker build -t ${config.imageName} ./${config.svcName}"
        return this
    }
}

