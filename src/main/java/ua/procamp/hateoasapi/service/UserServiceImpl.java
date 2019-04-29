package ua.procamp.hateoasapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.procamp.hateoasapi.dao.UserDao;
import ua.procamp.hateoasapi.entity.User;
import ua.procamp.hateoasapi.resource.UserResource;
import ua.procamp.hateoasapi.resource.UserResourceAssembler;

import java.util.List;
import java.util.NoSuchElementException;

import static java.util.stream.Collectors.toList;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final UserResourceAssembler resourceAssembler;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
        resourceAssembler = new UserResourceAssembler();
    }

    @Override
    public List<UserResource> findAll() {
        return userDao.findAll()
                .stream()
                .map(resourceAssembler::toResource)
                .collect(toList());
    }

    @Override
    public UserResource findById(Long id) {
        User user = userDao.findById(id).orElseThrow(NoSuchElementException::new);
        return resourceAssembler.toResource(user);
    }

    @Override
    public UserResource findByIdAndDisable(Long id) {
        User user = userDao.findById(id).orElseThrow(NoSuchElementException::new);
        user.setStatus(User.Status.DISABLED);
        return resourceAssembler.toResource(user);
    }
}
