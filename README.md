# **Ejteechi**
Proyecto de Diseño de Software que simula un programa enfocado en el sistema de camiones de Ciudad Obregón.
## ***Setup***
Tenga en mente que el proyecto se hizo con la versión 21 de Java. Para asegurar el funcionamiento correcto del programa primero se debe configurar la base de datos, para lo cual recomendamos utilizar un programa similar a Studio 3T. Deberá crear una base de datos llamada ejteechidb y posteriormente tendrá que copiar todo el script de 'configuracion_inicial.json' y ejecutarlo. Dentro de dicho json ya vienen los datos del mapa y de los camiones (sus rutas y paradas), además de usuario de recursos humanos con el cual podrá registrar trabajadores.  

**Datos del usuario**  
Correo: admin  
Contraseña: admin
## ***Instrucciones para solucionar errores***
### **Solución por complilación**
Recomendamos compilar todos los proyectos que conforman el programa en caso de que ocurran errores de dependencias. El orden de compilación es el siguiente:
1. Persistencia
2. DTOs
3. ObtenerImagenesMapa
4. ObjetosNegocio
5. Todos los subsistemas (MostrarMapa, IniciarSesion, CrearCuentaCliente, AdministrarQuejas, AdministrarTickets, etc)
6. Presentación.

### **Solución por remoción de dependencias**
Si tras haber seguido los pasos de compilación siguen apareciendo errores de artefactos, identifique el proyecto donde se generan los errores (por lo general es en Presentacion) y vea qué artefacto no se puede resolver. Vaya a las dependencias del proyecto y remueva aquellas que presentan problemas, luego vuelva a agregar dichas dependencias y recomendamos seguir los pasos de compilación del punto anterior.

## ***Créditos***
### **Integrantes del equipo:**
Eliana Monge Cámara  
Francisco Valdez Gastelum  
Diego Valenzuela Parra  

### **Encargados de los Casos de uso**
**RegistrarCliente**: Diego Valenzuela  
**IniciarSesion**: Francisco Valdez  
**MostrarMapa**: Todo el equipo  
**AdministrarQuejas**: Eliana Monge  
**AdministrarTickets**: Diego Valenzuela  
**RegistrarEmpleado**: Francisco Valdez  
**VisualizarQuejas**: Eliana Monge  
**AtenderTickets**: Diego Valenzuela  
**ProgramarMantenimiento**: Eliana Monge  
