package ua.procamp.hateoasapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.Identifiable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements Identifiable<Long> {
    private Long id;
    private String name;
    private Status status;

    public enum Status {
        ENABLED,
        DISABLED
    }
}
