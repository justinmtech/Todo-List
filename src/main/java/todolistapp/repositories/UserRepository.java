package todolistapp.repositories;

import org.springframework.data.repository.CrudRepository;
import todolistapp.user.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
