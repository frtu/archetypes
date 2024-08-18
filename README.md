# Maven artefact generator

Note : The artecfacts below all rely on [base-pom](https://search.maven.org/artifact/com.github.frtu.archetype/base-pom/1.1.0/pom) that helps to normalize all the libraries CVE fixes and version upgrades.

Feel free to inline some of the dependencies or all dependencies & remove dependency to this pom.xml (it's a template).

## Overview

Allow to generate a project for :

- Base project (Label : **base**) : suitable for lib, command line, ...
- Spring Boot project (Label : **spring-boot**) : suitable for web project (backend or frontend)
- Kotlin Base project (Label : **kotlin**) : for kotlin project, ...
- Kotlin Spring Boot project (Label : **kotlin-spring-boot**) : for Kotlin Spring Boot project
- Kotlin Platform Spring Cloud platform project (Label : **kotlin-plt-stream**) : for Kotlin Spring Cloud platform project (platform means multi project with publisher & subscriber)

NOTE : when using **mvngen**, just append the project **label**.

Ex : 

* ```mvngenlocal base cmd``` : generate a base project called ```cmd``` 
* ```mvngenlocal spring-boot web``` : generate a spring-boot artifact for called ```web```
* ```mvngenlocal kotlin kt-base``` : generate a **Kotlin** base project called ```kt-base``` 

```
mvn archetype:generate -DarchetypeGroupId=com.github.frtu.archetype \
-DarchetypeArtifactId=kotlin-project-archetype -DarchetypeVersion=1.1.4 \
-DgroupId=com.github.frtu -DartifactId=kt-base -Dversion=0.0.1-SNAPSHOT
```

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


#### Override version - Starting from [version 1.1.3](https://github.com/frtu/archetypes/releases/tag/v1.1.3)

You can override sprint-boot version by 

* checking [available version in the repo](https://search.maven.org/artifact/org.springframework.boot/spring-boot-starter-parent)
* Override maven generator properties by saying ```N```
* Override property value that you need (else just type ```[Enter]```)

### Module - Kotlin

Base project for Kotlin. You can get started with Kotlin from :

* [kotlinlang.org](https://kotlinlang.org/docs/tutorials/getting-started.html)

#### Override version - [version 1.1.3](https://github.com/frtu/archetypes/releases/tag/v1.1.3)

You can override kotlin version by 

* checking [available version in the repo](https://search.maven.org/artifact/org.jetbrains.kotlin/kotlin-stdlib)
* Override maven generator properties by saying ```N```
* Override property value that you need (else just type ```[Enter]```)

Sample stack :

```
Confirm properties configuration:
groupId: com.github.frtu
artifactId: kt-base
version: 0.0.1-SNAPSHOT
package: com.github.frtu
base-pom-version: 1.1.2
kotlin-version: 1.4.21
 Y: : N
[INFO] Using property: groupId = com.github.frtu
[INFO] Using property: artifactId = kt-base
[INFO] Using property: version = 0.0.1-SNAPSHOT
Define value for property 'package' com.github.frtu: :
Define value for property 'base-pom-version' 1.1.2: :
Define value for property 'kotlin-version' 1.4.21: : 1.4.20
Confirm properties configuration:
groupId: com.github.frtu
artifactId: kt-base
version: 0.0.1-SNAPSHOT
package: com.github.frtu
base-pom-version: 1.1.2
kotlin-version: 1.4.20
 Y: : Y
```

### Module - Kotlin Spring Boot

#### Sync vs Async mode - Starting from [version 1.1.3](https://github.com/frtu/archetypes/releases/tag/v1.1.3)

By default, Kotlin spring-boot comes with Synchronous pattern. If you want to switch to Asynchronous, just uncomment :

* pom.xml : Search for ASYNCHRONOUS and uncomment webflux.

#### Async persistence - Starting from [version 1.1.3](https://github.com/frtu/archetypes/releases/tag/v1.1.3)

If storage needed, use JPA for sync or [r2dbc](https://r2dbc.io/)
for async.

* pom.xml : there are 3 sections marked with JPA to uncomment
* application.properties : uncomment the DB URLs
* Application.kt : uncomment @EnableR2dbcRepositories


### Module - Kotlin Spring Cloud platform

#### Starting from [version 1.1.4](https://github.com/frtu/archetypes/releases/tag/v1.1.4)

* Allow to generate publisher & subscriber for Kafka binding in Spring Cloud


### Going forward

* Allow async data ingestion with spring-boot and webflux
* Expand on [data governance](https://github.com/frtu/governance-toolbox) & processing with Avro and Spark

~ Have fun !


## Release notes

### 2.0.0 - Current version

* Bump to jdk 17
* Bump to `kotlin` 1.9.x & `coroutine` 1.8.x
* Adding `kotlin-spring-boot-3x` 
* Bump `slf4j` => 2.0.x
* Bump graphql-java.version & graphql-maven-plugin -> 22.2 & 2.7

### 1.3.0

* Bump to kotlin 1.7.x
* Simplify gradle dependencies
* Remove AspectJ
* Bump spring.boot -> 2.7.10 <!-- 03/23/2023 -->

### 1.2.5

* Bump frtu.libs -> 1.2.5 <!-- 2023-01-24 -->
* Bump frtu.logger -> 1.1.5
* Bump spring.boot -> 2.7.1 <!-- 2022-06-23 -->
* Bump spring-cloud -> 2021.0.3 <!-- 2022-05-27 -->
* Bump protobuf.version ->3.21.7
* Bump graphql-java.version -> 17.4
* Adding telemetry 1.16.0
* Adding kotest & awaitility
