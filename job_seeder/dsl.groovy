def gitUrl = 'https://github.com/tarunarora20/my-maven-project.git'

job('build-artifact') {
    scm {
        git(gitUrl)
    }
    triggers {
        scm('*/1 * * * *')
    }
    steps {
        withEnv(["PATH+MVN=${tool 'maven'}/bin"]) {
            sh "mvn -e clean install"
            }
        }
    }
