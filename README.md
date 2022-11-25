<a name="readme-top"></a>
<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/sebastian-medinaOch/devops-back">
    <img src="person/src/main/resources/static/logo.jpg" alt="Logo" width="340" height="130">
  </a>

<h3 align="center">DEVOPS-BACK</h3>

  <p align="center">
    Es un proyecto de java y con spring boot basado en un monolito para el enfoque de realizar un crud con microservicios y desplegarlos a la nube con la infrastructura de integración con CI y CD. Se incorporará amazón para lo que se requiera y jenkins para todo con lo referenciado a los despliegues.
  </p>
</div>

### Built With

* ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
* ![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
* ![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
* ![MySQL](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)


<!-- GETTING STARTED -->
## Getting Started

Para correr en el local debes de seguir los pasos a continuación.

### Prerequisites

* JDK 17 [https://jdk.java.net/java-se-ri/17](https://jdk.java.net/java-se-ri/17)
* Gradle [https://gradle.org/install/](https://gradle.org/install/)

### Recommended Tools
* IntelliJ Community [https://www.jetbrains.com/idea/download/](https://www.jetbrains.com/idea/download/)
* Postman [https://www.postman.com/downloads/](https://www.postman.com/downloads/)

### Installation

1. Clona el repositorio
   ```sh
   git clone https://github.com/sebastian-medinaOch/devops-back.git
   ```
2. Crea una nueva base de datos en MySQL que se llame devops-back
3. Actualiza las configuraciones de la conección de la base de datos 
   ```yml
   # src/main/resources/application.yml   
   spring:
      datasource:
          url: jdbc:mysql://localhost/devops-back
          username: root
          password: root
   ```
5. Corre la aplicación usando gradle
   ```sh
   gradlew bootRun
   ```


<!-- USAGE -->
## Usage

1. Primero crea a una persona para poder utilizar cualquiera de las otras caracteristicas del servicio.

Opcion 1: Importa el archivo devops-back.postman_collection.json en Postman

<!-- ROADMAP -->
## Tests

- Abre el proyecto en IntelliJ

- Click derecho en la ruta del archivo devops-back

- Despues de ejecutar los test con coverage podrás ver en el nuevo panel las estadisticas correcta de los test.

<!-- ROADMAP -->
## Roadmap

- [X] Registro de persona
- [X] Buscar persona por numero de documento
- [X] Buscar a todas las personas creadas
- [X] Eliminar a una persona por numero de documento


