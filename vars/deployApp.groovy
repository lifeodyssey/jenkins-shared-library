// deployApp.groovy
def call(Map config = [:]) {
    loadLinuxScript(name: "deployApp.sh")
    sh "./deployApp.sh ${config.APP_ENV} ${config.MONGODB_URI}"
}
