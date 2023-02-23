package examples.repository.advertence.application;

import examples.repository.advertence.domain.model.advertence.Advertence;
import examples.repository.advertence.domain.model.director.Director;
import org.springframework.data.domain.Page;

import java.util.Collection;

public interface AdvertenceFacade {

    Advertence apply(Advertence advertence);

    Collection<Advertence> findAll(Director director, Page<Advertence> page);
}
