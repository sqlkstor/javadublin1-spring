package pl.sda.javadublin1spring.user;

import org.springframework.stereotype.Service;
import pl.sda.javadublin1spring.user.entities.Gender;
import pl.sda.javadublin1spring.user.entities.User;
import pl.sda.javadublin1spring.user.exceptions.InvalidParameterException;
import pl.sda.javadublin1spring.user.exceptions.UserNotFoundException;

import java.util.List;

@Service
public class UserService {
    private JpaUserRepository jpaUserRepository;

    public UserService(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    public User findById(Long id) {
        return jpaUserRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public Iterable<User> findAll() {
        return jpaUserRepository.findAll();
    }

    public List<User> fingByGender(String gender){
        try {
            Gender enumGender = Gender.valueOf(gender);
            return jpaUserRepository.findByGender(enumGender);
        }catch(IllegalArgumentException e){
            throw new InvalidParameterException("gender");
        }

    }

    public void saveUser(User user) {
        jpaUserRepository.save(user);
    }
}