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

@RestController
@CrossOrigin("*")
public class InscriptionsRest {
	
	@Autowired
	private InscriptionsRepository inscriptionRepos;
	
	@GetMapping("inscriptions")
	public Iterable<Inscriptions> getAllInscriptions() {
		return inscriptionRepos.findAll();
	}
	
	@PostMapping("inscription")
	public Inscriptions createInscription(@RequestBody Inscriptions i) {
		return inscriptionRepos.save(i);
	}
	
	@GetMapping("inscriptions/{acheteur}")
	public Iterable<Inscriptions> getAllUserInscriptions(@PathVariable User acheteur) {		
		return inscriptionRepos.findByAcheteur(acheteur);
	}
	
	//marche pas, joel est censé m'aider à regler ça jeudi matin
	@GetMapping("inscriptions/today/{acheteur}")
	public List<Inscriptions> getAllTodayUserInscriptions(@PathVariable User acheteur) {	
		ZoneId zonedId = ZoneId.of( "Europe/Paris" );
        LocalDate today = LocalDate.now( zonedId );
        
        System.out.println( "today : " + today );
        System.out.println("valueOfToday : " + java.sql.Date.valueOf(today));
        
		List<Inscriptions> inscriptions = new ArrayList<>();
		for (Inscriptions i: getAllUserInscriptions(acheteur)) {
			
			System.out.println("date event : " + i.getEvent().getDate());
			
			if (i.getEvent().getDate() == java.sql.Date.valueOf(today)) {
				inscriptions.add(i);
			}
		}
		return inscriptions;
	}
	
	
}
