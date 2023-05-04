import org.example.microservice.config.Utils

// deployApp.groovy
def call(Map config = [:]) {
    loadLinuxScript(name: "deployApp.sh")
    def APP_ENV = config.APP_ENV ?: 'DEV'
    def MONGODB_URI = config.MONGODB_URI ?: Utils.getDatabaseUrlFromResource(APP_ENV)
    sh "./deployApp.sh ${APP_ENV} ${MONGODB_URI}"
}
