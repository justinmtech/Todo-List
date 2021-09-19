package todolistapp.user;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity(name = "users")
@Table(name = "users")
public class User {
    private int id;
    private String username;
    @OneToMany(cascade = CascadeType.ALL)
    private List<TodoItem> todoList;

    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public User() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<TodoItem> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<TodoItem> todoList) {
        this.todoList = todoList;
    }

    @Override
    public String toString() {
        return username;
    }
}


