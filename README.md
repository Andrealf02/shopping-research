# Shopping Project

This Java project follows the principles of hexagonal architecture and SOLID design principles. It implements a simple system for sorting and retrieving product data based on different metrics.


## Getting Started

### Build and Run

1. Clone the repository:

   ```bash
   git clone git@github.com:Andrealf02/shopping-research.git

### Product Management and Sorting Project
This Java project implements an application for the management and sorting of products at Inditex. It uses Gradle as the build system and adheres to the principles of hexagonal architecture and SOLID.

- Project Requirements
- Developed in Java.
- Uses Gradle as the build system.
- Follows hexagonal architecture and SOLID principles.
- Implements a RESTful API for managing and sorting products.
- Proper handling of exceptions and input validation in the controller.
- Includes unit tests to ensure code quality.
- Utilizes the dependency injection design pattern to manage dependencies.

### Project Structure
The project structure follows hexagonal architecture, dividing layers into:

- application: Contains application logic, including services and sorting metrics.
- domain: Defines domain models, such as Product and SortingCriteria.
- infrastructure: Implements interfaces defined in the application layer. Contains controllers, repositories, and configurations.
- presentation: Contains classes related to presentation, such as SortingRequest.

### Running the Project
To run the project, use the following command:

```bash
./gradlew bootRun
```

This will start the application on the default port (usually 8080).

### Testing
The project includes unit tests to ensure code quality. You can run the tests with the following command:

```bash
./gradlew test
```

### Using the RESTful API
#### Sorting Products
- Endpoint

   ```` http
    POST /api/v1/products/sort

Request Body (Example)
```json

{
  "sortingCriteria": {
    "metric": "stockRatio",
    "weights": {
      "stockRatio": 0.7,
      "salesUnits": 0.3
    }
  }
}
````
### Responses
* 200 OK: Returns the sorted list of products.
* 400 Bad Request: Error in the request or validation failure.
* 500 Internal Server Error: Internal server error.

### Author
````
✨ Andrea Franconetti ✨

