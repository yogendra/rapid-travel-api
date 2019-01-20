node {
    git url: 'https://github.com/yogendra/rapid-travel-api.git'
    stage('Checkout'){
         checkout scm
    }
    stage('Build'){
        sh './mvnw -X clean compile'
    }
    stage('Code Quality Check'){
        withSonarQubeEnv {
            sh './mvnw sonar:sonar -Dsonar.host.url=$SONAR_HOST_URL -Dsonar.login=$SONAR_AUTH_TOKEN '
        }
    }
    stage('Test : Unit'){
        sh './mvnw test'
        junit '**/target/surefire-reports/TEST-*.xml'
    }
    stage('Deploy Test Env'){
        sh './mvnw -DskipTests package deploy'
        pushToCloudFoundry(
            target: 'api.run.pcfone.io',
            organization: 'pivot-yrampuria',
            cloudSpace: 'Testing',
            credentialsId: 'pcf-pcfone',
            manifestChoice: [manifestFile: 'manifest-pcfone-testing.yaml']
        )
        echo 'cf login -a api.run.pcfone.io'
        echo 'cf push '
    }
    stage('Test : Integration'){
        sh './mvnw verify'
    }
    stage('Publish'){
        echo './mvnw -DskipTests deploy'
    }
    stage('Deploy to Prod (On Prem)'){
        pushToCloudFoundry(
            target: 'api.run.pcfone.io',
            organization: 'pivot-yrampuria',
            cloudSpace: 'Production',
            credentialsId: 'pcf-pcfone',
            manifestChoice: [manifestFile: 'manifest-pcfone.yaml']
        )
        echo 'cf login -a api.run.pcfone.io'
        echo 'cf push '        
    }
    stage('Deploy to Prod (Cloud)'){
        pushToCloudFoundry(
            target: 'api.run.pivotal.io',
            organization: 'yrampuria',
            cloudSpace: 'Production',
            credentialsId: 'pcf-pws',
            manifestChoice: [manifestFile: 'manifest-pws.yaml']
        )
        echo 'cf login -a api.run.pivotal.io'
        echo 'cf push '
        
    }
}
