def gitUrl = 'https://github.com/tarunarora20/my-maven-project.git'

createPipelineJob('build-artifact') {
    scm {
        git(gitUrl)
    }
    triggers {
        scm('*/1 * * * *')
    }
    steps {
        maven('-e clean test')
    }
}
