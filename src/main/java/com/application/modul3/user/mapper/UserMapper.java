package com.application.modul3.user.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.application.modul3.user.User;
import com.application.modul3.user.dto.UserCreateDTO;
import com.application.modul3.user.dto.UserDTO;

@Service
public class UserMapper {
	
	public User userCreateDTO2User(UserCreateDTO userCreateDTO) {
		User user = new User();
		user.setLastName(userCreateDTO.getLastName());
		user.setFirstName(userCreateDTO.getFirstName());
		user.setAddress(userCreateDTO.getAddress());
		user.setMail(userCreateDTO.getMail());
		return user;	
	}

	public UserDTO user2UserDTO(User user) {
	UserDTO userDTO = new UserDTO();
	userDTO.setId(user.getId());
	userDTO.setLastName(user.getLastName());
	userDTO.setFirstName(user.getFirstName());
	userDTO.setAddress(user.getAddress());
	userDTO.setMail(user.getMail());
		return userDTO;
	}

	public List<UserDTO> userList2userDTOList(List<User> allUser) {
		return allUser.stream().map(user -> user2UserDTO(user)).collect(Collectors.toList());
	}

	public User userDTO2User(UserDTO userDTO) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setAddress(userDTO.getAddress());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setMail(userDTO.getMail());
		return user;
	}

}
