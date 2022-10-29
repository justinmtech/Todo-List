package todolistapp.user;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity(name = "users")
@Table(name = "todolist_users")
public class User {
    @Id
    private String username;
    private String password;
    @OneToMany(cascade = CascadeType.ALL)
    private List<TodoItem> todoList;

    public User() {
        this.todoList = new LinkedList<>();
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

    public void addTodoItem(TodoItem item) {
        getTodoList().add(item);
    }

    public void removeTodoItem(TodoItem item) {
        getTodoList().remove(item);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return username;
    }
}


