package examples.repository.students.election.application;

import examples.repository.students.election.domain.model.votes.Votes;

public interface ElectionFacade {

    Votes votes(Votes votes);
}
