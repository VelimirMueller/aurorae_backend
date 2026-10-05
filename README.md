<div align="center">

# Aurorae Backend

**A backend service for user verification and subscription management.**

Built with [Kotlin](https://kotlinlang.org/) and [Quarkus](https://quarkus.io/) — the Supersonic Subatomic Java Framework.

[![MIT License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Quarkus](https://img.shields.io/badge/Quarkus-3.17.6-blue?logo=quarkus)](https://quarkus.io/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.0.21-purple?logo=kotlin)](https://kotlinlang.org/)
[![Java](https://img.shields.io/badge/Java-17-orange?logo=openjdk)](https://openjdk.org/)

</div>

---

## Table of Contents

- [Overview](#overview)
- [Tech Stack](#tech-stack)
- [Getting Started](#getting-started)
- [API Reference](#api-reference)
- [Project Structure](#project-structure)
- [License](#license)

## Overview

Aurorae Backend is a RESTful API service that handles user authentication, registration, and subscription management. It provides a secure admin dashboard and public-facing endpoints, powered by Quarkus for fast startup times and low memory footprint.

## Tech Stack

| Technology | Purpose |
| --- | --- |
| **Kotlin 2.0** | Primary language |
| **Quarkus 3.17** | Application framework |
| **Hibernate ORM + Panache** | ORM / data access |
| **PostgreSQL** | Relational database |
| **Quarkus Security JPA** | Authentication & authorization |
| **Quinoa** | Frontend integration |
| **REST Assured** | API testing |
| **Maven** | Build tool |
| **Docker** | Containerization |

## Getting Started

### Prerequisites

- **Java 17+**
- **Maven 3.9+** (or use the included Maven Wrapper)
- **PostgreSQL** instance (local or remote)
- **Docker** (optional, for containerized deployment)

### Installation

1. **Clone the repository**

   ```bash
   git clone https://github.com/VelimirMueller/aurorae_backend.git
   cd aurorae_backend
   ```

2. **Configure the database**

   Credentials come from the environment, never from the repo. For local dev, copy the template and set your own password:

   ```bash
   cp .env.example .env   # .env is git-ignored
   ```

   | Variable | Default | Purpose |
   |---|---|---|
   | `DB_USERNAME` | `pgsql_admin` | Postgres user |
   | `DB_PASSWORD` | *(none)* | Postgres password — required to connect |
   | `DB_URL` | `jdbc:postgresql://localhost:5432/aurorae` | JDBC URL |

   In dev and test mode the password defaults to empty so tests run without a database. In the `prod` profile it has no default: if `DB_PASSWORD` is unset, Quarkus stops at startup with `SRCFG00011: Could not expand value DB_PASSWORD`.

   > **Security note:** before 2026-10-02 a database password was committed in `application.properties`. It is still in git history and must be treated as leaked: never use it for any database, and rotate it wherever it was used.

3. **Run in development mode** (with live reload)

   ```bash
   ./mvnw quarkus:dev
   ```

   The application will be available at `http://localhost:8080`.

4. **Run tests**

   ```bash
   ./mvnw test
   ```

### Building for Production

**Package the application:**

```bash
./mvnw package
```

**Build a native executable** (requires GraalVM):

```bash
./mvnw package -Dnative
```

**Run with Docker:**

```bash
docker build -f src/main/docker/Dockerfile.jvm -t aurorae-backend .
export DB_PASSWORD='<your-db-password>'   # required: the prod profile refuses to start without it
docker run -i --rm -p 8080:8080 \
  -e DB_PASSWORD -e DB_URL=jdbc:postgresql://host.docker.internal:5432/aurorae \
  aurorae-backend
```

## API Reference

### Public Endpoints

| Endpoint | Method | Content Type | Auth | Description |
| --- | --- | --- | --- | --- |
| `/public` | `GET` | `application/json` | No | Returns the landing page data (anonymous access). |
| `/public` | `POST` | `application/json` | No | Submits data for the landing page. |
| `/hello` | `POST` | `application/json` | No | A simple greeting endpoint. |

### Admin Dashboard

| Endpoint | Method | Content Type | Auth | Description |
| --- | --- | --- | --- | --- |
| `/admin` | `GET` | `application/json` | Yes | Access the protected Aurorae admin dashboard. |

### Authentication API

| Endpoint | Method | Content Type | Auth | Description |
| --- | --- | --- | --- | --- |
| `/api/v1/login` | `POST` | `application/json` | No | Log in as an existing user. |
| `/api/v1/register` | `POST` | `application/json` | No | Register a new user account. |

<details>
<summary><strong>Request Body Examples</strong></summary>

**Login** — `POST /api/v1/login`

```json
{
  "emailAddress": "user@example.com",
  "password": "yourPassword"
}
```

**Register** — `POST /api/v1/register`

```json
{
  "username": "johndoe",
  "emailAddress": "user@example.com",
  "password": "yourPassword",
  "passwordRepeat": "yourPassword"
}
```

</details>

## Project Structure

```
aurorae_backend/
├── .github/              # GitHub Actions workflows & Dependabot config
├── src/
│   ├── main/
│   │   ├── docker/       # Dockerfiles (JVM & native)
│   │   ├── kotlin/
│   │   │   ├── api/      # REST resource endpoints
│   │   │   └── entitiy/  # JPA entity definitions
│   │   └── resources/    # Application configuration
│   └── test/             # Test sources
├── pom.xml               # Maven project configuration
└── README.md
```

## License

This project is licensed under the **MIT License** — see the [LICENSE](LICENSE) file for details.
