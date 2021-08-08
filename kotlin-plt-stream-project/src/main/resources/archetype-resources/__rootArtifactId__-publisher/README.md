#set( $HASH = '#' )
${HASH} Publisher for Project - ${artifactId}

${HASH}${HASH} Integration with Docker

Build your Docker image at ```mvn verify``` phase

Startup your application using :

```
docker run -d --name <instance-name> -p 8080:8080 -P <your-archetype-id>
```

* -d : startup as a daemon
* --name : give it a name

${HASH}${HASH} About

Publisher jar to create library
