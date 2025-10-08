# Machine Coding - Order Service

This is a simple RESTful web service for managing orders, built with Java and Spring Boot.

## Prerequisites

Before you begin, ensure you have the following installed:
- Java JDK 17 or later
- Gradle 8.5 or later

## Building the Project

To build the project and run the tests, execute the following command from the root directory:

```bash
./gradlew clean build
```

## Running the Application

You can run the application using the Spring Boot Gradle plugin:

```bash
./gradlew bootRun
```

Alternatively, you can run the packaged application:

```bash
java -jar build/libs/machine-coding-0.0.1-SNAPSHOT.jar
```

The application will start on `http://localhost:8080`.

## API Endpoints

The service exposes the following REST endpoints under the base path `/order`:

-   **Create an Order**
    -   `POST /`
    -   **Request Body**: `OrderRequest` JSON object.
    -   **Response**: `OrderResponse` JSON object.

-   **Get Order Details**
    -   `GET /{orderId}`
    -   **Path Variable**: `orderId` - The ID of the order to retrieve.
    -   **Response**: `OrderResponse` JSON object.

-   **Get All Orders**
    -   `GET /all`
    -   **Query Parameter (optional)**: `orderIds` - A list of order IDs to retrieve. If not provided, all orders are returned.
    -   **Response**: A list of `OrderResponse` JSON objects.

-   **Update Order Status**
    -   `PUT /{orderId}/status`
    -   **Path Variable**: `orderId` - The ID of the order to update.
    -   **Request Body**: `UpdateStatusRequest` JSON object (e.g., `{"status": "COMPLETED"}`).
    -   **Response**: `OrderResponse` JSON object with the updated status.

## Technologies Used

-   **Java 17**
-   **Spring Boot 3.2.0**
-   **Gradle 8.5**
-   **Lombok**
