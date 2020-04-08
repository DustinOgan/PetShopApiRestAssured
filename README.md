# Pet Shop API Testing Using Rest Assured

The purpose of this project and its expansions will be to demonstrate proficiency in testing RESTful and other types of API's utilizing Java frameworks and libraries.


## Current State
This project utilizes TestNg as for the execution of test classes.  It interacts with the Pet Shop OpenAPI Swagger sample.   Google Code's **json-simple** library was picked for quickly building and encoding the sample POST body for adding a new animal to the database.   **JSONPath** is used for providing groovy-like simplicity for decoding the resulting response body. 

## Prerequisites
This project was built using Open JDK 11.0.5 2019-10-15 as well as Gradle 6.3
Installation instructions can be found here ([https://gradle.org/install/](https://gradle.org/install/))
The homebrew installation will install openJDK as a package dependency.

## Usage


|    command            |execution                         | 
|----------------|-------------------------------|
|gradle clean|`runs the predefined clean task`            |
|gradle build|`runs the predefined build task`            |
|gradle test |`runs the TestNg test cases in the src/test/java folder`|
