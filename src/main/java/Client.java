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

}
