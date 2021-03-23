package webbanhang.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_order")
public class OrderProductEntity extends BaseEntity{
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private ProductEntity productEntity;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private OrderEntity orderEntity;
	
	
	public OrderProductEntity(ProductEntity productEntity, OrderEntity orderEntity) {
		super();
		this.productEntity = productEntity;
		this.orderEntity = orderEntity;
	}
	
	
	public OrderProductEntity() {
		super();
	}


	public ProductEntity getProductEntity() {
		return productEntity;
	}

	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}

	public OrderEntity getOrderEntity() {
		return orderEntity;
	}

	public void setOrderEntity(OrderEntity orderEntity) {
		this.orderEntity = orderEntity;
	}
	
	
}
