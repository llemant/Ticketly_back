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

import fr.solutec.entities.Event;
import fr.solutec.entities.Lieu;
import fr.solutec.entities.User;
import fr.solutec.repository.LieuRepository;
import fr.solutec.repository.UserRepository;


@RestController
@CrossOrigin("*")
public class LieuRest {
	@Autowired
	private LieuRepository lieuRepos;
	
	@PostMapping("lieu")
	public Lieu createLieu(@RequestBody Lieu l) {
		return lieuRepos.save(l);
	}
	
	@GetMapping("lieu")
	public Iterable<Lieu> getAllLieu() {
		return lieuRepos.findAll();
	}
	
	@GetMapping("lieu/{ville}")
	public Optional<Lieu> getAllLieuBy(@PathVariable String ville) {
		return lieuRepos.findByVille(ville);
	}
		
	@PutMapping("lieu/{id}")
	public Lieu modiLieu(@RequestBody Lieu l, @PathVariable Long id) {
		l.setId(id);
		return lieuRepos.save(l);
	}
	}
