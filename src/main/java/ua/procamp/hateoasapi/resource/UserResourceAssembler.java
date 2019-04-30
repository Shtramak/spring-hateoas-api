package ua.procamp.hateoasapi.resource;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import ua.procamp.hateoasapi.controller.UserController;
import ua.procamp.hateoasapi.entity.User;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

public class UserResourceAssembler extends ResourceAssemblerSupport<User, UserResource> {

    public UserResourceAssembler() {
        super(User.class, UserResource.class);
    }

    @Override
    public UserResource toResource(User user) {
        UserResource userResource = new UserResource(user);

        Link selfLink = linkTo(UserController.class)
                .slash(user.getId())
                .withSelfRel();
        userResource.add(selfLink);

        Link disableLink = linkTo(UserController.class)
                .slash(user.getId())
                .slash("disable")
                .withRel("disable-user");
        userResource.add(disableLink);

        return userResource;
    }
}
