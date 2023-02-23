package examples.repository.advertence.domain.model.advertence;

import examples.repository.advertence.domain.queries.AllAdvertenceByDirector;

import java.util.Collection;

public interface AdvertenceRepository {

    Advertence save(Advertence advertence);

    Collection<Advertence> findAll(AllAdvertenceByDirector query);
}
