package ua.procamp.hateoasapi.resource;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;
import ua.procamp.hateoasapi.entity.User;

@Getter
@Setter
public class UserResource extends ResourceSupport {
    private String name;
    private User.Status status;
}
