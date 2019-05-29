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
    @Test
    public void getName_stylistInstantiatesWithName_String() {
        Stylist testStylist = new Stylist("Terry", "terry@mail.mail", "998877");
        assertEquals("Terry", testStylist.getName());
    }
    @Test
    public void getName_stylistInstantiatesWithEmail_String() {
        Stylist testStylist = new Stylist("Terry", "terry@mail.mail", "998877");
        assertEquals("terry@mail.mail", testStylist.getMail());
    }
    @Test
    public void getName_stylistInstantiatesWithPhone_String() {
        Stylist testStylist = new Stylist("Terry", "terry@mail.mail", "998877");
        assertEquals("998877", testStylist.getPhone());
    }
}
