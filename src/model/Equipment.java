package model;

public class Equipment extends Product{
    private String type;

    public Equipment(Supplier supplier, String name, String brand, int price, String countryOfOrigen, int minStock, int stock, long id, String description, String type) {
        super(supplier, name, brand, price, countryOfOrigen, minStock, stock, id, description);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
