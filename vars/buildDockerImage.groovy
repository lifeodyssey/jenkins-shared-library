import org.example.microservice.ci.containerization.ContainerizationStep

// buildDockerImage.groovy
def call(imageName,svcName){
    ContainerizationStep step=new ContainerizationStep(this)
    step.buildDockerImage(imageName,svcName)
}
