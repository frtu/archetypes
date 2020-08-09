package ${groupId}.graphql.server.repository;

import ${groupId}.${artifactId}.model.${DatamodelClassName};
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DataModelRepository extends JpaRepository<${DatamodelClassName}, UUID> {

}
