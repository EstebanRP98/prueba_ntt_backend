# # Prueba Ntt Data

## Especificaciones del Proyecto
- Tecnologías que se utilizaron en el proyecto es:
    * Lenguaje: JAVA
    * Framework: Spring boot.
    * Base de datos: Postgresql.
      Puerto: 5432
      Nombre Base de Datos: banco_ntt
      User: ntt_data
      Password: ntt_data
    * Docker

  
## Generacion del Proyecto
- El proyecto esta basado en Maven, se procedio a crear la base de datos en postgresql mediante un script.
    Se creo el proyecto para poder:
    * Crear, Actualizar y Eliminar un usuario.
    * Crear, Actualizar y Eliminar (Eliminado Logico) de la cuenta.
    * Crear Movimientos de deposito o retiro de dinero.
    * Reporte mediante Fechas e Identificador del cliente.
    
Para crear los contendedores se utilizo docker compose.

## Desplegar la aplicación

  **Requisitos**
    Descargar docker
    
  * Context Path
    context-path=/api/nttBanco
    
    **Pasos**
    1. Primero se procede a clonar el repositorio
        https://github.com/EstebanRP98/prueba_ntt_backend.git
    2. Despues se procede a ingresar al proyecto y en la misma raiz del proyecto corremos el siguiente comando
        **docker-compose up -d** 
    3. Procedemos a Postman y corremos los servicios que necesitamos, importando las colecciones llamadas **"NttPrueba.postman_collection.json"** que estan en el proyecto.

Gracias.

