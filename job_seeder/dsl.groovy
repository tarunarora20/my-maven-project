def gitUrl = 'https://github.com/tarunarora20/my-maven-project.git'

job('build-artifact') {
    scm {
        git(gitUrl)
    }
    triggers {
        scm('*/1 * * * *')
    }
    steps {
        maven {
            mavenInstallation('maven')
            goals('-e clean install')
            }
        publishers {
        downstream('Deploy to Staging', 'SUCCESS')
        }
    }
}
