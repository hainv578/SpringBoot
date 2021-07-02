package com.Asg.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Asg.entity.User;
import com.Asg.dto.UserDTO;

@Service
public class UserMapper {
	@Autowired
	private ModelMapper mapper;

	public User convertToEntity(UserDTO userDTO)
	{
		User entity = mapper.map(userDTO, User.class);
		
		return entity;
	}

	public UserDTO convertToDTO(User entity)
	{
		UserDTO userDTO = mapper.map(entity, UserDTO.class);
		
		return userDTO;
	}
}
