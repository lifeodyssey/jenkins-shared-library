import org.example.microservice.ci.build.BuildStep

def call(String language, String buildTool){
    BuildStep step=new BuildStep(this)
    step.buildArtifact(language,buildTool)
}
