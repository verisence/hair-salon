import org.sql2o.Connection;
import java.util.List;

public class Client {
    private int id;
    private String name;
    private String description;
    private String email;
    private String phone;
    private int stylistId;

    public Client(String name, String description, String email, String phone, int stylistId){
        this.name = name;
        this.description = description;
        this.email = email;
        this.phone = phone;
        this.stylistId = stylistId;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public String getMail(){
        return email;
    }
    public String getPhone(){
        return phone;
    }
    public int getStylistId(){
        return stylistId;
    }

    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO clients (name, description, email, stylistId, phone) VALUES(:name, " +
                    ":description, :email, :stylistId, :phone)";
            this.id = (int) con.createQuery(sql,true)
                    .addParameter("name", this.name)
                    .addParameter("description", this.description)
                    .addParameter("email", this.email)
                    .addParameter("stylistId", this.stylistId)
                    .addParameter("phone", this.phone)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Client> all(){

        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT id, name, description, email, stylistId, phone FROM clients";
            return con.createQuery(sql).executeAndFetch(Client.class);
        }
    }

    @Override
    public boolean equals (Object otherClient){
        if (!(otherClient instanceof Client)){
            return false;
        }else{
            Client client =(Client) otherClient;
            return this.getId() == client.getId()&&
                    this.getName().equals(client.getName()) &&
                    this.getDescription().equals(client.getDescription()) &&
                    this.getMail().equals(client.getMail()) &&
                    this.getPhone().equals(client.getPhone())&&
                    this.getStylistId() == client.getStylistId();
        }
    }

    public static Client find(int id){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM clients where id=:id";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Client.class);
        }
    }

    public void update(String name, String description, String email, int stylistId, String phone){
        try(Connection con = DB.sql2o.open()){
            String sql = "UPDATE clients SET name = :name, description = :description, email = :email, phone = " +
                    ":phone, stylistId = :stylistId" +
                    " WHERE id = :id";
            con.createQuery(sql)
                    .addParameter("name", name)
                    .addParameter("description", description)
                    .addParameter("email", email)
                    .addParameter("stylistId", stylistId)
                    .addParameter("phone", phone)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }
}
