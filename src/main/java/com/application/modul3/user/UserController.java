package com.application.modul3.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.modul3.user.dto.UserCreateDTO;
import com.application.modul3.user.dto.UserDTO;
import com.application.modul3.user.mapper.UserMapper;

@RestController // face ca acest controller sa fie primul nivel din schema noastra si sa stie ca
				// frontend-ul va comunica cu acest prim nivel
@RequestMapping("/users") // indica ca toate APIS-urile din controller incept cu 'users'
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserMapper userMapper;

	// build create user Rest API
	@PostMapping
	public UserDTO createUser(@RequestBody UserCreateDTO userCreateDTO) {
		User user = userService.createUser(userMapper.userCreateDTO2User(userCreateDTO));
		return userMapper.user2UserDTO(user);
	}

	@GetMapping("/list")
	public List<UserDTO> getAllUsers() {
		return userMapper.userList2userDTOList(userService.getAllUser());
	}

	@GetMapping("/{id}")
	public UserDTO getUsersById(@PathVariable Integer id) {
		return userMapper.user2UserDTO(userService.getUserById(id));
	}

	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable Integer id) {
		userService.deleteUserById(id);
	}

	@PutMapping("/{id}")
	public UserDTO updateUser(@RequestBody UserDTO userDTO, @PathVariable Integer id) {
		User user = userService.updateUser(userMapper.userDTO2User(userDTO), id);
		return userMapper.user2UserDTO(user);
	}
}
