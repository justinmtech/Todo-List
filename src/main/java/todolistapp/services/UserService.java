package todolistapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import todolistapp.repositories.UserRepository;
import todolistapp.user.User;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserService() {}

    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public Optional<User> getUserInContext() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findById(username);
    }
}
