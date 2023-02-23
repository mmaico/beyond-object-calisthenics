package examples.repository.students.election.application;

import examples.repository.students.election.domain.model.candidate.Candidate;
import examples.repository.students.election.domain.model.elector.Elector;
import examples.repository.students.election.domain.model.votes.Votes;

public class ElectionApplication implements ElectionFacade {

    @Override
    public Votes votes(Votes votes) {
        //TODO: implementar validacao
        Candidate candidate = votes.getCandidate();
        Elector elector = votes.getElector();

        return elector.votesForThe(candidate);
    }
}
