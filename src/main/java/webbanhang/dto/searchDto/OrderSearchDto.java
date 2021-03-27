package webbanhang.dto.searchDto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderSearchDto extends searchDto{
	private Long status;
	private String dateOrder;
	private String dateRecive;
	
	public OrderSearchDto(Long status, String dateOrder, String dateRecive) {
		super();
		this.status = status;
		this.dateOrder = dateOrder;
		this.dateRecive = dateRecive;
	}
	
	public OrderSearchDto() {
		super();
	}

	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public String getDateOrder() {
		return dateOrder;
	}
	public void setDateOrder(String dateOrder) {
		this.dateOrder = dateOrder;
	}
	public String getDateRecive() {
		return dateRecive;
	}
	public void setDateRecive(String dateRecive) {
		this.dateRecive = dateRecive;
	}
	
	
}
