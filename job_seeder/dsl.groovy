def gitUrl = 'https://github.com/tarunarora20/my-maven-project.git'

job('build-artifact') {
    scm {
        git(gitUrl)
    }
    steps {
        maven {
            mavenInstallation('maven')
            goals('-e clean install')
     }
  }
}
  job('Deploy to Staging')
