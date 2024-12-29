# WissnHub, share your knowledge with a great community
## An Alura and Oracle project

This API REST has been developed using Java 17 and Spring Boot applying the knowledge given in "Java y Spring Framework G7 - ONE" and in compliance with the requirements specified in "Challenge Foro Hub".

## API Description

The API allows the user to login and use the JWTtoken generated to create, retrieve, update and delete topics from a database

### 1. Buscar libro por titulo
- Al introducir el titulo del libro, se realizara la busqueda y se imprimira el titulo completo del libro, autor, idioma y numero de descargas.
### 2. Listar libros registrados
- Se mostrara la lista de libros registrados en la base de datos en orden alfabetico, imprimiendo el titulo completo del libro, autor, idioma y numero de descargas.
### 3. Listar autores registrados
- Se mostrara la lista de autores registrados en la base de datos en orden alfabetico, imprimiendo el nombre completo del autor, fecha de nacimiento, fecha de defuncion y libros disponibles en la BD.
### 4. Listar autores vivos desde determinado año
- Al introducir una fecha de inicio, se mostrara la lista de autores registrados en la base de datos vivos a partir del año dado, imprimiendo el nombre completo del autor, fecha de nacimiento y fecha de defuncion.
### 5. Listar libros por idioma
- Al introducir uno de los idiomas disponibles (EN - ingles, ES - español, FR - frances, PR - portugues), se mostrara la lista de libros registrados en la base de datos en el idioma dado, imprimiendo el titulo completo del libro, nombre del autor, fecha de nacimiento y fecha de defuncion.
### 6. Top 10 libros mas descargados
- Se mostrara una lista con los 10 libros mas descargados en la base de datos, imprimiendo el numero de descargas, nombre del libro, autor e idioma.
### 7. Listar libros registrados por autor
- Se mostrara una lista con los autores disponibles en la base de datos y se solicitara introducir el nombre del autor deseado, posterior a esto se imprimira una lista con los libros disponibles del autor con el nombre completo del libro, idioma y numero de descargas.
### 8. Estadisticas
- Se mostrara el promedio de descargas, la mayor cantidad y la menor cantidad de descargas por libro.
### 0. Salir
- El usuario saldrá de la aplicación y aparecerá un mensaje de despedida.
