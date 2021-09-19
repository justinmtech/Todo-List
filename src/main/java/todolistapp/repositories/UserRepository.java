package todolistapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import todolistapp.user.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
