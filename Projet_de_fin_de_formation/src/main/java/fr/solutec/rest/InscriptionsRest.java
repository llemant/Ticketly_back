package fr.solutec.rest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Inscriptions;
import fr.solutec.entities.User;
import fr.solutec.repository.InscriptionsRepository;
import fr.solutec.repository.UserRepository;

@RestController
@CrossOrigin("*")
public class InscriptionsRest {

	@Autowired
	private InscriptionsRepository inscriptionRepos;

	@Autowired
	private UserRepository userRepos;

	@GetMapping("inscriptions")
	public Iterable<Inscriptions> getAllInscriptions() {
		return inscriptionRepos.findAll();
	}

	@PostMapping("inscription")
	public Inscriptions createInscription(@RequestBody Inscriptions i) {
		Optional<User> user = userRepos.findById(i.getAcheteur().getId());
		user.get().setNbToken(user.get().getNbToken() - (i.getEvent().getPrix() * i.getTicketQuantity()));
		userRepos.save(user.get());
		i.setAcheteur(user.get());

		Optional<User> orga = userRepos.findById(i.getEvent().getOrganisateur().getId());
		orga.get().setNbTokenEvent(
				(int) (orga.get().getNbTokenEvent() + 0.95 * (i.getEvent().getPrix() * i.getTicketQuantity())));

		return inscriptionRepos.save(i);
	}

	@GetMapping("inscriptions/{acheteur}")
	public Iterable<Inscriptions> getAllUserInscriptions(@PathVariable User acheteur) {
		return inscriptionRepos.findByAcheteur(acheteur);
	}

	@GetMapping("inscriptions/today/{acheteur}")
	public List<Inscriptions> getAllTodayUserInscriptions(@PathVariable User acheteur) {
		return inscriptionRepos.getInscriptionEventToday(acheteur.getId());
	}

	@GetMapping("inscriptions/futur/{acheteur}")
	public List<Inscriptions> getAllFuturUserInscriptions(@PathVariable User acheteur) {
		return inscriptionRepos.getInscriptionEventFutur(acheteur.getId());
	}

	@GetMapping("inscriptions/past/{acheteur}")
	public List<Inscriptions> getAllPastUserInscriptions(@PathVariable User acheteur) {
		return inscriptionRepos.getInscriptionEventPast(acheteur.getId());
	}
}
