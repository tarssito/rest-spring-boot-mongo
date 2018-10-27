package com.tarssito.restmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarssito.restmongo.domain.User;
import com.tarssito.restmongo.dto.UserDTO;
import com.tarssito.restmongo.repositories.UserRepository;
import com.tarssito.restmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(String id) {
		Optional<User> entity = repository.findById(id);
		return entity.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User entity) {
		return repository.insert(entity);
	}

	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User update(User entity) {
		User newEntity = repository.findById(entity.getId()).get();
		updateData(newEntity, entity);
		return repository.save(newEntity);
	}
	
	private void updateData(User newEntity, User entity) {
		newEntity.setName(entity.getName());
		newEntity.setEmail(entity.getEmail());
	}

	public User fromDTO(UserDTO entityDTO) {
		return new User(entityDTO.getId(), entityDTO.getName(), entityDTO.getEmail());
	}
}
