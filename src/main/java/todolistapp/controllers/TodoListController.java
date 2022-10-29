package todolistapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import todolistapp.security.CustomUserDetails;
import todolistapp.security.CustomUserDetailsService;
import todolistapp.services.UserService;
import todolistapp.user.User;

@Controller
public class TodoListController {

    @Autowired
    UserService userService;

    @GetMapping("/list")
    public String getTodoListPage(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.getUserById(username);
        if (user == null) return "error";
        model.addAttribute("user", user);
        return "list";
    }
}
