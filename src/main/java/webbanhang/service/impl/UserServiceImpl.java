package webbanhang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import webbanhang.dto.UserDto;
import webbanhang.entity.RoleEntity;
import webbanhang.entity.UserEntity;
import webbanhang.mapper.UserMapper;
import webbanhang.repository.RoleRepository;
import webbanhang.repository.UserRepository;
import webbanhang.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;  
	
	@Override
	@Transactional
	public void saveOne(UserDto dto) {
		// TODO Auto-generated method stub
		UserEntity userEntity = UserMapper.convertToEntity(dto);
		Long userIdRole = (long) 3;
		RoleEntity roleEntity = roleRepository.getOne(userIdRole);
		
		userEntity.getRoles().add(roleEntity);
		
		userRepository.save(userEntity);
	}

}
