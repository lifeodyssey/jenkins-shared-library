package org.example.microservice.ci.build
class BuildStep {
    def steps

    BuildStep(steps) {
        this.steps = steps
    }

     def buildArtifact(String language, String buildTool) {
        if (!language || !buildTool) {
            throw new IllegalArgumentException("Language and build tool parameters are required.")
        }

        def builderMethod = getBuilderMethod(language, buildTool)

        if (!builderMethod) {
            throw new IllegalArgumentException("Unsupported language or build tool: ${language}, ${buildTool}")
        }
        builderMethod()
    }

    private def getBuilderMethod(language, buildTool) {
        def builderMethod

        switch ([language, buildTool].join(':')) {
            case 'java:gradle':
                builderMethod = this.&buildGradle
                break
            case 'java:maven':
                builderMethod = this.&buildMaven
                break
            case 'nodejs:npm':
                builderMethod = this.&buildNpm
                break
            case 'nodejs:yarn':
                builderMethod = this.&buildYarn
                break
        }

        return builderMethod
    }

    def buildGradle() {
        // Call the buildArtifact method defined in vars/buildArtifact.groovy
        steps.sh "./gradlew clean build"
    }

    def buildMaven() {
        // Call the buildMaven method defined in vars/buildMaven.groovy
        //buildMaven()
    }

    def buildNpm() {
        // Call the buildNpm method defined in vars/buildNpm.groovy
        //buildNpm()
    }

    def buildYarn() {
        // Call the buildYarn method defined in vars/buildYarn.groovy
        //buildYarn()
    }
}

