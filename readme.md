# srm-template
[![Build Status](https://travis-ci.com/digital-delivery-academy/srm-springboot-template.svg?token=xvGAAFxX7Kq22jyoY92y&branch=master)](https://travis-ci.com/digital-delivery-academy/srm-springboot-template) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/3eeddc15ad6f4d499741c6c8b72dead3)](https://www.codacy.com?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=digital-delivery-academy/srm-springboot-template&amp;utm_campaign=Badge_Grade) `Codacy Coverage Report`

`srm-template` Shows a basic implementation of a springboot micro-service that can be used as a foundation for creating other micro-services

## Contents
 - [Getting Started](#getting-started)
   - [Prerequisites](#prerequisites)
   - [Installation](#Installation)
   - [Deployment](#Deployment)
 - [Usage](#usage)
   - [Endpoints](#Endpoints)
   - [Schema](#Schema)

## Getting Started
### Prerequisites
 - Java 1.10
 - Maven
 - SpringBoot
  
### Installation
#### Generic
 1. `git clone git@github.com:digital-delivery-academy/srm-springboot-template.git`
 2. `mvn clean package`
 3. Run`java -jar "/target/template-0.0.1-SNAPSHOT.jar"` to launch the server

#### In IntelliJ
 1. Clone [master](https://github.com/digital-delivery-academy/srm-srm-template) and run `mvn clean install` in its directory
 2. Import project into IntelliJ
 3. Enable Maven auto-import
 4. Create new SpringBoot configuration
 5. Set `Main Class` to `io.lampada.TemplateApplication`
 6. Press Run to launch server

#### Running Tests 
##### Terminal
 - Run command `mvn clean install`
  
##### In IntelliJ
 1. Create new JUnit Configuration 
 2. Set `Test Kind` to `All in Package`
 3. Set `Search for Tests` to `In Whole Package`
 4. Run configuration

### Deployment
 1. Run `mvn clean install` on project
 2. Run`java -jar "/target/template-0.0.1-SNAPSHOT.jar"` to launch the server
  
A server should deploy to the port set in `Application.Properties`

## Usage
### Endpoints
#### Template Endpoints
```http request
GET  /          #Get all example entities stored in the microservice in JSON
GET  /12        #Get example by ID in JSON (12 in this example)
GET  /health    #Returns health-checks, i.e. JSON {"status":"UP"} and status 200 OK
POST /          #Post a new example entity (look at #Schema for more information)
```

### Schema
#### Template Payloads
POST Example JSON payload
```json
{
  "exampleId" : 12
}
```