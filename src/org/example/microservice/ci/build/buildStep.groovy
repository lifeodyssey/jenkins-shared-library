package org.example.microservice.ci.build
class buildStep {

    def buildArtifact(language, buildTool) {
        if (!language || !buildTool) {
            throw new IllegalArgumentException("Language and build tool parameters are required.")
        }

        def builderMethod = getBuilderMethod(language, buildTool)

        if (!builderMethod) {
            throw new IllegalArgumentException("Unsupported language or build tool: ${language}, ${buildTool}")
        }

        builderMethod()
    }

    private static def getBuilderMethod(language, buildTool) {
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

    private static def buildGradle() {
        // Call the buildGradle method defined in vars/buildGradle.groovy
        buildGradle()
    }

    private static def buildMaven() {
        // Call the buildMaven method defined in vars/buildMaven.groovy
        buildMaven()
    }

    private static def buildNpm() {
        // Call the buildNpm method defined in vars/buildNpm.groovy
        buildNpm()
    }

    private static def buildYarn() {
        // Call the buildYarn method defined in vars/buildYarn.groovy
        buildYarn()
    }
}
