package pl.sda.javadublin1spring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Primary
@Component
public class InMemoryUserRepository implements UserRepository {

    private List<User> users;
    private RepositoryHelper repositoryHelper;

    @Autowired
    public InMemoryUserRepository(RepositoryHelper repositoryHelper) {
        this.users = new ArrayList<>();
        this.repositoryHelper = repositoryHelper;
    }

    InMemoryUserRepository(List<User> users){
        this.users = users;
    }

    @Override
    public Optional<User> findById(Long id) {
        if (id == null || id <= 0){
            throw new IllegalArgumentException();
        }
        return users.stream()
                .filter(user -> id.equals(user.getId()))
                .findFirst();
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @PostConstruct
    private void init(){
        this.users.add(new User(1L, "Szymon", "Nowak", Gender.MALE));
        this.users.add(new User(2L, "Jan", "Kowalski", Gender.MALE));
        this.users.add(new User(3L, "Anna", "Wisniewska", Gender.FEMALE));
        this.users.add(new User(4L, "Karolina", "Nowak", Gender.FEMALE));
    }
}
