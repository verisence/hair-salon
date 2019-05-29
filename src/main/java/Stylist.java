import java.util.List;
import org.sql2o.*;

public class Stylist {
    private int id;
    private String name;
    private String email;
    private String phone;

    public Stylist(String name, String email, String phone){
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    public int getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public String getMail(){
        return email;
    }
    public String getPhone(){
        return phone;
    }

    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO stylists (name, email, phone) VALUES(:name, :email, :phone)";
            this.id = (int) con.createQuery(sql,true)
                    .addParameter("name", this.name)
                    .addParameter("email", this.email)
                    .addParameter("phone", this.phone)
                    .executeUpdate()
                    .getKey();
        }
    }
    
    public static List<Stylist> all(){
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT id, name, email, phone FROM stylists";
            return con.createQuery(sql).executeAndFetch(Stylist.class);
        }
    }

    @Override
    public boolean equals (Object otherStylist){
        if (!(otherStylist instanceof Stylist)){
            return false;
        }else{
            Stylist stylist =(Stylist) otherStylist;
            return this.getId() == stylist.getId()&&
                    this.getName().equals(stylist.getName()) &&
                    this.getMail().equals(stylist.getMail()) &&
                    this.getPhone().equals(stylist.getPhone());
        }
    }
    public static Stylist find(int id){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM stylists where id=:id";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Stylist.class);
        }
    }
    public List<Client> getClients() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM clients where stylistId=:id";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetch(Client.class);
        }
    }
    public void update(String name, String email, String phone){
        try(Connection con = DB.sql2o.open()){
            String sql = "UPDATE stylists SET name = :name, email = :email, phone = :phone WHERE id = :id";
            con.createQuery(sql)
                    .addParameter("name", name)
                    .addParameter("email", email)
                    .addParameter("phone", phone)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }
    public void delete() {
        try(Connection con = DB.sql2o.open()){
            String sql = "DELETE FROM stylists WHERE id = :id;";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }
}
