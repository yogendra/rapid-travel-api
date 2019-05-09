node {
    git url: 'https://github.com/yogendra/rapid-travel-api.git'
    stage('Checkout'){
         checkout scm
    }
    stage('Build'){
        sh './mvnw clean compile'
    }
    stage('Code Quality Check'){
        withSonarQubeEnv {
            sh './mvnw sonar:sonar -Dsonar.host.url=$SONAR_HOST_URL -Dsonar.login=$SONAR_AUTH_TOKEN '
        }
    }
    stage('Test : Unit'){
        sh './mvnw test package'
        junit '**/target/surefire-reports/TEST-*.xml'
    }
    stage('Security Vulnerability Scan '){
      sleep 3
    }

    stage('Deploy Test Env'){
        sleep 2

        /*
        withCredentials([usernamePassword(credentialsId: 'pcf-pcfone', passwordVariable: 'CF_PASSWORD', usernameVariable: 'CF_USER')]) {
            sh 'cf login -a api.run.pcfone.io -u $CF_USER -p $CF_PASSWORD -s Testing'
            sh 'cf push api-rapid-test -f src/cf/manifest-pcfone-test.yaml -p target/travel-insurance-*-exec.jar'
        }
        */

    }
    stage('Test : Integration'){
        /*
          sh './mvnw verify'
        */

        sleep 2
    }
    stage('Publish'){
        echo './mvnw -DskipTests deploy'
    }
    stage('Deploy to Prod (On Prem)'){

        withCredentials([usernamePassword(credentialsId: 'pcf-pcfone', passwordVariable: 'CF_PASSWORD', usernameVariable: 'CF_USER')]) {
            sh "cf login -a api.run.pcfone.io -u \"$CF_USER\" -p \"$CF_PASSWORD\" -s Production"
            sh 'cf push api-rapid -f src/cf/manifest-pcfone.yaml -p target/travel-insurance-*-exec.jar'
        }
    }
    stage('Deploy to Prod (Cloud)'){
        withCredentials([usernamePassword(credentialsId: 'pcf-pws', passwordVariable: 'CF_PASSWORD', usernameVariable: 'CF_USER')]) {
            sh "cf login -a api.run.pivotal.io -u \"$CF_USER\" -p \"$CF_PASSWORD\" -s Production"
            sh 'cf push api-rapid -f src/cf/manifest-pws.yaml -p target/travel-insurance-*-exec.jar'
        }

    }
}
