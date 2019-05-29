import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;

public class ClientTest {
    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    @Test
    public void client_instantiatesCorrectly_true(){
        Client client = new Client("Jane", "braids", "jane@mail.com", "998878", 9);
        assertEquals(true, client instanceof  Client);
    }

}
