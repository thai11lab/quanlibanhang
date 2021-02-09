package webbanhang.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import webbanhang.dto.ProductDto;

@Service
public interface UploadFileService {
	
	ProductDto uploadImage(HttpServletRequest servletRequest,MultipartFile file,Long productId); 
}
