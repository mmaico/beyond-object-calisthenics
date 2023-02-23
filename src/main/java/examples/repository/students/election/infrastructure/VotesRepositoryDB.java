package examples.repository.students.election.infrastructure;

import examples.repository.students.election.domain.model.votes.Votes;
import examples.repository.students.election.domain.model.votes.VotesRepository;
import org.springframework.stereotype.Repository;

@Repository("votesRepository")
public class VotesRepositoryDB implements VotesRepository {
    @Override
    public Votes save(Votes votes) {
        //Sava o voto no banco de dados para ao final extrair o relatorio
        return null;
    }
}
