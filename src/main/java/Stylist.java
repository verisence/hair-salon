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
}
