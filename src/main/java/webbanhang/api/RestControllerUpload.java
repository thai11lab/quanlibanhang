package webbanhang.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import webbanhang.dto.ProductDto;
import webbanhang.service.UploadFileService;

@RestController(value = "apiUploadFile")
@RequestMapping("/api/upload")
public class RestControllerUpload {
	
	@Autowired
	UploadFileService uploadFileService; 
	
	@PostMapping
	public ResponseEntity<ProductDto> uploadImage(HttpServletRequest servletRequest,@RequestParam("file") MultipartFile file,@RequestParam("productId") Long productId){
		ProductDto dto = uploadFileService.uploadImage(servletRequest,file,productId);
		
		return new ResponseEntity<ProductDto>(dto,HttpStatus.OK);
	}
}
