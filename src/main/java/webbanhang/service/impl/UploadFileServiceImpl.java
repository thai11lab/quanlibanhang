package webbanhang.service.impl;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import webbanhang.dto.ProductDto;
import webbanhang.service.ProductService;
import webbanhang.service.UploadFileService;
@Service
public class UploadFileServiceImpl implements UploadFileService{
	
	
	
	@Autowired
	ProductService productService; 
	
	
	@SuppressWarnings("unused")
	@Override
	public ProductDto uploadImage(HttpServletRequest servletRequest,MultipartFile file,Long productId) {
		
		String fileName = file.getOriginalFilename().split("\\.(?=[^\\.]+$)")[0];
		String extension = file.getOriginalFilename().split("\\.(?=[^\\.]+$)")[1];
		UUID fileNameImage = UUID.randomUUID();
		try { 
			File fileToBeSaved = new File(servletRequest.getServletContext().getRealPath("/template"), fileNameImage + "." + extension);
			file.transferTo(fileToBeSaved);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		String mainImageUrl =fileNameImage+"."+extension;
		ProductDto dto = productService.updateImage(mainImageUrl, productId);
		return dto;
	}
	
}
