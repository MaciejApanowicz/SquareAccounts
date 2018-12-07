package pl.maciejapanowicz.SquareAccounts.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.maciejapanowicz.SquareAccounts.models.UserEntity;

public interface UserRepository extends CrudRepository <UserEntity, Integer> {
    boolean existsByEmail (String email);
    boolean existsByEmailAndPassword (String email, String password);
}

