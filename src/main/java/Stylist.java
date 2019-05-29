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
    public String getName(){
        return name;
    }
    public String getMail(){
        return email;
    }
    public String getPhone(){
        return phone;
    }
}
