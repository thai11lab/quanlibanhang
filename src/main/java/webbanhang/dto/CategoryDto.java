package webbanhang.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import webbanhang.entity.CategoryEntity;
import webbanhang.entity.ProductCategory;

public class CategoryDto extends BaseDto{

	private String code;
	
	private String name;
	
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
	public CategoryDto(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	public CategoryDto() {
		super();
	}
	
	public CategoryDto(CategoryEntity entity) {
		if (entity != null) {
			this.id=entity.getId();
			this.code = entity.getCode();
			this.name = entity.getName();
		}
	}
	
}
