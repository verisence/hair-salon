import org.sql2o.Connection;

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
}
