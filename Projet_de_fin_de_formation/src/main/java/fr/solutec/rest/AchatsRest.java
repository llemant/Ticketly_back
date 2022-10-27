package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import fr.solutec.entities.Achats;
import fr.solutec.entities.Avantage;
import fr.solutec.repository.AchatsRepository;
import fr.solutec.repository.AvantageRepository;
import fr.solutec.repository.UserRepository;

@RestController
@CrossOrigin("*")

public class AchatsRest {
	@Autowired
	private AchatsRepository achatsRepos;

	@Autowired
	private UserRepository userRepos;

	@Autowired
	private AvantageRepository avantageRepos;

	@PostMapping("achat-bonus")
	public Achats nouvelAchat(@RequestBody Achats a) {

		Optional<Avantage> avtg = avantageRepos.findById(a.getAvantage().getId());
		if (avtg.isPresent()) {
			a.setTotal(avtg.get().getPrix() * a.getQuantite());
			return achatsRepos.save(a);
		} else {
			return a = null;
		}
	}

	@GetMapping("achats-bonus")
	public Iterable<Achats> achats() {
		return achatsRepos.findAll();
	}
}
