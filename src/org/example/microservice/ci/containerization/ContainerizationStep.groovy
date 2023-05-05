package org.example.microservice.ci.containerization

// containerizationStep.groovy
class ContainerizationStep {

    def steps

    ContainerizationStep(steps) {
        this.steps = steps
    }


     def buildDockerImage(imageName,svcName) {
        steps.sh "docker build -t ${imageName} ./${svcName}"
    }
}

