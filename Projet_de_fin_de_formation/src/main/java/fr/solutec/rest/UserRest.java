package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
			User newUser = u.get();
			int newNbToken = newUser.getNbToken() + nbTokenAchetes;
			int nbPointsAdd = (int)Math.round(0.2*nbTokenAchetes);
			int newNbPoints = newUser.getNbPoint() + nbPointsAdd;
			newUser.setNbToken(newNbToken);
			newUser.setNbPoint(newNbPoints);
			final User updatedUser = userRepos.save(newUser);
			return newNbToken;
	}

	@PatchMapping("token/pay/{totalPaye}/{id}")
	public int subtractTokens(@PathVariable int totalPaye, @PathVariable Long id) {
		Optional<User> u = userRepos.findById(id);
			User newUser = u.get();
			int newNbToken = newUser.getNbToken() - totalPaye;
			newUser.setNbToken(newNbToken);
			final User updatedUser = userRepos.save(newUser);
			return newNbToken;
	}
	
	@PatchMapping("points/pay/{totalPaye}/{id}")
	public int subtractPoints(@PathVariable int totalPayePoints, @PathVariable Long id) {
		Optional<User> u = userRepos.findById(id);
			User newUser = u.get();
			int newNbPoints = newUser.getNbPoint() - totalPayePoints;
			newUser.setNbPoint(newNbPoints);
			final User updatedUser = userRepos.save(newUser);
			return newNbPoints;
	}
		
}