# Maven artefact generator

Note : The artecfacts below all rely on [base-pom](https://search.maven.org/artifact/com.github.frtu.archetype/base-pom/1.1.0/pom) that helps to normalize all the libraries CVE fixes and version upgrades.

Feel free to inline some of the dependencies or all dependencies & remove dependency to this pom.xml (it's a template).

## Overview

Allow to generate a project for :

- Base project (Label : **base**)
- Spring Boot project (Label : **spring-boot**)

NOTE : when using **mvngen**, just append the project **label**.

Ex : ```mvngenlocal base com.github.frtu.cmd cmd```

## Catalog

A **Module** is a standalone project with one single pom OR can be hosted in a Platform projet.

A **Platform** means that it comes with a parent pom, hosting a sub project. When you generate another module at its root folder, the new module is append next to the others.

Generate archetypes with the below commands :

- Replace **x.y.z** with the latest version

### Going forward

* Allow async data ingestion with spring-boot and webflux
* Expand on [data governance](https://github.com/frtu/governance-toolbox) & processing with Avro and Spark

~ Have fun !
