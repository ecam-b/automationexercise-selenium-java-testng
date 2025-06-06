# 🧪 AutomationExercise Test Suite

Este proyecto contiene una suite de pruebas automatizadas desarrolladas en Java para el sitio web [Automation Exercise](https://automationexercise.com), una plataforma de demostración para prácticas de testing.

## 📌 Tecnologías utilizadas

- **Lenguaje:** Java 21
- **Framework de testing:** TestNG
- **Automatización web:** Selenium WebDriver
- **Gestor de dependencias:** Maven
- **Patrón de diseño:** Page Object Model (POM)

## ✅ Casos de prueba implementados

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

### 🧑‍💻 Autor 
Este proyecto fue desarrollado por **Elian Camilo Angarita** (ecam-b) como parte de su portafolio de automatización QA con Java + Selenium.