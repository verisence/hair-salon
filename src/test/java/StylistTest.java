import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {
    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();
    
    @Test
    public void stylist_instantiatesCorrectly_true() {
        Stylist testStylist = new Stylist("Terry", "terry@mail.mail", "998877");
        assertTrue(testStylist instanceof Stylist);
    }
    
}
