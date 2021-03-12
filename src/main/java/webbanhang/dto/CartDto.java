package webbanhang.dto;

public class CartDto{
	private ProductDto productDto;
	private int quantity;
	private double totalPrice;
	
	public CartDto(ProductDto productDto, int quantity,double totalPrice) {
		super();
		this.productDto = productDto;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
	public CartDto() {
		super();
	}
	public ProductDto getProductDto() {
		return productDto;
	}
	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}	
	
}
