package examples.repository.students.election.domain.model.elector;

import examples.repository.infrastructure.ServiceLocator;
import examples.repository.students.election.domain.model.candidate.Candidate;
import examples.repository.students.election.domain.model.votes.Votes;
import examples.repository.students.election.domain.model.votes.VotesRepository;

public class Elector {

    private Long id;

    private VotesRepository repository;


    public Votes votesForThe(Candidate candidate) {
        return repository.save(new Votes(null, candidate, this));
    }
    public Elector(Long id) {
        this.id = id;
        this.repository = ServiceLocator.getBean(VotesRepository.class);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
