package fr.solutec.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.DemandeAmis;
import fr.solutec.entities.User;
import fr.solutec.repository.DemandeAmisRepository;
import fr.solutec.repository.UserRepository;

@RestController
@CrossOrigin("*")
public class DemandeAmisRest {

	@Autowired
	private DemandeAmisRepository demandeAmisRepos;
	@Autowired
	private UserRepository userRepos;

	@GetMapping("amis/{monId}")
	public List<User> allAmis(@PathVariable Long monId) {
		Iterable<DemandeAmis> dAmi = demandeAmisRepos.getMesAmis(monId);
		Optional<User> u = userRepos.findById(monId);
		if (u.isPresent()) {
			List<User> amis = new ArrayList<>();
			for (DemandeAmis demandeAmis : dAmi) {
				if (demandeAmis.getDemandeur() != u.get() /* && demandeAmis.getAcceptation() == true */) {
					amis.add(demandeAmis.getDemandeur());
				} else {
					amis.add(demandeAmis.getReceveur());
				}
			}
			return amis;
		} else {
			return null;
		}
	}

	@GetMapping("amis/demande/{monId}")
	public List<DemandeAmis> allDemande(@PathVariable Long monId) {
		return demandeAmisRepos.findByReceveurIdAndAcceptationFalse(monId);
	}

	@PostMapping("amis")
	public DemandeAmis createDemandeAmis(@RequestBody DemandeAmis d) {
		// d.setAcceptation(null);
		Optional<User> u = userRepos.findByLogin(d.getReceveur().getLogin());

		if (u.isPresent()) {
			d.setReceveur(u.get());

			return demandeAmisRepos.save(d);
		} else {
			return null;
		}
	}

	@DeleteMapping("amis/{idUserConnect}/{idUserASupp}")
	public boolean deleteDemandeAmis(@PathVariable Long idUserConnect, @PathVariable Long idUserASupp) {
		Optional<DemandeAmis> demande1 = demandeAmisRepos.findByReceveurIdAndDemandeurId(idUserConnect, idUserASupp);
		Optional<DemandeAmis> demande2 = demandeAmisRepos.findByDemandeurIdAndReceveurId(idUserConnect, idUserASupp);
		if (demande1.isPresent()) {
			demandeAmisRepos.delete(demande1.get());

		} else {
			demandeAmisRepos.delete(demande2.get());
		}
		return true;
	}

	@PatchMapping("amis/accepter/{idDemande}")
	public DemandeAmis accepterDemande(@PathVariable Long idDemande) {
		Optional<DemandeAmis> d = demandeAmisRepos.findById(idDemande);

		if (d.isPresent()) {

			d.get().setAcceptation(true);
			return demandeAmisRepos.save(d.get());
		} else {
			return null;
		}
	}

	@PatchMapping("amis/refuser/{idDemande}")
	public DemandeAmis refuserDemande(@PathVariable Long idDemande) {
		if (demandeAmisRepos.findById(idDemande).isPresent()) {
			Optional<DemandeAmis> d = demandeAmisRepos.findById(idDemande);
			d.get().setAcceptation(false);
			demandeAmisRepos.save(d.get());
			return d.get();
		} else {
			return null;
		}
	}
}
