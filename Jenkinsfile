pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {
        stage("Health Check") {
            steps {
                script {
                    echo "Ejecutando Health Check"
                    def url = "https://automationexercise.com/api/productsList"
                    def response = bat(script: "curl -s -L --fail-with-body ${url}", returnStdout: true).trim()
                    echo response
                }
                echo "Health Check ejecutado con éxito!"
            }
        }

        stage('Clonar Repositorio') {
            steps {
                // Jenkins ya clona el repositorio automáticamente si se usa multibranch pipeline
                echo "Repositorio clonado automáticamente por Jenkins."
            }
        }

        stage('Run Smoke Tests') {
            steps {
                bat 'mvn clean test "-DsuiteXmlFile=SmokeTestSuite.xml"'
            }
        }

        stage('Instalar Newman') {
            steps {
                bat 'npm install -g newman'
                bat 'npm install -g newman-reporter-html'
            }
        }

        stage('Ejecutar colección API') {
            steps {
                bat '''
                    C:\\Users\\USUARIO\\AppData\\Roaming\\npm\\newman.cmd run src\\test\\postman\\automation_exercise.postman_collection.json ^
                        -e src\\test\\postman\\env.postman_environment.json ^
                        --reporters cli,html ^
                        --reporter-html-export newman-report.html
                '''
            }
        }

        stage('Run Full UI Regression Tests') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            echo 'Finalizando ejecución...'

            // Archivar ambos reportes
            archiveArtifacts artifacts: 'newman-report.html', onlyIfSuccessful: false
            archiveArtifacts artifacts: 'test-output/ExtentReport.html', onlyIfSuccessful: false

            // Publicar reportes HTML
            publishHTML([
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: '.',
                reportFiles: 'newman-report.html',
                reportName: 'API Test Report'
            ])

            publishHTML([
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'test-output',
                reportFiles: 'ExtentReport.html',
                reportName: 'UI Test Report'
            ])
        }

        success {
            echo 'Pipeline ejecutado con éxito.'
        }

        failure {
            echo 'Pipeline falló.'
        }
    }
}
