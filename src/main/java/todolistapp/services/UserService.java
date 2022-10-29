package todolistapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todolistapp.repositories.UserRepository;
import todolistapp.user.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserService() {}

    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
