package ua.procamp.hateoasapi.resource;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import ua.procamp.hateoasapi.entity.User;

public class UserResourseAssembler extends ResourceAssemblerSupport<User, UserResource> {

    public UserResourseAssembler() {
        super(User.class, UserResource.class);
    }

    @Override
    public UserResource toResource(User user) {
        UserResource userResource = super.createResourceWithId(user.getId(), user);
        userResource.setName(user.getName());
        userResource.setStatus(user.getStatus());
        return userResource;
    }
}
