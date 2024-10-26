package ru.fiarr4ikdev.socialnetwork;

import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.fiarr4ikdev.socialnetwork.model.User;
import ru.fiarr4ikdev.socialnetwork.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class SocialNetworkApplicationTests {

    @Inject
    UserRepository userRepository;

    @Test
    @DisplayName(
          value = "База данных должна добавлять запись и удалять в бд при правильных данных"
    )
    void methodShouldAddAndDeleteNewEntryWithAllRightData() {
        User user = new User("Jane","Doe","JaneDoe@gmail.com","12345678");
        userRepository.save(user);
        User savedUser = userRepository.findById(user.getId());
        assertEquals(user, savedUser);
        userRepository.deleteById(savedUser.getId());
        assertFalse(userRepository.existsById(user.getId()));
    }

}
