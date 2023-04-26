package org.example

class BuildDockerImage {
    String imageName
    String svcName

    BuildDockerImage(String imageName,String svcName) {
        this.imageName = imageName
        this.svcName=svcName
    }

    void build() {
        sh "docker build -t ${imageName} ./${svcName}"
    }
}
