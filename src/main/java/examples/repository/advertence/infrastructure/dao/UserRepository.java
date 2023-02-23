package examples.repository.advertence.infrastructure.dao;

import examples.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {


    @Query("FROM UserEntity as user WHERE user.id = :id AND user.profile.id = :profileId")
    Optional<UserEntity> findOne(Long id, Long profileId);
}
