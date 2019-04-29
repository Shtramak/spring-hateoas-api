package ua.procamp.hateoasapi.dao;

import org.springframework.stereotype.Component;
import ua.procamp.hateoasapi.entity.User;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class InMemoryUserDao implements UserDao {
    private Map<Long, User> map = new ConcurrentHashMap<>();

    {
        map.put(1L, new User(1L, "John Doe", User.Status.ENABLED));
        map.put(2L, new User(2L, "Jane Doe", User.Status.ENABLED));
    }

    @Override
    public Collection<User> findAll() {
        return map.values();
    }

    @Override
    public Optional<User> findById(long id) {
        return Optional.ofNullable(map.get(id));
    }
}
