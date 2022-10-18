package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.User;
import fr.solutec.repository.UserRepository;

@RestController
@CrossOrigin("*")
public class UserRest {
	@Autowired
	private UserRepository userRepos;

	@GetMapping("user")
	public Iterable<User> getAllUser() {
		return userRepos.findAll();
	}

	@PostMapping("user")
	public User createUser(@RequestBody User u) {
		u.setOrganisateur(false);
		return userRepos.save(u);
	}

	@PostMapping("organisateur")
	public User createOrganiser(@RequestBody User u) {
		u.setOrganisateur(true);
		return userRepos.save(u);
	}

	@PutMapping("user/{id}")
	public User modiUser(@RequestBody User u, @PathVariable Long id) {
		u.setId(id);
		return userRepos.save(u);

	}

	@GetMapping("user/login/{login}")
	public Optional<User> getOneUserByLogin(@PathVariable String login) {
		return userRepos.findByLogin(login);
	}

	@GetMapping("user/email/{email}")
	public Optional<User> getOneUserByEmail(@PathVariable String email) {
		return userRepos.findByEmail(email);
	}

	@GetMapping("user/{id}")
	public Optional<User> getOneUser(@PathVariable Long id) {
		return userRepos.findById(id);
	}

	@PostMapping("login")
	public Optional<User> Connection(@RequestBody User u) {

		Optional<User> user = userRepos.findByLoginAndPassword(u.getLogin(), u.getPassword());
		if (user.isPresent()) {
			return user;
		} else {
			return null;
		}
	}

	@PatchMapping("token/add/{nbTokenAchetes}/{id}")
	public int addTokens(@PathVariable int nbTokenAchetes, @PathVariable Long id) {
		Optional<User> u = userRepos.findById(id);
		int newNbToken = u.get().getNbToken() + nbTokenAchetes;
		User newUser = u.get();
		newUser.setNbToken(newNbToken);
		final User updatedUser = userRepos.save(newUser);
		return newNbToken;
	}

	@DeleteMapping("account/{login}")
	public boolean deleteAccount(@PathVariable String login) {
		if (getOneUserByLogin(login).isPresent()) {
			userRepos.delete(getOneUserByLogin(login).get());
			return true;
		} else {
			return false;
		}
	}

	@PutMapping("modif/user/{login}")
	public User editUser(@RequestBody User u, @PathVariable String login) {
		Long id = getOneUserByLogin(login).get().getId();
		u.setId(id);
		u.setOrganisateur(false);
		return userRepos.save(u);
	}
	
	@PutMapping("modif/orga/{login}")
	public User editOrga(@RequestBody User u, @PathVariable String login) {
		Long id = getOneUserByLogin(login).get().getId();
		u.setId(id);
		u.setOrganisateur(true);
		return userRepos.save(u);
	}

}