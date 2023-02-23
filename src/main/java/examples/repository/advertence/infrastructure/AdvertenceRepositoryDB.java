package examples.repository.advertence.infrastructure;

import examples.dao.entity.AdvertenceEntity;
import examples.repository.advertence.domain.model.advertence.Advertence;
import examples.repository.advertence.domain.model.advertence.AdvertenceRepository;
import examples.repository.advertence.domain.model.director.Director;
import examples.repository.advertence.domain.queries.AllAdvertenceByDirector;
import examples.repository.advertence.infrastructure.dao.AdvertenceRepository2;
import examples.repository.advertence.infrastructure.translate.AdvertenceTranslate;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository("advertenceRepository")
public class AdvertenceRepositoryDB implements AdvertenceRepository {

    private AdvertenceTranslate translate;

    private AdvertenceRepository2 dao;

    public AdvertenceRepositoryDB(AdvertenceTranslate translate, AdvertenceRepository2 dao) {
        this.translate = translate;
        this.dao = dao;
    }

    @Override
    public Advertence save(Advertence advertence) {
        AdvertenceEntity entity = translate.fromModel(advertence);
        AdvertenceEntity entitySaved = dao.save(entity);
        return translate.toModel(entitySaved);
    }

    @Override
    public Collection<Advertence> findAll(AllAdvertenceByDirector query) {
        Page<Advertence> page = query.getPage();
        Director director = query.getDirector();
        //TODO: implementar a busca usando os parametros
        return null;
    }
}
