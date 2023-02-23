
# FizzBuzz Game Application

This application implements the rules of the FizzBuzz game. Given a number `N`, the application returns a list of strings, where each string corresponds to a number in the range `1` to `N` based on the rules of the FizzBuzz game: http://en.wikipedia.org/wiki/Fizz_buzz

## API

The API for the game is accessible at the endpoint `/api/v1/fizzbuzz/{input}`, where `{input}` is a path parameter representing the input number. The method used is `GET`. The API returns a JSON object with the following structure:

```1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz```

## UI

The user interface (UI) for the FizzBuzz game is accessible at the root endpoint `/`. The UI provides a form where the user can input a number `N` and submit the form to get the corresponding FizzBuzz output.

## Requirements

To run this application, you need to have one of the following installed:

- Docker
- Java 11
- Maven 3.8.x

## Building and Running the Application

To build and run the application, follow these steps:

1. Clone the repository
2. Open a terminal in the project directory
3. Build the project with Maven:

```
mvn clean package
```

4. Run the application with Docker:

```
docker build -t fizzbuzz .
docker run -p 8080:8080 fizzbuzz
```

or 
```
docker-compose up
```
or with Java:

```
java -jar target/fizzbuzz-1.0.jar
```

5. Access the UI in your web browser at http://localhost:8080

## Testing

To run the tests for this application, follow these steps:

1. Open a terminal in the project directory
2. Run the tests with Maven:

```
mvn test
```
