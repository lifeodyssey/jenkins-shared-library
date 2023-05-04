package org.example.microservice.config

import org.codehaus.groovy.runtime.ResourceGroovyMethods
import org.example.microservice.config.parameters.Environment
import org.example.microservice.config.constant.Constant
class Utils {
    static String getDatabaseUrlFromResource(String env) {
        def environment = Environment.valueOf(env)
        def props = new Properties()
        props.load(getClass().getResourceAsStream("/configurations/${environment.getFilePath()}"))
        return properties.getProperty(Constant.MONGODB_URI)
    }
}
