# Technical Exam : NextGear #

### Overview ###

This project is dedicated to the NextGear Capitol technical exam.


The stated goal was to build a Student Registry application, that was capable of basic CRUD operations. 

However, I wanted to take that a step further and implement user account management with security permissions using 
Spring Data and Storm path. 

## Stated Requirements ##


Port bindings 80;
Postgres 9.2+;
jdk 1.8;
gradle 2.2+;


Software      | Version
------------- | -------------
Postgres      | 9.2
Port bindings | 80, 8080, 3000
jdk           | 1.8
gradle        | 2.2+


### Architecture ###

This is a rest based Java spring Hibernate project. 
The front end is react JS, using bootstrap css and js. 


## The Build Process ##

As a gradle application, and with use of the com.moowork.node plugin even the node tasks are built into the gradle 
build process. 

Therefore the only thing you need to do is run the following command.

    gradle clean build

## Deployment ##

There are a few different means for deployment. 

Using the distribution gradle plugin, all artifacts are bundled at the end of the build. 

You then only need to extract either the zip or tar, and run the following command. 

#### Linux and OSX ####
    gradle clean build &&
    cd docker/build/distributions &&
    tar xf NextGear_StudentRegistry.tgz &&
    cd NextGear_StudentRegistry\StudentRegistry
    
#### Windows ####
    gradle clean build &&
    cd docker/build/distributions &&
    unzip NextGear_StudentRegistry.zip &&
    cd NextGear_StudentRegistry\StudentRegistry

    
