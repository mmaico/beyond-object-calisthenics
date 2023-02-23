package examples.repository.teachers.certification.domain.model.certificatiion;

import examples.repository.infrastructure.domain.CollectionBehavior;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Certifications extends CollectionBehavior<Certification> {


    private Collection<Certification> certifications;

    public Certifications(Collection<Certification> certifications) {
        this.certifications = certifications;
    }

    public Certifications findOnlyNational() {
        List<Certification> result = this.certifications.stream().filter(certification -> certification.getType() == Type.NATIONAL)
                .collect(Collectors.toList());
        return new Certifications(result);
    }

    public Boolean hasInternational() {
        return this.certifications.stream().filter(certification -> certification.getType() == Type.INTERNATIONAL).count() > 0;
    }


    @Override
    public Collection<Certification> getCollection() {
        return this.certifications;
    }
}
