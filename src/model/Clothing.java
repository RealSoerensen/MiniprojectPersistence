package model;

public class Clothing extends Product{
    private String size;
    private String color;

    public Clothing(Supplier supplier, String name, String brand, double purchasePrice, double salesPrice, 
    		String countryOfOrigen, int minStock, int stock, long id, String description, String category, String size, String color) {
        super(supplier, name, brand, purchasePrice, salesPrice, countryOfOrigen, minStock, stock, id, description, category);
        this.size = size;
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
