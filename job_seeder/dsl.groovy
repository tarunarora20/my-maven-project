def createPipelineJob(def jobName, def repoName) {
    return PipelineJob(jobName) {
        def repository = "https://github.com/sujan-reads/my-maven-project.git"

        description 'CI/CD Pipeline'

        triggers {
            scm('* * * * *')
        }

        definition {
            cpsScm {
                scm {
                    git {
                        remote {
                            url(repository)
                        }
                        branches('master')
                        scriptPath('Jenkinsfile')
                        extensions {} //Required to prevent Git tag
                    }
                }
            }
        }
    }
}

createPipelineJob('My-Maven-Project','my-maven-project')
