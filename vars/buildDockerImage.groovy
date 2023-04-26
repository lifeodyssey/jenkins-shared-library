// buildDockerImage.groovy
def call(String imageName,String svcName) {
    def docker = new org.example.BuildDockerImage(imageName,svcName)
    docker.build()
}
