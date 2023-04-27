def call(Map config = [:]) {
  def scriptContents = libraryResource "scripts/deploy/environment/local/${config.name}"
  writeFile file: "${config.name}", text: scriptContents
  sh "chmod a+x ./${config.name}"
} 
