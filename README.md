# Catalog Service Microservice

## Table of contents

- [Purpose](#purpose)
- [Technology](#technology)
- [Prerequisites](#prerequisites)
- [Setting up](#setting-up-the-code)
- [Building the application in dev mode](#building-the-application-in-dev-mode)
- [Project Structure](#project-structure)
- [Application Properties](#application-properties)
- [Coding DOs and DONTs](#coding-dos-and-donts)
- [Unit Testing](#unit-testing)
- [Third Party Dependencies](#third-party-dependencies)
- [Pull Requests](#pull-requests)


## Purpose
This Microservice provides REST APIs for exposing the catalog

## Technology

This microservice uses **SpringBoot 3** and deployed as **war** file on **JBoss EAP 7.2**

## Prerequisites

The following dependencies should be installed on your machine:

- [JDK](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) (version 17.0)
- [Maven](https://maven.apache.org/download.cgi) (version 3.8.2 or newer)
- [Git](https://git-scm.com/)
-
**IDE**

You may use any IDE of your choice. 

## Setting up the code

Clone the respective branch of the repo to your PC/laptop
```shell script
git clone https://softwarelicense@dev.azure.com/softwarelicense/Experience-Layer/_git/Experience-Layer
```

## Building the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvn clean install
```


> **_NOTE:_** Application runs on the default port 8080.

## Project Structure

- **_webapp_** folder has the extra configuration required for JBoss EAP deployment
- **_java_** holds the source code
- _**resources**_ has the properties files and logging configurations


## Application Properties

application.properties under resources folders consists of static properties such as:
- External connectivity URLs
- External API endpoints
- Logging configurations

## Application health and build url
- Health check url : http://localhost:8091/catalog-service/health-check
- Live ness url : http://localhost:8091/catalog-service/health-check/liveness
- Readiness url : http://localhost:8091/catalog-service/health-check/readiness
- Build Information : http://localhost:8091/catalog-service/info


## Coding DOs and DONT's

- Try to use as much as functional code
- Refer the REST API best practices https://docs.google.com/spreadsheets/d/1RPO6l_Q9UJX4GCgnoaFzUuH4Y2dcedjyTWxN8UKa0O0/edit?usp=sharing

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
git checkout -b feature/feature-name
```
