import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

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
    @Test
    public void save_savesCorrectly() {
        Client client = new Client("Jane", "braids", "jane@mail.com", "998878", 9);
        client.save();
        assertTrue(Client.all().get(0).equals(client));
    }
    @Test
    public void find_returnsClientWIthSameID_secondClient(){
        Client clientOne = new Client("Jane", "braids", "jane@mail.com", "998878", 9);
        clientOne.save();
        Client clientTwo = new Client("Jennifer", "braids and nails", "jene@mail.com", "9988783", 2);
        clientTwo.save();
        assertEquals(Client.find(clientTwo.getId()), clientTwo);
    }
    @Test
    public void equals_returnsTrueIfClientsAreSame(){
        Client clientOne = new Client("Jane", "braids", "jane@mail.com", "998878", 9);
        Client clientTwo = new Client("Jane", "braids", "jane@mail.com", "998878", 9);
        assertTrue(clientOne.equals(clientTwo));
    }
    @Test
    public void save_returnsTrueIfDescriptionsAreTheSame(){
        Client client = new Client("Jane", "braids", "jane@mail.com", "998878", 9);
        client.save();
        assertEquals(Client.all().get(0), client);
    }
    @Test
    public void all_returnsAllInstancesOfClients_true(){
        Client client = new Client("Jane", "braids", "jane@mail.com", "998878", 9);
        client.save();
        Client clientTwo = new Client("Jennifer", "braids and nails", "jene@mail.com", "9988783", 2);
        clientTwo.save();
        assertEquals(Client.all().get(0), client);
        assertEquals(Client.all().get(1), clientTwo);
    }
    @Test
    public void save_assignsIdToObject() {
        Client client = new Client("Jane", "braids", "jane@mail.com", "998878", 9);
        client.save();
        Client savedClient = Client.all().get(0);
        assertEquals(client.getId(), savedClient.getId());
    }
    //TODO add saves catIntoDb, retrieve
    @Test
    public void update_updateClientDescription_true(){
        Client myClient = new Client("Jane", "braids", "jane@mail.com", "998878", 9);
        myClient.save();
        myClient.update("Jas", "nails and braids", "jams@mail.mail", 8, "998766");
        assertEquals("Jas", Client.find(myClient.getId()).getName());
        assertEquals("nails and braids", Client.find(myClient.getId()).getDescription());
        assertEquals("jams@mail.mail", Client.find(myClient.getId()).getMail());
        assertEquals(8, Client.find(myClient.getId()).getStylistId());
        assertEquals("998766", Client.find(myClient.getId()).getPhone());
    }
    @Test
    public void delete_deletesClient_true(){
        Client client = new Client("Jane", "braids", "jane@mail.com", "998878", 9);
        client.save();
        int clientId = client.getId();
        client.delete();
        assertEquals(null, Client.find(clientId));
    }
    @Test
    public void save_savesStylistIdIntoDB_true(){
        Stylist stylist = new Stylist("Terry", "terry@mail.mail", "998877");
        stylist.save();
        Client client = new Client("Jane", "braids", "jane@mail.com", "998878", stylist.getId());
        client.save();
        Client savedClient = Client.find(client.getId());
        assertEquals(savedClient.getStylistId(), stylist.getId());
    }
    @Test
    public void getClients_retrievesAllClientsFromDatabase_clientsList() {
        Stylist myStylist = new Stylist("Terry", "terry@mail.mail", "998877");
        myStylist.save();
        Client firstClient = new Client("Jane", "braids", "jane@mail.com", "998878", myStylist.getId());
        firstClient.save();
        Client secondClient = new Client("Jas", "braids and nails", "jams@mail.com", "998898", myStylist.getId());
        secondClient.save();
        Client[] clients = new Client[] { firstClient, secondClient };
        assertTrue(myStylist.getClients().containsAll(Arrays.asList(clients)));
    }
}
