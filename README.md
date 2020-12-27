# Maven artefact generator

Note : The artecfacts below all rely on [base-pom](https://search.maven.org/artifact/com.github.frtu.archetype/base-pom/1.1.0/pom) that helps to normalize all the libraries CVE fixes and version upgrades.

Feel free to inline some of the dependencies or all dependencies & remove dependency to this pom.xml (it's a template).

## Overview

Allow to generate a project for :

- Base project (Label : **base**) : suitable for lib, command line, ...
- Spring Boot project (Label : **spring-boot**) : suitable for web project (backend or frontend)

NOTE : when using **mvngen**, just append the project **label**.

Ex : 

* ```mvngenlocal base com.github.frtu.cmd cmd``` : generate a base project called ```cmd``` 
* ```mvngenlocal spring-boot com.github.frtu.web web``` : generate a spring-boot artifact for called ```web```

## Catalog

A **Module** is a standalone project with one single pom OR can be hosted in a Platform projet.

A **Platform** means that it comes with a parent pom, hosting a sub project. When you generate another module at its root folder, the new module is append next to the others.

Generate archetypes with the below commands :

- Replace **x.y.z** with the latest version

### Module - Base

Base project are generated for libraries or command line. Just include :

* Loggers using [log-platform](https://github.com/frtu/log-platform)
* Maven plugin for Code Coverage (jacoco) & code quality (spotbugs)

Build will fail if SpotBugs find issues with FindBugs. See Bugs descriptions at
[http://findbugs.sourceforge.net/bugDescriptions.html](http://findbugs.sourceforge.net/bugDescriptions.html)

### Module - Spring Boot

Allow to generate a spring-boot project based on a basic template. 


#### Override version - [version 1.1.1](https://github.com/frtu/archetypes/releases/tag/v1.1.1)

You can override sprint-boot version by 

* checking [available version in the repo](https://search.maven.org/artifact/org.springframework.boot/spring-boot-starter-parent)
* Override maven generator properties by saying ```N```
* Override property value that you need (else just type ```[Enter]```)

Sample stack :

```
Confirm properties configuration:
groupId: com.github.frtu.web
artifactId: web
version: 0.0.1-SNAPSHOT
package: com.github.frtu.web
base-pom-version: 1.1.1-SNAPSHOT
spring-boot-version: 2.4.1
 Y: : N
[INFO] Using property: groupId = com.github.frtu.web
[INFO] Using property: artifactId = web
[INFO] Using property: version = 0.0.1-SNAPSHOT
Define value for property 'package' com.github.frtu.web: :
Define value for property 'base-pom-version' 1.1.1-SNAPSHOT: :
Define value for property 'spring-boot-version' 2.4.1: : 2.4.0
Confirm properties configuration:
groupId: com.github.frtu.web
artifactId: web
version: 0.0.1-SNAPSHOT
package: com.github.frtu.web
base-pom-version: 1.1.1-SNAPSHOT
spring-boot-version: 2.4.0
 Y: : Y
```

### Going forward

* Allow async data ingestion with spring-boot and webflux
* Expand on [data governance](https://github.com/frtu/governance-toolbox) & processing with Avro and Spark

~ Have fun !
