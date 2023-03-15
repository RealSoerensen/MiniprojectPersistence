package model;

public class GunReplica extends Product {
    private String caliber;
    private String material;

    public GunReplica(long id, long supplierId, String name, String brand, double purchasePrice, double salesPrice, String countryOfOrigen, int minStock, int stock, String description, String category, String caliber, String material) {
        super(id, supplierId, name, brand, purchasePrice, salesPrice, countryOfOrigen, minStock, stock, description, category);
        this.caliber = caliber;
        this.material = material;
    }

    public String getCaliber() {
        return caliber;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
