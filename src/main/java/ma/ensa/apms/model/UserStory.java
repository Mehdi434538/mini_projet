package ma.ensa.apms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class UserStory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;
    private int priorite;
    private String status;

    @ManyToOne
    private ProductBacklog productBacklog;

    @ManyToOne
    private Epic epic;

}
