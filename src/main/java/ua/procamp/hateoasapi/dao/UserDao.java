package ua.procamp.hateoasapi.dao;

import ua.procamp.hateoasapi.entity.User;

import java.util.Collection;
import java.util.Optional;

public interface UserDao {
    Collection<User> findAll();

    Optional<User> findById(long id);
}
