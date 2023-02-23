package examples.repository.advertence.view.support;

import examples.repository.advertence.domain.model.advertence.Advertence;
import examples.repository.advertence.domain.model.director.Director;
import examples.repository.advertence.domain.model.student.Student;
import examples.repository.advertence.domain.model.teacher.Teacher;
import examples.repository.infrastructure.http.ValidationException;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static examples.repository.infrastructure.LinksHelper.extractId;

@Component
public class AdvertenceAssembler implements RepresentationModelAssembler<Advertence, AdvertenceResource> {

    @Override
    public AdvertenceResource toModel(Advertence model) {
        var resource = new AdvertenceResource();
        resource.add(Link.of("/advertences/" + model.getId()));
        resource.add(Link.of("/directors/" + model.getAppliedBy().getId(), "applied-by"));
        resource.add(Link.of("/studants/" + model.getReceived().getId(), "received"));
        resource.add(Link.of("/teachers/" + model.getClassOf().getId(), "class-of"));

        return resource;
    }

    public Advertence fromResource(AdvertenceResource resource) {
        var appliedBy = resource.getLink("applied-by").orElseThrow(() -> new ValidationException("Applied-by link not found"));
        var received = resource.getLink("received").orElseThrow(() -> new ValidationException("Received link not found"));
        var classOf = resource.getLink("class-of").orElseThrow(() -> new ValidationException("Received link not found"));

        var advertence = new Advertence();
        advertence.setReceived(new Student(extractId(received)));
        advertence.setClassOf(new Teacher(extractId(classOf)));
        advertence.setAppliedBy(new Director(extractId(appliedBy)));

        return advertence;
    }

    @Override
    public CollectionModel<AdvertenceResource> toCollectionModel(Iterable<? extends Advertence> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
