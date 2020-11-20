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

1. Install `GNU Make`, `Docker`, `Docker Compose`, `OpenJDK` (≥ 11)
2. Create a relative symlink to [the GUI](https://github.com/hu553in/salary-calculator-gui)
named `./gui` (e.g. `ln -rs ../salary-calculator-gui ./gui`)
3. Run `make` to run the app (or `make test` to run tests instead)
