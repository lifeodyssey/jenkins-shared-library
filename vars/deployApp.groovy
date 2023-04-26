// deployApp.groovy
def call(String environment, String mongodbUri, String dockerImageName) {
    def deployment = new org.example.DeployDockerImage(environment, mongodbUri, dockerImageName)
    deployment.deploy()
}
