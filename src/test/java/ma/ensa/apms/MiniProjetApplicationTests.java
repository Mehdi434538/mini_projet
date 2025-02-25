package ma.ensa.apms;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MiniProjetApplicationTests {

    @Test
    void contextLoads() {
        int result = 1+1;
        assertEquals(result, 1 + 1, () -> "Good, It's working"); // Now this resolves
    }

}
