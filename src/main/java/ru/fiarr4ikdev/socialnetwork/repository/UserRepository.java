package ru.fiarr4ikdev.socialnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fiarr4ikdev.socialnetwork.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findById(int id);
}
