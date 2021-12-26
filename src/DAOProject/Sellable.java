package DAOProject;

public interface Sellable {
    String getName();
    Number getAmount();
    float getCost();
    void updateAmount(Number a);
    public int getNum();
    public float getWeight();
}
