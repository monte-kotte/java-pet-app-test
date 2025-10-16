# 🐾 Java Pet App Test Project

Automated integration test project for the [**js-mongo-pet-app**](https://github.com/monte-kotte/js-mongo-pet-app) backend service.  
Built using **Java 21**, **RestAssured**, **TestNG**, and **AssertJ**.

---

## 🚀 Overview

This project provides REST API integration tests for the Pet Service.
It verifies CRUD operations, data validation, and error responses for pets.

---

## 🧱 Tech Stack

| Component | Description |
|------------|-------------|
| **Java 21** | Core language |
| **RestAssured** | HTTP client for REST API testing |
| **TestNG** | Test framework |
| **AssertJ** | Fluent assertions |
| **Lombok** | Builders and boilerplate reduction |

---

## 💻 Backend Setup (js-mongo-pet-app)

Before running the tests, make sure the backend is running locally.

### 1️⃣ Clone and run the backend

```bash
git clone https://github.com/monte-kotte/js-mongo-pet-app.git
cd js-mongo-pet-app
```

### 2️⃣ Start the backend using Docker

```bash
docker-compose up -d
npm start
```

This starts:

- MongoDB container
- Node.js backend at **http://localhost:3000**

---

## 🧪 Running Tests

### 1️⃣ Clone this repo

```bash
git clone https://github.com/monte-kotte/java-pet-app-test.git
cd java-pet-app-test
```

### 2️⃣ Configure `config.properties`

Create or update the file at:

```text
src/test/resources/config/dev.properties
```

With the following content:
```bash
service.pet.url=http://localhost:3000
service.pet.endpoint=/api/pets
```

💡 **Note:** If your project uses `dev.properties` instead, place the same keys there and ensure `ConfigFileReader` reads the correct file.

### 3️⃣ Run tests with Maven
```bash
mvn clean test
```
