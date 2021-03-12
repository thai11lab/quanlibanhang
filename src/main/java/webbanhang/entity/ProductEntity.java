package webbanhang.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductEntity  extends BaseEntity {
	
	@Column(name = "name")
	private String name;
	
	@Column(name="code")
	private String code;
	
	@Column(name="main_image_url")
	private String mainImageUrl;
	
	@Column(name="description", columnDefinition="TEXT")
	private String description;
	
	@Column(name="price")
	private Double price;

	@Column(name="isshow")
	private Boolean isShow;
	
	@Column(name = "total_product")
	private int totalProduct;
	
	@Column(name="website_url")// website link
	private String websiteUrl; 
	
	@OneToMany(mappedBy = "productEntity",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	private Set<ProductCategory> productCategorie;  
	
	@OneToMany(mappedBy = "productEntity",fetch = FetchType.LAZY)
	Set<OrderProductEntity> orderProductEntities;
	
	public ProductEntity(String name, String code, String mainImageUrl, String description, Double price,
			Boolean isShow, String websiteUrl, Set<ProductCategory> productCategorie,int totalProduct) {
		super();
		this.name = name;
		this.code = code;
		this.mainImageUrl = mainImageUrl;
		this.description = description;
		this.price = price;
		this.isShow = isShow;
		this.websiteUrl = websiteUrl;
		this.productCategorie = productCategorie;
		this.totalProduct=totalProduct;
	}

	
	public ProductEntity() {
		super();
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMainImageUrl() {
		return mainImageUrl;
	}

	public void setMainImageUrl(String mainImageUrl) {
		this.mainImageUrl = mainImageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Boolean getIsShow() {
		return isShow;
	}

	public void setIsShow(Boolean isShow) {
		this.isShow = isShow;
	}

	public String getWebsiteUrl() {
		return websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

	public Set<ProductCategory> getProductCategorie() {
		return productCategorie;
	}

	public void setProductCategorie(Set<ProductCategory> productCategorie) {
		this.productCategorie = productCategorie;
	}


	public int getTotalProduct() {
		return totalProduct;
	}


	public void setTotalProduct(int totalProduct) {
		this.totalProduct = totalProduct;
	}


	public Set<OrderProductEntity> getOrderProductEntities() {
		return orderProductEntities;
	}


	public void setOrderProductEntities(Set<OrderProductEntity> orderProductEntities) {
		this.orderProductEntities = orderProductEntities;
	}


	


	
		
}
