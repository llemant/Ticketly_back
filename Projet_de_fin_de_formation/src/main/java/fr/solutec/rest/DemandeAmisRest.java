package fr.solutec.rest;

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
import fr.solutec.repository.DemandeAmisRepository;

@RestController
@CrossOrigin("*")
public class DemandeAmisRest {

	@Autowired
	private DemandeAmisRepository demandeAmisRepos;

	@GetMapping("amis/{monId}")
	public Iterable<DemandeAmis> allAmis(@PathVariable Long monId) {
		return demandeAmisRepos.getMesAmis(monId);
	}

	@PostMapping("amis")
	public DemandeAmis createDemandeAmis(@RequestBody DemandeAmis d) {
		d.setAcceptation(null);
		return demandeAmisRepos.save(d);
	}

	@DeleteMapping("amis/{idDemande}")
	public boolean deleteDemandeAmis(@PathVariable Long idDemande) {
		if (demandeAmisRepos.findById(idDemande).isPresent()) {
			demandeAmisRepos.delete(demandeAmisRepos.findById(idDemande).get());
			return true;
		} else {
			return false;
		}
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
