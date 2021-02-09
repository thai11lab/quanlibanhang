package webbanhang.dto;


import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import webbanhang.entity.ProductEntity;


public class ProductDto extends BaseDto{
	
	private String name;
	
	
	private String code;
	

	private String mainImageUrl;

	private String description;
	
	
	private Double price;

	
	private Boolean isShow;
	
	private String websiteUrl;
	
	private Long idCategories [] ;
	
	
	
	public ProductDto(ProductEntity entity) {
		if(entity != null) {
			this.id=entity.getId();
			this.code = entity.getCode();
			this.name = entity.getName();
			this.mainImageUrl= entity.getMainImageUrl();
			this.description =entity.getDescription();
			this.price = entity.getPrice();
			this.isShow = entity.getIsShow();
			this.websiteUrl = entity.getWebsiteUrl();
			
			if (entity.getProductCategorie() != null ) {
					
			}
		}
	}
	
	



	


	public ProductDto(String name, String code, String mainImageUrl, String description, Double price, Boolean isShow,
			String websiteUrl, Long[] idCategories) {
		super();
		this.name = name;
		this.code = code;
		this.mainImageUrl = mainImageUrl;
		this.description = description;
		this.price = price;
		this.isShow = isShow;
		this.websiteUrl = websiteUrl;
		this.idCategories = idCategories;
	
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
	
	public ProductDto() {
		super();
	}
	public Long[] getIdCategories() {
		return idCategories;
	}
	public void setIdCategories(Long[] idCategories) {
		this.idCategories = idCategories;
	}

}
