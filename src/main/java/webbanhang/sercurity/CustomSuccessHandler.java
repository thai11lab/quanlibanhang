package webbanhang.sercurity;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import webbanhang.utils.SecurityUtils;

//Xử lí author phân quyền khi authen thành công
@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		//trả về trang định tuyến
		String targetUrl = determineTargetUrl(authentication);
		if (response.isCommitted()) {
			return;
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}
	
	//chuyển trang tới 
	private String determineTargetUrl(Authentication authentication) {
		// TODO Auto-generated method stub
		String url = "";
		List<String> roles = SecurityUtils.getAuthorities();
		
		if(isAdmin(roles)) {
			url="/admin";
		}else if(isStaff(roles)) {
			url="/admin";
		}else {
			url="/home";
		}
		
		
		return url;
	}
	
	private boolean isAdmin(List<String> roles) {
		if(roles.contains("ADMIN")) {
			return true;
		}
		return false;
	}
	
	private boolean isStaff(List<String> roles) {
		if(roles.contains("STAFF")) {
			return true;
		}
		return false;
	}
	private boolean isUser(List<String> roles) {
		if(roles.contains("USER")) {
			return true;
		}
		return false;
	}
}
