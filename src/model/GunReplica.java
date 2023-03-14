package model;

public class GunReplica extends Product{
    private String caliber;
    private String material;

    public GunReplica(Supplier supplier, String name, String brand, int price, String countryOfOrigen, int minStock, int stock, long id, String description, String caliber, String material) {
        super(supplier, name, brand, price, countryOfOrigen, minStock, stock, id, description);
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
