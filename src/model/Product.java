package model;

public class Product {
	private Supplier supplier;
	private String name;
	private String brand;
	private int price;
	private String countryOfOrigen;
	private int minStock;
	private int stock;
	private long id;
	private String description;
	
	public Product(Supplier supplier, String name, String brand, int price, String countryOfOrigen, int minStock, int stock, long id, String description) {
		this.supplier = supplier;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.countryOfOrigen = countryOfOrigen;
		this.minStock = minStock;
		this.stock = stock;
		this.id = id;
		this.description = description;
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

	public int getPrice() {
		return price;
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

	public void setPrice(int price) {
		this.price = price;
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
	
	
}
