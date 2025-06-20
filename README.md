# 🧪 AutomationExercise Test Suite

Este proyecto contiene una suite de pruebas automatizadas desarrolladas en Java para el sitio web [Automation Exercise](https://automationexercise.com), una plataforma de demostración para prácticas de testing.

## 📌 Tecnologías utilizadas

### Pruebas UI
- **Lenguaje:** Java 21
- **Framework de testing:** TestNG
- **Automatización web:** Selenium WebDriver
- **Gestor de dependencias:** Maven
- **Patrón de diseño:** Page Object Model (POM)

### Pruebas API
- **Herramienta:** Postman
- **Runner:** Newman
- **Reportes:** HTML

## ✅ Casos de prueba implementados (UI)

| #   | Nombre del caso de prueba                                     | Tipo       |
|-----|---------------------------------------------------------------|------------|
| TC01 | Register User                                                 | Positiva   |
| TC02 | Login User with correct email and password                   | Positiva   |
| TC03 | Login User with incorrect email and password                 | Negativa   |
| TC04 | Logout User                                                  | Positiva   |
| TC05 | Register User with existing email                            | Negativa   |
| TC06 | Contact Us Form                                              | Positiva   |
| TC07 | Verify Test Cases Page                                       | Positiva   |
| TC08 | Verify All Products and product detail page                  | Positiva   |
| TC09 | Search Product                                               | Positiva   |
| TC10 | Verify Subscription in home page                             | Positiva   |
| TC11 | Verify Subscription in Cart page                             | Positiva   |
| TC12 | Add Products in Cart                                         | Positiva   |
| TC13 | Verify Product quantity in Cart                              | Positiva   |
| TC14 | Place Order: Register while Checkout                         | Positiva   |
| TC15 | Place Order: Register before Checkout                        | Positiva   |
| TC16 | Place Order: Login before Checkout                           | Positiva   |

> 🧩 **Nota:** Cada prueba está desarrollada bajo el patrón Page Object Model para garantizar claridad, mantenibilidad y escalabilidad.

## ▶️ Cómo ejecutar las pruebas

1. Clona el repositorio:
```bash
git clone https://github.com/tu-usuario/automationexercise-tests.git
```

2. Navega al directorio del proyecto:
```bash
cd C:/.../automationexercise-tests
```

3. Ejecuta las pruebas con Maven:
```bash
mvn clean test
```
> La suites seleccionada por defecto es FullUITestSuite, por lo que se desplegaran todos los Test Cases que validan la UI.

## API Tests
### Requisitos

📦 Instalación de dependencias
Primero, asegúrate de tener Node.js instalado. Luego, instala Newman y su reporter HTML:
```bash
npm install -g newman
npm install -g newman-reporter-html
```
Ejecución desde consola
Para ejecutar sin generar reporte:
```bash
newman run src/test/postman/automation_exercise.postman_collection.json -e src/test/postman/env.postman_environment.json
```
Para ejecutar y generar un reporte HTML:
```bash
newman run src/test/postman/automation_exercise.postman_collection.json -e src/test/postman/env.postman_environment.json --reporters html --reporter-html-export src/test/postman/reportes/newman-report.html
```
## 🔧 Jenkins Pipeline
El proyecto contiene un archivo Jenkinsfile en la raíz que permite ejecutar automáticamente las pruebas UI y API en un pipeline CI/CD.

### Instrucciones para usar en Jenkins
1. Crea un nuevo pipeline en Jenkins.
2. En la configuración, selecciona "Pipeline script from SCM".
3. Configura el repositorio GitHub y rama principal.
4. Jenkins ejecutará el flujo definido en el Jenkinsfile, que incluye:
   - Compilación del proyecto.
   - Ejecución de pruebas UI.
   - Ejecución de pruebas API con Newman.
   - Generación de reportes.

### 🧑‍💻 Autor
Este proyecto fue desarrollado por **Elian Camilo Angarita** ([@ecam-b](https://github.com/ecam-b)) como parte de su portafolio de automatización QA con Java + Selenium + Postman.