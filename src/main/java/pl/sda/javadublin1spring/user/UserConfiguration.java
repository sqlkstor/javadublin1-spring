package pl.sda.javadublin1spring.user;

import java.util.Arrays;

public class UserConfiguration {

    public UserRepository preInitializedInMemoryUserRepository(){
        return new InMemoryUserRepository(Arrays.asList(
                new User(2L, "Jan", "Kowalski", Gender.MALE)
        ));
    }
}
