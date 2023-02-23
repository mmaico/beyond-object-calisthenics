package examples.dao.repository;

import examples.dao.entity.AdvertenceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("advertenceRepositoryModuleDAO")
public interface AdvertenceRepository extends CrudRepository<AdvertenceEntity, Long> {

}
