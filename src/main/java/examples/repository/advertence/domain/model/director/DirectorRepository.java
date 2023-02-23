package examples.repository.advertence.domain.model.director;

import java.util.Optional;

public interface DirectorRepository {

    Optional<Director> findOne(Long id);
}
