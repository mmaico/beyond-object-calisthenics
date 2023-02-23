package examples.repository.students.election.domain.model.candidate;

public class Candidate {
    private Long id;

    public Candidate(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
