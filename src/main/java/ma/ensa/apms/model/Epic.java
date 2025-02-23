package ma.ensa.apms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Epic {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;
    private int priorite;
    private String status;

    @OneToMany(mappedBy = "epic")
    private List<UserStory> userStories ;

}
