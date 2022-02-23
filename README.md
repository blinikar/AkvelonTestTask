# Akvelon Test Task
This is a simple REST API, built with the following tech stack:

## Technologies used
- **Framework**
    - Spring Boot
- **Persistence**
    - Spring Data
    - Hibernate
    - PostgreSQL
- **DevOps**
    - Docker
    - Docker Compose
- **Documentation**
    - Swagger/OpenAPI

## Documentation

Documentation can be found at 'http://localhost:8080/swagger-ui.html/'

## How to build?

### Build and run the project using Docker Compose script
Use docker compose script to deploy app:
```bash
$ git clone https://github.com/blinikar/AkvelonTestTask
$ cd akvelon
$ docker-compose -f docker-compose-dev.yml up -d
```
Application will be available at `http://localhost:8080`
