package webbanhang.service;

import org.springframework.stereotype.Service;

import webbanhang.dto.UserDto;
@Service
public interface UserService {

	void saveOne(UserDto dto);

}
