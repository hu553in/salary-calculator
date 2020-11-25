# Salary calculator

## Description

This project is a simple client-server app for calculating the salary of
different employee types using different formulas.\
The purpose of this project is to learn layered architecture and
some types of testing.

## Tech stack

* Spring Boot (Kotlin)
* React
* PostgreSQL
* nginx

## How to run

### Docker

1. Install `GNU Make`, `Docker`, `Docker Compose`, `OpenJDK` (≥ 11)
2. Create a relative symlink to [the GUI](https://github.com/hu553in/salary-calculator-gui)
named `./gui` (e.g. `ln -rs ../salary-calculator-gui ./gui`)
3. Run `make` to run the app
4. Run `make testBackend` in the another terminal window
in case if you want to run backend unit tests
5. Run `make testFrontend` in the another terminal window
in case if you want to run UI tests with a mock API
6. Run `make testEndToEnd` in the another terminal window
in case if you want to run integration (end-to-end) tests with a real API
