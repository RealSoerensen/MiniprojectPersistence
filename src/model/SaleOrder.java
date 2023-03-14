package model;

public class SaleOrder {
	int orderId;
	String date;
	String deliveryStatus;
	String deliveryDate;
	double totalPrice;
	public SaleOrder(int orderId, String date, String deliveryStatus, String deliveryDate, double totalPrice) {
		this.orderId = orderId;
		this.date = date;
		this.deliveryStatus= deliveryStatus;
		this.deliveryDate = deliveryDate;
		this.totalPrice = totalPrice;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
