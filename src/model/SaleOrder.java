package model;

import java.sql.Timestamp;

public class SaleOrder {
	private long saleOrderId;
	private Timestamp date;
	private String deliveryStatus;
	private Timestamp deliveryDate;
	private long customerId;
	private long orderLineId;

	public SaleOrder(long saleOrderId, Timestamp date, String deliveryStatus, Timestamp deliveryDate, long customerId, long orderLineId) {
		this.saleOrderId = saleOrderId;
		this.date = date;
		this.deliveryStatus = deliveryStatus;
		this.deliveryDate = deliveryDate;
		this.customerId = customerId;
		this.orderLineId = orderLineId;
	}

	public SaleOrder() {
	}

	public long getSaleOrderId() {
		return saleOrderId;
	}

	public void setSaleOrderId(long saleOrderId) {
		this.saleOrderId = saleOrderId;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public Timestamp getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Timestamp deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getOrderLineId() {
		return orderLineId;
	}

	public void setOrderLineId(long orderLineId) {
		this.orderLineId = orderLineId;
	}
}
