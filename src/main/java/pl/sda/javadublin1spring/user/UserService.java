package pl.sda.javadublin1spring.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id){
        return userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}