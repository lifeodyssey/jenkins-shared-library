package org.example.microservice.config

import org.example.microservice.config.parameters.Environment
import org.example.microservice.config.constant.Constant
class LoadConfigFromResource {
    static String loadMongoDBConfig(Environment appEnv){
        Properties props = new Properties()
        String propValue = null
        try {
            props.load(new FileInputStream(appEnv.getFilePath()))
            propValue = props.getProperty(Constant.MONGODB_URI)
        } catch (Exception e) {
            e.printStackTrace()
        }
        return propValue
    }
}
