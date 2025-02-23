package ma.ensa.apms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class ProductBacklog {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @OneToOne
    private  Project project;

    @OneToMany(mappedBy = "productBacklog", fetch = FetchType.LAZY)
    private List<UserStory> userStories;



}
