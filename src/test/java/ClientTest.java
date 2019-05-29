import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;

public class ClientTest {
    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    @Test
    public void Client_instantiatesCorrectly_true(){
        Client client = new Client("Jane", "braids", "jane@mail.com", "998878", 9);
        assertEquals(true, client instanceof  Client);
    }
    @Test
    public void Client_instantiatesWithName_String() {
            Client client = new Client("Jane", "braids", "jane@mail.com", "998878", 9);
        assertEquals("Jane", client.getName());
    }
    @Test
    public void Client_instantiatesWithDesc_String() {
        Client client = new Client("Jane", "braids", "jane@mail.com", "998878", 9);
        assertEquals("braids", client.getDescription());
    }
    @Test
    public void Client_instantiatesWithEmail_String() {
        Client client = new Client("Jane", "braids", "jane@mail.com", "998878", 9);
        assertEquals("jane@mail.com", client.getMail());
    }
    @Test
    public void Client_instantiatesWithPhone_String() {
        Client client = new Client("Jane", "braids", "jane@mail.com", "998878", 9);
        assertEquals("998878", client.getPhone());
    }
    @Test
    public void Client_instantiatesWithStylistId_Integer() {
        Client client = new Client("Jane", "braids", "jane@mail.com", "998878", 9);
        assertEquals(9, client.getStylistId());
    }
    @Test
    public void Client_instantiatesWithAnId() {
        Client client = new Client("Jane", "braids", "jane@mail.com", "998878", 9);
        client.save();
        assertTrue(client.getId()>0);
    }
}
