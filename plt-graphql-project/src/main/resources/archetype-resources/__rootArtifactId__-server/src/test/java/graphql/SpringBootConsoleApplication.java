package ${groupId}.graphql;

import com.github.frtu.logs.tracing.annotation.ExecutionSpan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Override
    @ExecutionSpan
    public void run(String... args) {
        LOGGER.info("args:{}", args);
    }
}
