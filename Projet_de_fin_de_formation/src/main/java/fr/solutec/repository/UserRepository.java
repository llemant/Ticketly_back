package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

	public Optional<User> findByLogin(String login);
	
	public Optional<User> findByEmail(String email);

	public Optional<User> findByLoginAndPassword(String login, String password);

}