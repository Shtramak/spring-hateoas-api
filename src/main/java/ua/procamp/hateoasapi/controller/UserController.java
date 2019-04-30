package ua.procamp.hateoasapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.procamp.hateoasapi.resource.UserResource;
import ua.procamp.hateoasapi.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResource> findAll() {
        return userService.findAll();
    }

    @GetMapping("{id}")
    public UserResource findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PutMapping("{id}/disable")
    public void findByIdAndDisable(@PathVariable Long id) {
        userService.findByIdAndDisable(id);
    }
}
