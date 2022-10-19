package fr.solutec.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Avantage;
import fr.solutec.repository.AchatsRepository;
import fr.solutec.repository.AvantageRepository;
import fr.solutec.repository.UserRepository;

@RestController
@CrossOrigin("*")

public class AvantageRest {
	@Autowired
	private AvantageRepository avantageRepos;
	
	@Autowired
	private AchatsRepository achatsRepos;
	
	@Autowired
	private UserRepository userRepos;
	
	
	@GetMapping("avantages")
	public Iterable<Avantage> getAllAvantages() {
		return avantageRepos.findAll();
	}
	
}
