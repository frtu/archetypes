#set( $HASH = '#' )
${HASH} Project - ${artifactId}

${HASH}${HASH} About

Project description

${HASH}${HASH} API

Browse service sample API at

* GET or POST : [http://localhost:8080/v1/emails](http://localhost:8080/v1/emails)
* GET by ID : [http://localhost:8080/v1/emails/{id}](http://localhost:8080/v1/emails)

${HASH}${HASH}${HASH} Sync with WebMVC

* Access Swagger API at [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
* Access API Docs (JSON) at [http://localhost:8080/v3/api-docs/](http://localhost:8080/v3/api-docs/)

${HASH}${HASH}${HASH} Async with WebFlux

* Access Swagger API at [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

${HASH}${HASH} Integration with Docker

Build your Docker image at ```mvn verify``` phase

Startup your application using :

```
docker run -d --name <instance-name> -p 8080:8080 -P <your-archetype-id>
```

* -d : startup as a daemon
* --name : give it a name

${HASH}${HASH} Release notes

${HASH}${HASH}${HASH} ${version} - Current version

* Feature list