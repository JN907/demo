package at.nassberger.demo;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAllUsers() {
        return repository.findAll();
    }

    public User findUser(String username) {
        return repository.findByUsername(username);
    }

    public void saveUser(User user) {
        repository.save(user);
    }
}
