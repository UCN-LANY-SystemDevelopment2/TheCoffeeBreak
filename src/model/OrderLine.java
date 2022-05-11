package model;

public class OrderLine {

	private int quantity;
	private Product item;
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getSubTotal() {
		
		if(item == null)
			return 0;
		
		return item.getPrice() * quantity;
	}
	
	public Product getItem() {
		return item;
	}
	
	public void setItem(Product item) {
		this.item = item;
	}
}
