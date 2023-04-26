// buildDockerImage.groovy
def call(String imageName,String svcName) {
    sh "docker build -t ${imageName} ./${svcName}"
}
