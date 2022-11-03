package fr.solutec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Inscriptions;
import fr.solutec.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

	public Optional<User> findByLogin(String login);
	
	public Optional<User> findByEmail(String email);

	public Optional<User> findByLoginAndPassword(String login, String password);
	
	@Query(value = "SELECT u FROM User u WHERE u.login = ?1")
	public Optional<User> ExistingLogin(String login);

}

