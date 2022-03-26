#set( $HASH = '#' )
${HASH} Project - ${artifactId}

${HASH}${HASH} About

Project description

${HASH}${HASH} API

${HASH}${HASH}${HASH} Sync with WebMVC

* Access Swagger API at [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
* Access API Docs (JSON) at [http://localhost:8080/v3/api-docs/](http://localhost:8080/v3/api-docs/)

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