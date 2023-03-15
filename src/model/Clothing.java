package model;

public class Clothing extends Product {
    private String size;
    private String color;

    public Clothing(long id, long supplierId, String name, String brand, int price, String countryOfOrigen,
            int minStock, int stock, String description, String size, String color) {
        super(id, supplierId, name, brand, price, countryOfOrigen, minStock, stock, description);
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
