package com.Java5.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Java5.dto.UserDto;
import com.Java5.entity.User;

@Service
public class UserMapper {
	@Autowired
	private  ModelMapper mapper;
public  User convertToEntity(UserDto userDTO){
		User entity = mapper.map(userDTO,User.class);
	
		return entity;
}
	
	public  UserDto convertToDTO(User entity){
		
		UserDto userDTO = mapper.map(entity, UserDto.class);
	return userDTO;
	}
}
