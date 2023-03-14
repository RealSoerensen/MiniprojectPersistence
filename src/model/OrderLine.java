package model;

public class OrderLine {
	int amount;
	int discount;
	boolean status;
	public OrderLine(int amount, int discount, boolean status){
		this.amount = amount;
		this.discount = discount;
		this.status = status;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
