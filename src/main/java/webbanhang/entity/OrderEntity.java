package webbanhang.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tblorder")
public class OrderEntity extends BaseEntity{
	
	@Column(name="code")
	private String code;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "customer_phone")
	private String customerPhone;
	
	@Column(name = "customer_address")
	private String customerAddress;
	
	@Column(name = "customer_email")
	private String customerEmail;
	
	@Column(name = "delivery_date")
	private Date deliveryDate;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "total_money")
	private double totalMoney;
	
	@OneToMany(mappedBy = "orderEntity",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<OrderProductEntity> orderProductEntities;
	
	public OrderEntity() {
		super();
	}
	
	
	public OrderEntity(String code, String customerName, String customerPhone, String customerAddress,Date deliveryDate,String email,int status,double totalMoney) {
		super();
		this.code = code;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerAddress = customerAddress;
		this.deliveryDate=deliveryDate;
		this.customerEmail = email;
		this.status= status;
		this.totalMoney=totalMoney;
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


	


	public Date getDeliveryDate() {
		return deliveryDate;
	}


	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}


	public Set<OrderProductEntity> getOrderProductEntities() {
		return orderProductEntities;
	}


	public void setOrderProductEntities(Set<OrderProductEntity> orderProductEntities) {
		this.orderProductEntities = orderProductEntities;
	}


	public String getCustomerEmail() {
		return customerEmail;
	}


	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
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
