
node {
    git url: 'https://github.com/yogendra/rapid-travel-api.git'
    stage('Checkout'){
         checkout scm
    }
    stage('Build'){
        sh './mvnw compile'
    }
    stage('Code Quality Check'){
        sh './mvnw sonar:sonar '
    }
    stage('Test : Unit'){
        sh './mvnw test'
    }
    stage('Deploy Test Env'){
        echo 'cf login -a api.run.pcfone.io'
        echo 'cf push '
    }
    stage('Test : Integration'){
        echo './mvnw verify'
    }
    stage('Publish'){
        echo './mvnw publish'
    }
    stage('Deploy to Prod (On Prem)'){
        echo 'cf login -a api.run.pcfone.io'
        echo 'cf push '        
    }
    stage('Deploy to Prod (Cloud)'){
        echo 'cf login -a api.run.pivotal.io'
        echo 'cf push '
        
    }
}
