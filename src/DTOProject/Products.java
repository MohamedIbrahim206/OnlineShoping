package DTOProject;

public class Products {
    private int id;
    private float price;
    private String name;
    private Number amount;

    public Products(){}
    public Products(int id , String name , Number amount , float price){
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAmount(Number amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }
    public float getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
    public Number getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name= " + name + ", price= " + price + ", amount= " + amount;
    }
}
