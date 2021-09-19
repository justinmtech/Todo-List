package todolistapp.repositories;

import org.springframework.data.repository.CrudRepository;
import todolistapp.user.TodoItem;

public interface TodoItemRepository extends CrudRepository<TodoItem, Integer> {
}
