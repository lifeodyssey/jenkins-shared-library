package org.example.microservice.config

import org.example.microservice.config.parameters.Environment
class Utils {
    static String getDatabaseUrlFromResource(String env) {
        def environment = Environment.getEnvironmentByName(env)
        return environment.getDBPath()
    }
}
