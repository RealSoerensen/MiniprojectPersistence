package model;

public class OrderLine {
	private long orderLineId;
	private int quantity;
	private long discount;
	private long productId;
	
	public OrderLine(long orderLineId, int quantity, long discount, long productId){
		this.orderLineId = orderLineId;
		this.quantity = quantity;
		this.discount = discount;
		this.productId = productId;
	}

	public OrderLine(){
	}

	public long getOrderLineId() {
		return orderLineId;
	}

	public void setOrderLineId(long orderLineId) {
		this.orderLineId = orderLineId;
	}

	public long getDiscount() {
		return discount;
	}
	public void setDiscount(long discount) {
		this.discount = discount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}
}
