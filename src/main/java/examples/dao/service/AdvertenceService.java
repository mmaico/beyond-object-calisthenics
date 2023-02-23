package examples.dao.service;

import examples.dao.entity.AdvertenceEntity;
import examples.dao.repository.AdvertenceRepository;
import org.springframework.stereotype.Service;

@Service("advertenceServiceModuleDAO")
public class AdvertenceService {

    private AdvertenceRepository repository;

    public AdvertenceService(AdvertenceRepository repository) {
        this.repository = repository;
    }

    public AdvertenceEntity save(AdvertenceEntity entity) {
        return repository.save(entity);
    }

    public Iterable<AdvertenceEntity> findAll() {
        return repository.findAll();
    }
}
