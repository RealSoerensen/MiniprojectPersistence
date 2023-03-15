package model;

public class OrderLine {
	private int quantity;
	private int discount;
	private double price;
	
	public OrderLine(int quantity, int discount, double price){
		this.quantity = quantity;
		this.discount = discount;
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
