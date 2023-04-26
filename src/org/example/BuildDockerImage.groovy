package org.example

class BuildDockerImage {
    String imageName
    String svcName

    BuildDockerImage(String imageName,String svcName) {
        this.imageName = imageName
        this.svcName=svcName
    }

    void build() {
        buildDockerImage(imageName,svcName)
    }
}
