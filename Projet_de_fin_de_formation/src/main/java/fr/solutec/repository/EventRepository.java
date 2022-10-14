package fr.solutec.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Event;

public interface EventRepository extends CrudRepository<Event, Long> {
	
	//public Iterable<Event> findByEventDateAfter(Date d);

	//public Iterable<Event> findByEventDateBefore(Date d);
	
	public Iterable<Event> findByTitre(String titre);
	
	public Iterable<Event> findByGenre(String genre);
	
	public Iterable<Event> findByLieu(String lieu);
	
	//public Iterable<Event> finBydateandHeure(Date date, String heure);
	

}
