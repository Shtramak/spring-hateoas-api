package ua.procamp.hateoasapi.service;

import ua.procamp.hateoasapi.resource.UserResource;

import java.util.List;

public interface UserService {
    List<UserResource> findAll();

    UserResource findById(Long id);

    UserResource findByIdAndDisable(Long id);
}
