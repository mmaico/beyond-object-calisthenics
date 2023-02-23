package examples.repository.advertence.application;

import examples.repository.advertence.domain.model.advertence.Advertence;
import examples.repository.advertence.domain.model.advertence.AdvertenceValidator;
import examples.repository.advertence.domain.model.director.Director;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Collection;

import static examples.repository.advertence.domain.model.comunications.Comunication.comunication;
import static examples.repository.advertence.domain.queries.AllAdvertenceByDirector.query;

@Component
public class AdvertenceApplication implements AdvertenceFacade {

    private AdvertenceValidator validator;

    public AdvertenceApplication(AdvertenceValidator validator) {
        this.validator = validator;

    }

    @Override
    public Advertence apply(Advertence advertence) {
        validator.checkRules(advertence);

        var director = advertence.getAppliedBy();
        var student = advertence.getReceived();
        var teacher = advertence.getClassOf();

        Advertence advertenceSaved = director.appliesA(advertence).toThe(student).fromTheClassOf(teacher);

        comunication(advertenceSaved).send();

        return advertenceSaved;
    }

    @Override
    public Collection<Advertence> findAll(Director director, Page<Advertence> page) {
        return query().filteredBy(director).pagedBy(page);
    }
}
