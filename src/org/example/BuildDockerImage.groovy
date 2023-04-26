package org.example

class BuildDockerImage {
    String imageName

    BuildDockerImage(String imageName) {
        this.imageName = imageName
    }

    void build() {
        sh "docker build -t ${imageName} ."
    }
}
