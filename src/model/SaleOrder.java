package model;

import java.util.Date;

public class SaleOrder {
	private long orderId;
	private Date date;
	private String deliveryStatus;
	private Date deliveryDate;
	private double totalPrice;
	private Date paymentDate;
	
	public SaleOrder(long orderId, Date date, String deliveryStatus, Date deliveryDate, double totalPrice, Date paymentDate ) {
		this.orderId = orderId;
		this.date = date;
		this.deliveryStatus= deliveryStatus;
		this.deliveryDate = deliveryDate;
		this.totalPrice = totalPrice;
		this.paymentDate = paymentDate;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
}
