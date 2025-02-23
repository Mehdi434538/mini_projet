package ma.ensa.apms;

import ma.ensa.apms.model.ProductBacklog;
import ma.ensa.apms.repository.EpicRepository;
import ma.ensa.apms.repository.ProductBacklogRepository;
import ma.ensa.apms.repository.ProjectRepository;
import ma.ensa.apms.repository.UserStoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class MiniProjetApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniProjetApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ProjectRepository projectRepository,
                            ProductBacklogRepository productBacklogRepository,
                            UserStoryRepository userStoryRepository,
                            EpicRepository epicRepository){
        return args ->{
           Stream.of("PB1","PB2","PB3")
                   .forEach(name->{
                       ProductBacklog productBacklog1 = new ProductBacklog();
                       productBacklog1.setNom(name);
                   });

        };
    }

}
