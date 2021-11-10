pipeline {
    
    agent any
    
    environment {
        GITHUB_ORG = 'hotel-landon-kb'
        CONTAINER_REGISTRY = "ghcr.io/${GITHUB_ORG}/"
        ARTIFACT_ID = readMavenPom().getArtifactId()
        JAR_NAME = "${ARTIFACT_ID}-${BUILD_NUMBER}"
        IMAGE_NAME = "${CONTAINER_REGISTRY}${ARTIFACT_ID}"
    }

	stages {
	    stage('Build Application') {
    	   steps {
   	       		sh 'echo Performing Maven Build: ${ARTIFACT_ID}' 
   	       }
    	}
    	
	    stage('Build Container Image') {
    	   steps {
   	       		sh 'echo Building Container Image: ${IMAGE_NAME}' 
   	       }
    	}
    	
	    stage('Publishing Container Image') {
    	   steps {
   	       		sh 'echo Publishing Container Image to: ${CONTAINER_REGISTRY}' 
   	       }
    	}    	    	    	
	}
}