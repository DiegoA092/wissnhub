# WissnHub, share your knowledge with a great community
## An Alura and Oracle project

This API REST has been developed using Java 17 and Spring Boot applying the knowledge given in "Java y Spring Framework G7 - ONE" and in compliance with the requirements specified in "Challenge Foro Hub".

## API Description

The API allows the user to login and use the JWTtoken generated to authorize the CRUD (create, retrieve, update, delete) operations

### 1. Login
- Registered users will provide their username and password in order to obtain a JWTtoken 
### 2. Create topic
- Topics can be created by providing their user id and the topic title, message and course id
### 3. Retrieve 
- A complete list of the registered topics can be retrieved without additional info, for spécific topics it is required to provide their id in the URL
### 4. Update topic
- Topics can be updated by providing their id in the URL and the changes required either in the title, message, status or course id
### 5. Delete topic
-Topics can be deleted by providing their id in the URL 
