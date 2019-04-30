package ua.procamp.hateoasapi.resource;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;
import ua.procamp.hateoasapi.entity.User;

@Getter
@Setter
@NoArgsConstructor
public class UserResource extends ResourceSupport {
    private String name;
    private User.Status status;

    public UserResource(User user) {
        name = user.getName();
        status = user.getStatus();
    }
}
