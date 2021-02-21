package webbanhang.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import webbanhang.dto.CategoryDto;
import webbanhang.service.CategoryService;

@RestController(value = "apiCategory")
@RequestMapping("/api/category")
public class RestControllerCategory {
	
	@Autowired
	CategoryService categoryService; 
	
	@PostMapping
	public CategoryDto addCategory(@RequestBody CategoryDto dto){
		CategoryDto result = categoryService.saveOne(dto,null);
		return result;
	}
	
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<CategoryDto> getOne(@PathVariable("id") Long id){
		CategoryDto result = categoryService.getOne(id);
		return new ResponseEntity<CategoryDto>(result,HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
	public ResponseEntity<CategoryDto> editCategory(@PathVariable("id") Long id,@RequestBody CategoryDto dto){
		CategoryDto result = categoryService.saveOne(dto, id);
		return new ResponseEntity<CategoryDto>(result,result != null ? HttpStatus.OK:HttpStatus.BAD_REQUEST);
	}
	
 	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteCategory(@PathVariable("id") Long id){
 		categoryService.deleteOne(id);
 		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
 	}
}
