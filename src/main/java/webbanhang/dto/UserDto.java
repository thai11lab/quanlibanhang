package webbanhang.dto;

public class UserDto {
	
	private String userName;

	private String password;

	
	private String fullName;
	
	
	private Integer status;
	
	
	private String email;
	
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserDto(String userName, String password, String fullName, Integer status, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.status = status;
		this.email = email;
		
	}

	public UserDto() {
		super();
	}
	
	
}
