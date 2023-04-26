// buildDockerImage.groovy
def call(String imageName) {
    def docker = new org.example.BuildDockerImage(imageName)
    docker.build()
}
