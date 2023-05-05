package org.example.microservice.cd

import org.example.microservice.config.Utils


class DeployToLocal {
    def steps

    DeployToLocal(steps) {
        this.steps = steps
    }

    def deployApp(String appEnv) {
        def mongodbUri = Utils.getDatabaseUrlFromResource(appEnv)
        steps.loadLinuxScript(name: "deployApp.sh")
        steps.sh "./deployApp.sh ${appEnv} ${mongodbUri}"
    }
}

