# Catalog Microservice

## Table of contents

- [Catalog Microservice](#catalog-microservice)
  - [Table of contents](#table-of-contents)
  - [Purpose](#purpose)
    - [Sample Metadata](#sample-metadata)
  - [Technology Stack](#technology-stack)
  - [Development Setup](#development-setup)
  - [Setting up the code](#setting-up-the-code)
  - [Building the application in dev mode](#building-the-application-in-dev-mode)
  - [Project Structure](#project-structure)
  - [Application Properties](#application-properties)
  - [Application health and build url](#application-health-and-build-url)
  - [Coding DOs and DONT's](#coding-dos-and-donts)
  - [Unit Testing](#unit-testing)
  - [Third Party Dependencies](#third-party-dependencies)
  - [Pull Requests](#pull-requests)

## Purpose

This Microservice provides REST APIs for the various meta data for micro-frontends and the external apps.

### Sample Metadata

```json
{
  "ios": {
    "0.0.1": {
      "auth": "https://demo-super-app-container.s3.me-central-1.amazonaws.com/auth-bundle-ios@0.0.1/[name][ext]",
      "creditcards": "https://demo-super-app-container.s3.me-central-1.amazonaws.com/credit-card-onboarding-ios@0.0.1/[name][ext]",
      "settings": "http://localhost:9002/[name][ext]",
      "cryptopwa": "https://zand-pwa.web.app/",
      "binanceweb": "https://www.binance.com/en/nft/home"
    }
  },
  "android": {
    "0.0.1": {
      "auth": "https://demo-super-app-container.s3.me-central-1.amazonaws.com/auth-bundle-android@0.0.1/[name][ext]",
      "creditcards": "https://demo-super-app-container.s3.me-central-1.amazonaws.com/credit-card-onboarding-android@0.0.1/[name][ext]",
      "settings": "http://localhost:9002/[name][ext]",
      "cryptopwa": "https://zand-pwa.web.app/",
      "binanceweb": "https://www.binance.com/en/nft/home"
    }
  }
}
```

## Technology Stack

This microservice uses the following tech stack

- JDK 17
- SpringBoot 3
- Spring Data JPA
- Open API
- H2 database

## Development Setup

The following dependencies should be installed on your machine:

- [JDK](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) (version 17.0)
- [Maven](https://maven.apache.org/download.cgi) (version 3.8.2 or newer)
- [Git](https://git-scm.com/)
- **IDE**

You may use any IDE of your choice.

## Setting up the code

Clone the respective branch of the repo to your PC/laptop

```shell script
git clone https://github.com/zand-super-app/catalog-service/
```

## Building the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvn clean install
```

> **_NOTE:_** Application runs on the default port 8080.

## Project Structure

```
src/main/java/ae/superapp/catalog/
  ├── builder/         # All response builders goes here
  ├── config/          # Custom Springboot configurations are defined here
  ├── constants/       # All constants maintained here
  ├── controller/      # The REST controllers defined under this package
  ├── dto/             # Data transfer objects goes here
  ├── entity/          # Package for maintaining database entities
  ├── exception/       # To maintain all custom exceptions
  ├── repository/      # Custom JPA repositories defined here
  └── service/         # Business logic and orchestration code
```

## Application Properties

application.properties under resources folders consists of static properties such as:

- External connectivity URLs
- External API endpoints
- Logging configurations

## Application health and build url

- Health check url : http://localhost:8080/catalog-service/health-check
- Liveness url : http://localhost:8080/catalog-service/health-check/liveness
- Readiness url : http://localhost:8080/catalog-service/health-check/readiness
- Build Information : http://localhost:8080/catalog-service/info

## Coding DOs and DONT's

- Try to use as much as functional code
- Refer the REST API best practices

## Unit Testing

TODO - write unit and integration tests

**Postman Collections**

All postman collections can been found under main/collections folder. This includes data for various scenarios.

## Third Party Dependencies

No third party SDKs or libaries used as of now

- None

## Pull Requests

We follow pull request process to review and merge the modified code to develop, uat and main branches.

Please ensure the below before raising a new PR

- Code is compiling and local artefacts are generating
- Unit testing of changed features are done and also regression areas validated
- Proper code comments are added and formatting is done
- Hardcoding of env. variables or keys are removed
- Collections are updated with new test data
- Add descriptive PR description with clear testing and regression scopes
- Always raise PR from new branch, never use already merged branch. Use commands like below to create a new branch on the fly

```shell script
git checkout -b features/feature-name
```
