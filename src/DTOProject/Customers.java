package DTOProject;

public class Customers {
    private String name , phone;
    public Customers(){}
    public Customers(String name , String phone){
        this.name = name;
        this.phone = phone;
    }
    public void setName(String name){
        this.name =name;
    }
    public void setPhone(String phone){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public String getPhone(){
        return phone;
    }
}
