# **Response Uniforme**

# Índice
### Definición del proyecto
### Patrón Response Wrapper
### Ventajas
### Estructura de respuesta
### Curls de prueba
### Índice de proyectos Spring Boot

#  **Definición del proyecto**

Demostración de una aplicación que implementa el Patrón Response Wrapper.

#  **Patrón Response Wrapper**

El patrón Response Wrapper es una práctica para las respuestas HTTP de una API. 
Es básicamente una clase envoltorio (wrapper) que se utiliza para que todas las respuestas de tu API sigan una estructura uniforme, independientemente de si la respuesta es exitosa o si ocurre un error.

#  **Ventajas**

- Consistencia: Todas las respuestas siguen el mismo formato. Unifica la estructura de respuesta.
- Extensibilidad: Puedes añadir campos adicionales fácilmente(por ejemplo en paginación).
- Mejora experiencia para clientes de la API: es una estructura predecible en las respuestas.

 
#  **Estructura de respuesta**

Existe una estructura general de respuesta para todas las peticiones, sean exitosas o no.
Todas las respuestas deben seguir la misma estructura.
Atributos:
- status: estado de la operación ( "success" o "error").
- message: mensaje descriptivo personalizado.
- code: código de estado personalizado.
- timestamp: momento de la respuesta.
- data: el cuerpo real de la respuesta (los datos solicitados).

#  **Curls de prueba**

Se puede probar ejecutando con Curl las siguiente sentencias:


curl http://localhost:8080/v1/demo/ok


curl http://localhost:8080/v1/demo/not-found/1


curl http://localhost:8080/v1/demo/unauthorized


curl http://localhost:8080/v1/demo/error



curl -X POST -H "Content-Type: application/json" -d "{ \"nombre\": \"foo\" , \"precio\": \"12567.0\" }" http://localhost:8080/v1/demo/created




curl -X POST -H "Content-Type: application/json" -d "{ \"nombre\": \"foo\" , \"precio\": \"12567.0\" }" http://localhost:8080/v1/demo/bad-request



curl -X POST -H "Content-Type: application/json" -d "{ \"nombre\": \"foo\" , \"precio\": \"12567.0\" }" http://localhost:8080/v1/demo/exists


# Índice de proyectos Spring Boot
- [Response Uniforme](https://github.com/pabloEmanuelIgoldi/Spring-Boot-Response-Wrapper)
- [LogBack](https://github.com/pabloEmanuelIgoldi/Spring-Boot-Logback)
- [Profile](https://github.com/pabloEmanuelIgoldi/Spring-Boot-Profile)
- [Spring Doc](https://github.com/pabloEmanuelIgoldi/Spring-Boot-Swagger)
