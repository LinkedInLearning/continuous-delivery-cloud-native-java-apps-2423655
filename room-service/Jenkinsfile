pipeline {
    
    agent any

	stages {
	    stage('Build Application') {
    	   steps {
   	       		sh 'echo Performing Maven Build:' 
   	       }
    	}
    	
	    stage('Build Container Image') {
    	   steps {
   	       		sh 'echo Building Container Image:' 
   	       }
    	}
    	
	    stage('Publishing Container Image') {
    	   steps {
   	       		sh 'echo Publishing Container Image:' 
   	       }
    	}    	    	    	
	}
}