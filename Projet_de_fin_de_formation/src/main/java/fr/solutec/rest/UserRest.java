package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping("token/add/{nbTokenAchetes}/{id}")
	public void addTokens(@PathVariable int nbTokenAchetes, @PathVariable Long id) {
		Optional<User> u = userRepos.findById(id);
			int newNbToken = u.get().getNbToken() + nbTokenAchetes;
			u.get().setNbToken(newNbToken);
	}
	
}