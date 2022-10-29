package todolistapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import todolistapp.services.UserService;
import todolistapp.user.TodoItem;
import todolistapp.user.User;

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
        try {
            model.addAttribute("todoItem", todoItem);
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            User user = userService.getAllUsers().stream().filter(u -> u.getUsername().equals(username)).findFirst().orElse(null);
            try {
                if (todoItem.getRemove().equalsIgnoreCase("yes")) {
                    TodoItem todoItem2 = user.getTodoList().stream().filter(t -> t.getName().equals(todoItem.getName())).findFirst().orElse(null);
                    user.getTodoList().remove(todoItem2);
                } else if (todoItem.getRemove().equalsIgnoreCase("all")) {
                    user.setTodoList(null);
                }
            } catch (Exception e) {
                    user.getTodoList().add(todoItem);
                }
                userService.saveUser(user);
                return "manager";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }
}