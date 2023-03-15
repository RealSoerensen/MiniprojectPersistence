package model;

public class Equipment extends Product{
    private String type;

    public Equipment(Supplier supplier, String name, String brand, double purchasePrice, double salesPrice, 
    		String countryOfOrigen, int minStock, int stock, long id, String description, String category, String type) {
        super(supplier, name, brand, purchasePrice, salesPrice, countryOfOrigen, minStock, stock, id, description, category);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
