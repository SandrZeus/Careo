# Careo

Community-driven car rating platform where users rate cars across multiple categories and browse aggregate rankings powered by Bayesian averaging.

## Tech Stack

**Backend:** Java 25, Spring Boot 4, PostgreSQL, Flyway

**Frontend:** React, TypeScript (coming soon)

## Development

### Prerequisites
- JDK 25
- Docker
- Node.js (for frontend, later)

### Database
```bash
docker run -d \
  --name careo-db \
  -e POSTGRES_DB=careo \
  -e POSTGRES_USER=careo \
  -e POSTGRES_PASSWORD=careo \
  -p 5432:5432 \
  -v careo-pgdata:/var/lib/postgresql/data \
  postgres:17
```

### Run
```bash
cd backend
./gradlew bootRun
```

## License

[AGPL-3.0](LICENSE)