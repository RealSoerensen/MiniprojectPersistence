package dal;

import model.Product;

import java.util.List;

public class ProductContainer {
	private List<Product> products;
	private long productID; //Reference variable for products.
	
	public ProductContainer(long productID) {
		this.productID = productID;
	}
	
	public Product getProductById(long id) {
		Product tempProduct = null;
		int i = 0;
		boolean found = false;
		
		while(i < products.size() && !found) {
			if(products.get(i).getId() == id) {
				tempProduct = products.get(i);
				found = true;
			}
		}
		
		return tempProduct;
	}
	
	public boolean removeProduct(Product product) {
		boolean isRemoved = false;
		
		if(products.contains(product)) {
			products.remove(product);
			isRemoved = true;
		}
		
		return isRemoved;
	}

	public List<Product> getProducts() {
		return products;
	}

	public long getProductID() {
		return productID;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}
}
