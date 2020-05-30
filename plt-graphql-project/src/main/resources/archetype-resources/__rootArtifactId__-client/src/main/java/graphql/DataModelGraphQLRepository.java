package ${groupId}.graphql;

import ${groupId}.${artifactId}.${DatamodelClassName};
import ${groupId}.${artifactId}.QueryType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class DataModelGraphQLRepository {
    @Autowired
    private QueryType queryType;

    public List<${DatamodelClassName}> find(String filter) {
        try {
            final List<${DatamodelClassName}> result = queryType.find("{id name value eventTime}", filter);
            return result;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new IllegalArgumentException(e);
        }
    }
}
