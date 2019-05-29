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
    @Test
    public void save_savesIntoDatabase_true(){
        Stylist stylist = new Stylist("Tracy", "tracy@mail.mail", "998879");
        stylist.save();
        assertEquals(Stylist.all().get(0), stylist);
    }
    @Test
    public void Stylist_instantiatesWithAnId() {
        Stylist stylist = new Stylist("Terry", "terry@mail.mail", "998877");
        stylist.save();
        assertTrue(stylist.getId()>0);
    }
    @Test
    public void save_savesCorrectly() {
        Stylist stylist = new Stylist("Terry", "terry@mail.mail", "998877");
        stylist.save();
        assertTrue(Stylist.all().get(0).equals(stylist));
    }
    @Test
    public void find_returnsStylistWithSameId_secondStylist() {
        Stylist firstStylist = new Stylist("Terry", "terry@mail.mail", "998877");
        Stylist secondStylist = new Stylist("Tracy", "tracy@mail.mail", "998879");
        firstStylist.save();
        secondStylist.save();
        assertEquals(Stylist.find(secondStylist.getId()), secondStylist);
    }
    @Test
    public void equals_returnsTrueIfStylistsAreSame() {
        Stylist firstStylist = new Stylist("Tracy", "tracy@mail.mail", "998879");
        Stylist secondStylist = new Stylist("Tracy", "tracy@mail.mail", "998879");
        assertEquals(firstStylist, secondStylist);
    }
    @Test
    public void all_returnsAllInstancesOfStylist_true() {
        Stylist firstStylist = new Stylist("Tracy", "tracy@mail.mail", "998879");
        Stylist secondStylist = new Stylist("Terry", "terry@mail.mail", "998877");
        firstStylist.save();
        secondStylist.save();
        assertEquals(Stylist.all().get(0), firstStylist);
        assertEquals(Stylist.all().get(1), secondStylist);
    }    
}
