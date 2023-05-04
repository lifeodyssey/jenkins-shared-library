package org.example.microservice.config

import org.codehaus.groovy.runtime.ResourceGroovyMethods
import org.example.microservice.config.parameters.Environment
import org.example.microservice.config.constant.Constant
class Utils {
    static String getDatabaseUrlFromResource(String env) {
        def environment = Environment.valueOf(env)
        def props = new Properties()
        def classLoader = this.class.classLoader
        def inputStream = classLoader.getResourceAsStream("${environment.getFilePath()}")
        props.load(inputStream)
        return props.getProperty(Constant.MONGODB_URI)
    }
}
