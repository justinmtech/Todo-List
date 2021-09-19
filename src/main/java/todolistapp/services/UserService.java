package todolistapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todolistapp.repositories.UserRepository;
import todolistapp.user.User;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserService() {

    }

    public User getUserById(int id) {
        Optional<User> user =  userRepository.findAllById(id);
    }


}
