package examples.repository.advertence.infrastructure.dao;

import examples.dao.entity.AdvertenceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertenceRepository2 extends CrudRepository<AdvertenceEntity, Long> {

}
