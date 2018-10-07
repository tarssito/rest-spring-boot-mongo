package com.tarssito.restmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tarssito.restmongo.domain.User;
import com.tarssito.restmongo.dto.UserDTO;
import com.tarssito.restmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> listdto = list.stream()
				.map(u -> new UserDTO(u)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listdto);
	}
}
