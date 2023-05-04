package org.example.microservice.config.parameters

// Environment.groovy
enum Environment {
    DEV("mongodb://dev_mongo_username:dev_mongo_pwd@host.docker.internal:27018/?authSource=admin\\\\&tls=false"),
    QA("mongodb://qa_mongo_username:qa_mongo_pwd@host.docker.internal:27019/?authSource=admin\\\\&tls=false"),
    PROD("configurations/prod.properties")

    final String fileName

    Environment(String fileName) {
        this.fileName = fileName
    }

    String getDBPath() {
        fileName
    }
}