package webbanhang.dto;

import java.util.Date;

import javax.persistence.Column;

public class OrderDtos {
	private String code;
	
	
	private String customerName;
	
	
	private String customerPhone;
	
	
	private String customerAddress;
	
	
	private String customerEmail;
	
	private Date deliveryDate;
	
	
	public OrderDtos(String code, String customerName, String customerPhone, String customerAddress,
			String customerEmail, Date deliveryDate) {
		super();
		this.code = code;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerAddress = customerAddress;
		this.customerEmail = customerEmail;
		this.deliveryDate = deliveryDate;
	}
	
	
	public OrderDtos() {
		super();
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
	
}
