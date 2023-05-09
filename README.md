# DemoCrud - Java 17 and Angular 15

DemoCrud is a demo REST API project that comunicates with H2 database.

**Backend Project**: https://github.com/reisllucas/demoCrud/tree/main/demoCrudBackend

**Frontend Project**: https://github.com/reisllucas/demoCrud/tree/main/demoCrudFrontend

**JUnit Tests**: https://github.com/reisllucas/demoCrud/tree/main/demoCrudBackend/src/test/java/br/com/demo/crud/crudbackend

**JavaDoc**: https://github.com/reisllucas/demoCrud/tree/main/demoCrudBackend/javadoc

**Postman**: https://github.com/reisllucas/demoCrud/blob/main/demoCrudBackend/DemoCrud.postman_collection.json

**H2 Login**: http://localhost:8080/h2-ui

  **Credentials**: 
  
    url: jdbc:h2:mem:db
    
    driverClassName: org.h2.Driver
    
    username: sa
    
    password:
    
    
---
### Getting Started

## Backend

**Requisits: JDK 17**

**Compile**: mvn clean install

**Run**: mvn spring-boot:run

**URL**: localhost:8080

## Frontend

**Requisits: Node 20.1**

**Install dependencies**: npm install

**Run**: npm start

**URL**: localhost:4200

## Run with docker

docker pull reisllucas/democrud:latest

docker run -d --name democrud -p 8080:8080 -t reisllucas/democrud:latest

