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
    // try , catch required here
    public void setPhone(String phone){
        if(phone.length() == 11)
            this.phone = phone;
        else
            System.out.println("Invalid Phone");
    }
    public String getName(){
        return name;
    }
    public String getPhone(){
        return phone;
    }
}
