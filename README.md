# Car Adverts REST API

This is a RESTful web service for creating, viewing, modifying, and deleting car adverts.

## Tech Stack

- **Java**: 17
- **Spring Boot**: 3
- **Gradle**: using Kotlin DSL
- **Database**: PostgreSQL (Dockerized)
- **Security**: Basic Authentication

## Features

- View all car adverts with sorting options
- View a single car advert
- Create, modify, and delete car adverts
- Swagger-UI documentation for easy API testing

## Requirements

- JDK 17
- Docker (for PostgreSQL database)

## Setup and Run the Project

1. **Clone the repository:**

   ```bash
   git clone <REPOSITORY_URL>
   cd <CLONED_REPOSITORY_NAME>

## How to start

1. **Start the DB:**
Make sure Docker is running. Start PostgreSQL with Docker:
```bash
docker run --name postgres-db -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=password123 -e POSTGRES_DB=car_adverts -p 5432:5432 -d postgres
```

2. **Run the application:**
From the root of the project, run the application:

```bash
./gradlew bootRun
```

2. **Access the application:**
From the root of the project, run the application:
- API documentation is available at http://localhost:8080/swagger-ui.html.
- Use basic authentication when testing the API via Swagger.

## API Endpoints

### View all adverts
- **GET** `/car/adverts`
- **GET** `/car/adverts?sortby=price`

### View a single advert
- **GET** `/car/adverts/{id}`

### Create a new advert
- **POST** `/car/adverts`

### Modify an advert
- **PUT** `/car/adverts/{id}`

### Delete an advert
- **DELETE** `/car/adverts/{id}`

## Security
The application uses basic authentication to secure the API. Ensure your configuration includes appropriate user credentials.
- **Korisničko ime:** `admin`
- **Lozinka:** `admin123`

## Author

**Antonio Vrdoljak**


