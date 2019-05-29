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
}
