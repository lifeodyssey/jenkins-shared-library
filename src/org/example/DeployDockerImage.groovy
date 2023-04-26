package org.example

class DeployDockerImage{
    String environment
    String mongodbUri
    String dockerImageName

    MyDeployment(String environment, String mongodbUri, String dockerImageName) {
        this.environment = environment
        this.mongodbUri = mongodbUri
        this.dockerImageName = dockerImageName
    }

    void deploy() {
        def config = loadConfiguration(environment)
        def deployScript = readFileFromResources('deploy.sh')
        def formattedScript = deployScript.replaceAll('\\$APP_ENV', config.APP_ENV)
                .replaceAll('\\$MONGODB_URI', config.MONGODB_URI)
                .replaceAll('\\$DOCKER_IMAGE_NAME', dockerImageName)
        sh formattedScript
    }

    private def loadConfiguration(String environment) {
        def configFile = "configurations/${environment.toLowerCase()}.groovy"
        return loadResourceAsProperties(configFile)
    }

    private def loadResourceAsProperties(String resourceName) {
        def props = new Properties()
        new GroovyClassLoader(getClass().classLoader).getResourceAsStream(resourceName).withStream { stream ->
            props.load(stream)
        }
        return props
    }

    private def readFileFromResources(String fileName) {
        new File("${Jenkins.instance.getRootDir()}/userContent/my-shared-library/resources/${fileName}").text
    }
}
