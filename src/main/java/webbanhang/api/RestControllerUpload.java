package webbanhang.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	
	@RequestMapping(path = "/getImage/{filename}.{suffix}", method = RequestMethod.GET)
	public void getImage(HttpServletResponse response, @PathVariable String filename,@PathVariable("suffix") String suffix) throws IOException {
	    File file = new File("D:\\workspace\\web-banhang\\webbanhang\\src\\main\\webapp\\template\\img\\"+filename+"."+suffix);
	    if(file.exists()) {
	        String contentType = "application/octet-stream";
	        response.setContentType(contentType);
	        OutputStream out = response.getOutputStream();
	        FileInputStream in = new FileInputStream(file);
	        // copy from in to out
	        IOUtils.copy(in, out);
	        out.close();
	        in.close();
	    }else {
	        throw new FileNotFoundException();
	    }
	}
	
}
