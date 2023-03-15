package model;

public class Equipment extends Product {
    private String type;

    public Equipment(long id, long supplierId, String name, String brand, double purchasePrice, double salesPrice, String countryOfOrigen, int minStock, int stock, String description, String category, String type) {
        super(id, supplierId, name, brand, purchasePrice, salesPrice, countryOfOrigen, minStock, stock, description, category);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
