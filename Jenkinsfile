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
    stage('Security Vulnerability Scan '){
      sleep 3
    }

    stage('Deploy Test Env'){
        sh './mvnw -DskipTests package'

        /*
        withCredentials([usernamePassword(credentialsId: 'pcf-pcfone', passwordVariable: 'CF_PASSWORD', usernameVariable: 'CF_USER')]) {
            sh 'cf login -a api.run.pcfone.io -u $CF_USER -p $CF_PASSWORD -s Testing'
            sh 'cf push api-rapid-test -f manifest-pcfone.yaml'
        }
        */

    }
    stage('Test : Integration'){
        sh './mvnw verify'
    }
    stage('Publish'){
        echo './mvnw -DskipTests deploy'
    }
    stage('Deploy to Prod (On Prem)'){

        withCredentials([usernamePassword(credentialsId: 'pcf-pcfone', passwordVariable: 'CF_PASSWORD', usernameVariable: 'CF_USER')]) {
            sh "cf login -a api.run.pcfone.io -u \"$CF_USER\" -p \"$CF_PASSWORD\" -s Production"
            sh 'cf push api-rapid -f manifest-pcfone.yaml'
        }
    }
    stage('Deploy to Prod (Cloud)'){
        withCredentials([usernamePassword(credentialsId: 'pcf-pws', passwordVariable: 'CF_PASSWORD', usernameVariable: 'CF_USER')]) {
            sh "cf login -a api.run.pivotal.io -u \"$CF_USER\" -p \"$CF_PASSWORD\" -s Production"
            sh 'cf push api-rapid -f manifest-pws.yaml'
        }

    }
}
