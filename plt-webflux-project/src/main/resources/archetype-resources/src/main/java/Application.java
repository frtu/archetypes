package ${groupId};

import ${groupId}.repository.DataModelRepository;
import ${groupId}.repository.DataModel;
import lombok.extern.slf4j.Slf4j;
import com.github.frtu.logs.config.LogConfigAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
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
        model.setName("name");
        model.setValue(10.3F);
        model.setEventTime("2020-08-09");
        final DataModel savedModel = repository.save(model);
        System.out.println(savedModel.getId());
    }
}
