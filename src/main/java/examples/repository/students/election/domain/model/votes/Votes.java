package examples.repository.students.election.domain.model.votes;

import examples.repository.students.election.domain.model.candidate.Candidate;
import examples.repository.students.election.domain.model.elector.Elector;

public class Votes {

    private Long id;
    private Candidate candidate;
    private Elector elector;

    public Votes(Long id, Candidate candidate, Elector elector) {
        this.id = id;
        this.candidate = candidate;
        this.elector = elector;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Elector getElector() {
        return elector;
    }

    public void setElector(Elector elector) {
        this.elector = elector;
    }
}
