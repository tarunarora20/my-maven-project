def gitUrl = 'https://github.com/tarunarora20/my-maven-project.git'

mavenjob('build-artifact') {
    scm {
        git(gitUrl)
    }
    triggers {
        scm('*/1 * * * *')
    }
    goals('-e clean install')
    }
