package ma.ensa.apms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
public class ScrumMaster extends User {

    @OneToMany
    private List<Project> projects;
}
