package todolistapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import todolistapp.services.UserService;
import todolistapp.user.TodoItem;
import todolistapp.user.User;

import java.util.Optional;

@Controller
public class TodoListManager {

    @Autowired
    UserService userService;

    @GetMapping("/manager")
    public String getTodoListManagerPage(Model model) {
        model.addAttribute("todoItem", new TodoItem());
        return "manager";
    }

    @PostMapping("/manager")
    public String postTodoListManagerPage(@ModelAttribute TodoItem todoItem, Model model) {
        model.addAttribute("todoItem", todoItem);

        Optional<User> userContext = userService.getUserInContext();
        if (userContext.isEmpty()) return "error";
        User user = userContext.get();

        String checkBoxType = todoItem.getRemove();
        if (checkBoxType == null) {
            user.addTodoItem(todoItem);
            userService.saveUser(user);
            return "manager";
        }

        if (checkBoxType.equals("yes")) user.removeTodoItem(todoItem);
        else if (checkBoxType.equals("all")) user.setTodoList(null);
        userService.saveUser(user);

        return "manager";
    }
}