## Movie Application

This is a simple implementation of a Movie Application.
With this app, users have access to movies via a REST API.
This is intended to be hooked up to a frontend.

This project is made of 3 separate Docker containers that hold:

- PostgreSQL database (localhost:5432)
- pgAdmin4 database tool (localhost:5050)
- Java Spring Boot backend (localhost:8080)
---

### Prerequisites

In order to run this application you need to install two tools: **Docker** & **Docker Compose**.

Instructions how to install **Docker** on [Ubuntu](https://docs.docker.com/install/linux/docker-ce/ubuntu/), [Windows](https://docs.docker.com/docker-for-windows/install/) , [Mac](https://docs.docker.com/docker-for-mac/install/) .

**Dosker Compose** is already included in installation packs for *Windows* and *Mac*, so only Ubuntu users need to follow [these instructions](https://docs.docker.com/compose/install/).

The latest docker image can be found at https://hub.docker.com/r/clh7090/movieapp/

---

### How to run it?

the entire application can be run with a single command in a terminal:

```
$ docker-compose up -d
```

If you want to stop the application use following command:

```
$ docker-compose down
```
---

### Postgres (database)
The database is housed on [localhost:5432](http://localhost:5432). <br>
The pgAdmin4 tool can be found here [localhost:5050](http://localhost:5050)
- Host: *postgres*
- User: *postgres*
- Password: *admin*
- Database: *movies*

Like other parts of the application, the Postgres database, along with pgAdmin4, are containerized and 
can be found in the *docker-compose.yml* file.

### springboot-backend (REST API)

This is a Spring Boot based application that connects to a
database and exposes the REST endpoints. These endpoints can be consumed by the
frontend. It supports multiple HTTP REST methods like GET, POST, PUT and
DELETE.

The backend is housed on [localhost:8080](http://localhost:8080) followed by a REST endpoint. <br>

This app is also in a Docker container and its definitions can be found
in these files: <br> 
*./springboot-backend/Dockerfile* <br>
*docker-compose.yml*. 
