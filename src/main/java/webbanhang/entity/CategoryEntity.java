package webbanhang.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categorys")
public class CategoryEntity extends BaseEntity{
	@Column(name="code")
	private String code;
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "categoryEntity",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	Set<ProductCategory> productCategories;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Set<ProductCategory> getProductCategories() {
		return productCategories;
	}
	public void setProductCategories(Set<ProductCategory> productCategories) {
		this.productCategories = productCategories;
	}
	public CategoryEntity(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	public CategoryEntity() {
		super();
	}
	
	
}
