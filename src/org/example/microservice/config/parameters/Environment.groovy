package org.example.microservice.config.parameters

// Environment.groovy
enum Environment {
    DEV("configurations/dev.properties"),
    QA("configurations/qa.properties"),
    PROD("configurations/prod.properties")

    final String fileName

    Environment(String fileName) {
        this.fileName = fileName
    }

    String getFilePath() {
        fileName
    }
}