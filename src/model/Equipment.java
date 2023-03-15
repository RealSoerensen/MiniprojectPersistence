package model;

public class Equipment extends Product {
    private String type;

    public Equipment(long id, long supplierId, String name, String brand, int price, String countryOfOrigen,
            int minStock, int stock, String description, String type) {
        super(id, supplierId, name, brand, price, countryOfOrigen, minStock, stock, id, description);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
