# srm-template
[![Build Status](https://travis-ci.com/digital-delivery-academy/srm-springboot-template.svg?token=xvGAAFxX7Kq22jyoY92y&branch=master)](https://travis-ci.com/digital-delivery-academy/srm-springboot-template) `Codacity Quality Report` `Codacy Coverage Report`

A general overview of what `srm-template` does and how it communicates with other micro-services (eg: JSON) and external API's 

## Contents
   - [Getting Started](#getting-started)
      - [Prerequisites](#prerequisites)
      - [Installation](#Installation)
      - [Deployment](#Deployment)
   - [Usage](#usage)
      - [Endpoints](#Endpoints)
      - [Schema](#Schema)
      - [Health-Checks](#Health-Checks)
      - [Database](#Database)

## Getting Started
### Prerequisites
   - Java 1.10
   - Maven
   - SpringBoot
  
### Installation
#### Getting locally stored working
   1. Clone [master](https://github.com/digital-delivery-academy/srm-srm-template) and 
  run `mvn clean install` in its directory
   2. Import project into IntelliJ
   3. Enable Maven auto-import
   4. Create new SpringBoot configuration
   5. Set `Main Class` to `io.lampada.TemplateApplication`
   6. Press Run to launch server

#### Running Tests   
##### In IntelliJ
  1. Create new JUnit Configuration 
  2. Set `Test Kind` to `All in Package`
  3. Set `Search for Tests` to `In Whole Package`
  4. Run configuration

##### Terminal
   - Run command `mvn clean install`

### Deployment
Add deployment information here, similar to installing.
  1. Run `mvn package` on project
  2. Launch Jar file located in `/target/` with `java -jar "jarName.jar"`
  
A server should deploy to the port set in `Application.Properties`

## Usage
### Endpoints
Add a list of all the endpoints here with explanations for each one, if you have multiple entities create new sub-headings.
```http request
GET  /     #Get all example entities stored in the microservice in JSON
GET  /12   #Get example by ID in JSON (12 in this example)
POST /     #Post a new example entity (look at #Schema for more information)
```

### Schema
Explain each entity in the program here, for this example there will only be the one, but for multiple you should add new sub-headers.
#### Test
POST / PUT Example JSON payload
```json
{
  "exampleId" : 12
}
```

### Health-Checks
N/A

### Database 
N/A
