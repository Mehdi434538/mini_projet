package ma.ensa.apms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan("ma.ensa.apms.model")
public class MiniProjetApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniProjetApplication.class, args);
    }

}
