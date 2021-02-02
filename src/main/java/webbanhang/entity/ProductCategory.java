package webbanhang.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_category")
public class ProductCategory extends BaseEntity{
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private ProductEntity productEntity;
	
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryEntity categoryEntity;


	public ProductEntity getProductEntity() {
		return productEntity;
	}


	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}


	public CategoryEntity getCategoryEntity() {
		return categoryEntity;
	}


	public void setCategoryEntity(CategoryEntity categoryEntity) {
		this.categoryEntity = categoryEntity;
	}
	
	
}
