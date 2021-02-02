package webbanhang.api;


import javax.swing.text.StyledEditorKit.BoldAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import webbanhang.dto.ProductDto;
import webbanhang.service.ProductService;

@RestController(value = "apiProduct")
@RequestMapping("/api/product")
public class RestControllerProduct {
	
	@Autowired
	ProductService productService;
	
	@PostMapping
	public ProductDto addProduct(@RequestBody ProductDto dto){
		ProductDto result = productService.saveOne(dto,null);
		return result;
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<ProductDto> getOne(@PathVariable("id") Long id){
		ProductDto result = productService.getOne(id);
		return new ResponseEntity<ProductDto>(result,HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
	public ResponseEntity<ProductDto> editProduct(@PathVariable("id") Long id,@RequestBody ProductDto dto){
		ProductDto result = productService.saveOne(dto, id);
		return new ResponseEntity<ProductDto>(result,result != null ? HttpStatus.OK:HttpStatus.BAD_REQUEST);
	}
	
 	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteProduct(@PathVariable("id") Long id){
 		productService.deleteOne(id);
 		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
 	}
}
