package ${groupId};

import lombok.extern.slf4j.Slf4j;
import com.github.frtu.logs.config.LogConfigAll;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;

@Slf4j
@SpringBootApplication
@Import({LogConfigAll.class})
@EntityScan("${groupId}.repository")
public class Application implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private DataModelRepository repository;

    @Override
    public void run(String... args) throws Exception {
        final DataModel model = new DataModel();
                .withName("name")
                .withType(${DatamodelClassName}Type.SINGLE)
                .withValue(10.3F)
                .withEventTime("2020-08-09")
                .build();
        final ${DatamodelClassName} savedModel = repository.save(model);
        System.out.println(savedModel.getId());
    }
}
