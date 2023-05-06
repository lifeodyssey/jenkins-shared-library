package org.example.microservice.config.parameters

// Environment.groovy
enum Environment {
    DEV("mongodb://dev_mongo_username:dev_mongo_pwd@host.docker.internal:27018/?authSource=admin\\\\&tls=false"),
    QA("mongodb://qa_mongo_username:qa_mongo_pwd@host.docker.internal:27019/?authSource=admin\\\\&tls=false"),
    PROD("configurations/prod.properties")

    final String dbPath

    Environment(String dbPath) {
        this.dbPath = dbPath
    }

    String getDBPath() {
        dbPath
    }
    static Environment getEnvironmentByName(String name) {
        Environment.values().find { it.name() == name }
    }

}