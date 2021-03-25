package webbanhang.dto;

import java.util.Date;

import javax.persistence.Column;

public class OrderDtos extends BaseDto{
	private String code;
	
	
	private String customerName;
	
	
	private String customerPhone;
	
	
	private String customerAddress;
	
	
	private String customerEmail;
	
	private Date deliveryDate;
	
	private int status;
	
	private double totalMoney;
	
	public OrderDtos(String code, String customerName, String customerPhone, String customerAddress,
			String customerEmail, Date deliveryDate,int status,double totalMoney) {
		super();
		this.code = code;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerAddress = customerAddress;
		this.customerEmail = customerEmail;
		this.deliveryDate = deliveryDate;
		this.status = status;
		this.totalMoney = totalMoney;
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


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public double getTotalMoney() {
		return totalMoney;
	}


	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}
	
	
}
