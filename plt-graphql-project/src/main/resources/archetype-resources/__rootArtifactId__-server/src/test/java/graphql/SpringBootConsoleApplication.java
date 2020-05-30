package ${groupId}.graphql;

import ${groupId}.${artifactId}.${DatamodelClassName};
import com.github.frtu.logs.tracing.annotation.ExecutionSpan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@Slf4j
@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {
    @Autowired
    private DataModelGraphQLRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Override
    @ExecutionSpan
    public void run(String... args) {
        final List<${DatamodelClassName}> result = repository.find("");
        LOGGER.info("result:{}", result);
    }
}
