package webbanhang.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webbanhang.dto.UserDto;
import webbanhang.service.UserService;

@RestController
@RequestMapping("/api/signUp")
public class RestControllerSignUp {
	
	@Autowired
	UserService userService; 
	
	@PostMapping
	public ResponseEntity<Object> signUp(@RequestBody UserDto dto){
		userService.saveOne(dto);
		return new ResponseEntity<Object>(dto,HttpStatus.OK);
	}
}
