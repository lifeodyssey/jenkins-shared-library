import org.example.microservice.cd.DeployToLocal
import org.example.microservice.config.Utils

// deployApp.groovy
def call(appEnv) {
    def deployStep=new DeployToLocal(this)
    deployStep.deployApp(appEnv)
}
