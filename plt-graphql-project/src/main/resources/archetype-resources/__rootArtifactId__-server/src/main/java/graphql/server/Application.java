package ${groupId}.graphql.server;

import ${groupId}.${artifactId}.model.*;
import ${groupId}.graphql.server.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Slf4j
@SpringBootApplication
@EntityScan("${groupId}.${artifactId}.model")
public class Application implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private DataModelRepository repository;

    @Override
    public void run(String... args) throws Exception {
        final ${DatamodelClassName} model = ${DatamodelClassName}.builder()
                .withName("name")
                .withType(${DatamodelClassName}Type.SINGLE)
                .withValue(10.3F)
                .withEventTime("2020-08-09")
                .build();
        final ${DatamodelClassName} savedModel = repository.save(model);
        System.out.println(savedModel.getId());
    }
}
