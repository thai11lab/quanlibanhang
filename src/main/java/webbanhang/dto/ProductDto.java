package webbanhang.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import webbanhang.entity.ProductEntity;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDto extends BaseDto{
	
	private String name;
	
	
	private String code;
	

	private String mainImageUrl;

	private String description;
	
	
	private Double price;

	
	private Boolean isShow;
	
	private String websiteUrl;

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
		}
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
	
}
