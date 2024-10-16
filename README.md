# Spring Boot Web Application

This is a simple Spring Boot web application.

## Building the Application

To build the application, run the following command:

```bash
./mvnw clean install
```

## Running the Application

To run the application, use the following command:

```bash
./mvnw spring-boot:run
```

The application will be accessible at `http://localhost:8080`.

## Using the JFrog Project Creation Endpoint

To create a new project in JFrog Artifactory, send a POST request to the following endpoint:

```
POST /jfrog/project
```

### Request Body

The request body should be a JSON object containing the project details. For example:

```json
{
  "key": "value"
}
```

### Response

The response will be the result of the project creation request forwarded to the JFrog Cloud API.
