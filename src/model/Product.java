package model;

public class Product {
	private Supplier supplier;
	private String name;
	private String brand;
	private double purchasePrice;
	private double salesPrice;
	private String countryOfOrigen;
	private int minStock;
	private int stock;
	private long id;
	private String description;
	private String category;
	
	public Product(Supplier supplier, String name, String brand, double purchasePrice, double salesprice, 
			String countryOfOrigen, int minStock, int stock, long id, String description, String category) {
		this.supplier = supplier;
		this.name = name;
		this.brand = brand;
		this.purchasePrice = purchasePrice;
		this.salesPrice = salesprice;
		this.countryOfOrigen = countryOfOrigen;
		this.minStock = minStock;
		this.stock = stock;
		this.id = id;
		this.description = description;
		this.category = category;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public String getName() {
		return name;
	}

	public String getBrand() {
		return brand;
	}

	public String getCountryOfOrigen() {
		return countryOfOrigen;
	}

	public int getMinStock() {
		return minStock;
	}

	public int getStock() {
		return stock;
	}

	public long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setCountryOfOrigen(String countryOfOrigen) {
		this.countryOfOrigen = countryOfOrigen;
	}

	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
