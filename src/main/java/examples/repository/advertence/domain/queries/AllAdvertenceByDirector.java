package examples.repository.advertence.domain.queries;

import examples.repository.advertence.domain.model.advertence.Advertence;
import examples.repository.advertence.domain.model.advertence.AdvertenceRepository;
import examples.repository.advertence.domain.model.director.Director;
import examples.repository.infrastructure.ServiceLocator;
import org.springframework.data.domain.Page;

import java.util.Collection;

public class AllAdvertenceByDirector {


    private AdvertenceRepository repository;
    private Page<Advertence> page;
    private Director director;

    public Page<Advertence> getPage() {
        return page;
    }

    public Director getDirector() {
        return director;
    }

    public static AllAdvertenceByDirector query() {
        return new AllAdvertenceByDirector();
    }

    public AllAdvertenceByDirector() {
        this.repository = ServiceLocator.getBean(AdvertenceRepository.class);
    }

    public PagedBy filteredBy(Director director) {
        this.director = director;
        return page -> {
            this.page = page;
            return repository.findAll(this);
        };
    }

    @FunctionalInterface
    public interface PagedBy {
        Collection<Advertence> pagedBy(Page<Advertence> page);
    }
}
