# PlayWright Test Framework
## Getting started :
PlayWright test framework suite is created to test this website throughly. Various scenarios have been covered which could be executed in multiple environments via cli .
## Project Structure :
This project uses Java 8 as compiler and Maven as build tool along with TestNG for testing. `pages` packages contains all the Page classes which extends one BasePage according to POM . Package `assertions` similarly inherit one base assertion class where all common assertion can be defined and reused.. `reports` handles all the reporting functionality for this instance i have used extent reports but we could use any which is available in market. utils consist of utility files which could be used across framework.
## **Installation**
Install Maven and Java 8 in your machine. Clone the project from github.
## **How to execute**
To run the tests from IDE you can go to testng.xml file and run it.
To run the tests  from command line please use this command - `mvn clean test`.
Currently the test will launch in safari and navigate to prelive environment url which is configured from properties file.
If you want to change the parameter from commandline use this command `mvn -Denv=prelive -Dbrowser=chrome clean compile test`
