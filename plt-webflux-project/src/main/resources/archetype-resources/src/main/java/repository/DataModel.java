package ${groupId}.repository;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class DataModel {
	@Id
	@GeneratedValue
	UUID id;

	String name;
	Float value;
	String eventTime;
}
